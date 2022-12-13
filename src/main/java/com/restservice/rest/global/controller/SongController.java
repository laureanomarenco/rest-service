package com.restservice.rest.global.controller;

import com.restservice.rest.global.service.SongService;
import com.restservice.rest.global.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song createSong(@RequestBody Song song){
        return service.addSong(song);
    }
    @GetMapping
    public List<Song> getSongs(){
        return service.findAllSongs();
    }
    @GetMapping("/{songId}")
    public Song getSongById(@PathVariable String songId){
        return service.findSongById(songId);
    }
    @GetMapping("/title/{title}")
    public List<Song> getSongByTitle(@PathVariable String title){
        return service.findSongByTitle(title);
    }
    @PutMapping
    public Song updateSong(@RequestBody Song song){
        return service.updateSong(song);
    }
    @DeleteMapping("/{songId}")
    public String deleteSong(@PathVariable String songId){
        return service.deleteSong(songId);
    }
}
