package com.restservice.rest.global.service;

import com.restservice.rest.global.model.Song;
import com.restservice.rest.global.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SongService {
    @Autowired
    private SongRepository repository;

    public Song addSong(Song song){
        song.setSongId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(song);
    }

    public List<Song> findAllSongs(){
        return repository.findAll();
    }

    public Song findSongById(String songId){
        return repository.findById(songId).get();
    }

    public List<Song> findSongByTitle(String title){
        return repository.findByTitle(title);
    }

    public Song updateSong(Song songRequest){
        Song existingSong = repository.findById(songRequest.getSongId()).get();
        existingSong.setTitle(songRequest.getTitle());
        existingSong.setAuthor(songRequest.getAuthor());
        existingSong.setDescription(songRequest.getDescription());
        existingSong.setLyrics(songRequest.getLyrics());
        existingSong.setChords(songRequest.getChords());
        existingSong.setYear(songRequest.getYear());

        return repository.save(existingSong);
    }

    public String deleteSong(String songId){
        repository.deleteById(songId);
        return "Song deleted";
    }
}
