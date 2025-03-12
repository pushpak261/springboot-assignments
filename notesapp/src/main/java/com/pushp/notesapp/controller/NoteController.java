package com.pushp.notesapp.controller;


//methods: addNote, getAllNotes, getNoteById, updateNote, deleteAllNotes, deleteNoteById

import com.pushp.notesapp.entity.Note;
import com.pushp.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService ns;

    @PostMapping
    public Note addNote(@RequestBody Note note){
        return ns.addNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return ns.getAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id){
        return ns.getNoteById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote){
        return ns.updateNote(id, updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable Long id){
        ns.deleteNoteById(id);
    }

    @DeleteMapping
    public void deleteAllNotes(){
        ns.deleteAllNotes();
    }

}
