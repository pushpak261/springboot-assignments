package com.pushp.notesapp.service;

import com.pushp.notesapp.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pushp.notesapp.repository.NoteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository nr;

    @Override
    public Note addNote(Note note) {
        return nr.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return nr.findAll();
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return nr.findById(id);
    }

    @Override
    public void deleteAllNotes() {
        nr.deleteAll();
    }

    @Override
    public void deleteNoteById(Long id) {
        nr.deleteById(id);
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        Optional<Note> existingNote = nr.findById(id);

        if (existingNote.isPresent()) {
            Note note = existingNote.get();
            note.setTitle(updatedNote.getTitle());
            note.setContent(updatedNote.getContent());
            return nr.save(note);
        } else {
            throw new RuntimeException("Note not found with id: " + id);
        }
    }

}
