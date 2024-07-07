package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalEntryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController

@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
private JournalEntryService JournalEntryService;
    


@GetMapping()
public ResponseEntity<?> getJournalEntries() {
   List<JournalEntry> all = JournalEntryService.getJournalEntries();
   if (all!= null && !all.isEmpty()) {
      return new ResponseEntity<>(all,HttpStatus.OK);
   }
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping()
 public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry) {

   try {
      entry.setDate(LocalDateTime.now());
    JournalEntryService.saveEntry(entry);
     return new ResponseEntity<>(entry,HttpStatus.CREATED);
   } catch (Exception e) {
      return new ResponseEntity<>(entry,HttpStatus.BAD_REQUEST);
   }
   
 }


@GetMapping("id/{myId}")
 public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId) {
   Optional <JournalEntry> entry = JournalEntryService.getEntryById(myId);
   if (entry.isPresent()) {
     return new ResponseEntity<>(entry.get(),HttpStatus.OK);
   } else {
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      
   }
}


@DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
       JournalEntryService.deleteEntryById(myId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

@PutMapping("id/{myId}")
public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry newentry) {
  JournalEntry old = JournalEntryService.getEntryById(myId).orElse(null);
  if (old != null) {
   old.setTitle(newentry.getTitle() != null && !newentry.getTitle().equals("")?newentry.getTitle():old.getTitle());
   old.setContent(newentry.getContent() != null && !newentry.getContent().equals("")?newentry.getContent():old.getContent());
   JournalEntryService.saveEntry(old);
   return new ResponseEntity<>(old,HttpStatus.OK);
  }
  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   
    
}

}
