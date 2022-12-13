package com.restservice.rest.global.model;

import com.restservice.rest.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    private String songId;
    private String title;
    private String author;
    private int year;
    private String description;
    private String lyrics;
    private String chords;

    private User user;

}