package com.example.demo.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.JournalEntry;


@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{
    
}
