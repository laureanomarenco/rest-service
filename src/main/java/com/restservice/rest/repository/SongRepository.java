package com.restservice.rest.repository;

import com.restservice.rest.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongRepository extends MongoRepository<Song, String> {
    @Query(value = "{title: ?0}")
    List<Song> findByTitle(String title);
}
