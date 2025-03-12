package com.pushp.notesapp.service;


//methods: addNote, getAllNotes, deleteAllNotes, deleteNoteById, updateNoteById, getNoteById

import com.pushp.notesapp.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    Note addNote(Note note);

    List<Note> getAllNotes();

    Optional<Note> getNoteById(Long id);

    void deleteAllNotes();

    void deleteNoteById(Long id);

    Note updateNote(Long id, Note note);

}




//Use Optional<Note> for getNoteById
//Since an ID might not exist, returning an Optional<Note> helps avoid null pointer exceptions.


//Generally, delete operations do not return the deleted entity. Instead, they return void or a boolean to indicate success.

