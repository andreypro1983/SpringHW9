package ru.geekbrains.SpringHW9Microservice1.service;

import ru.geekbrains.SpringHW9Microservice1.model.Note;

import java.util.List;


public interface NoteService {
    List<Note> findAll();

    Note createNote(Note note);

    Note findNoteById(Long id);

    Note updateNoteById(Long id, Note note);

    Boolean deleteNoteById(Long id);
}
