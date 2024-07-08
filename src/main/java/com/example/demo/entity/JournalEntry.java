package com.example.demo.entity;

import java.time.LocalDateTime;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.Data;


@Document(collection = "Journal")
@Data
public class JournalEntry {

    @Id 
    private ObjectId id;

    @Nonnull
    private String title;

    private String content;

    private LocalDateTime date;

   
    
    
}
