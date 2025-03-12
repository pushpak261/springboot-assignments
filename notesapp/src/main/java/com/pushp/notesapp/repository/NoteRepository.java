package com.pushp.notesapp.repository;

import com.pushp.notesapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaMethods: save, findAll, findById, deleteById

public interface NoteRepository extends JpaRepository<Note, Long> {

}
