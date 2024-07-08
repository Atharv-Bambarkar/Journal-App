package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class JournalEntryService {
    
    @Autowired
    private JournalEntryRepository JournalEntryRepository;



    public void saveEntry(JournalEntry entry) {
        try {
            entry.setDate(LocalDateTime.now());
            JournalEntryRepository.save(entry);
        } catch (Exception e) {
           log.error("Error saving entry", e);
        }
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