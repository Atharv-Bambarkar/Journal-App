package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;
@Service
public class JournalEntryService {
    
    @Autowired
    private JournalEntryRepository JournalEntryRepository;


    public void saveEntry(JournalEntry entry) {
        JournalEntryRepository.save(entry);
    }

    public List<JournalEntry> getJournalEntries() {
        return JournalEntryRepository.findAll();
    }
    
    public Optional<JournalEntry> getEntryById(ObjectId id) {
        return JournalEntryRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id) {
        JournalEntryRepository.deleteById(id);
    }



}
// controller -----> service -----> repository