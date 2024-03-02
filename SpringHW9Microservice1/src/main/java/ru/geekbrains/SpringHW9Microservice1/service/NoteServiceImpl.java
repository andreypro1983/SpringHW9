package ru.geekbrains.SpringHW9Microservice1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringHW9Microservice1.model.Note;
import ru.geekbrains.SpringHW9Microservice1.repository.NoteRepo;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private NoteRepo noteRepo;

    //получение всех заметок
    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    //создание новой заметки
    @Override
    public Note createNote(Note note) {
        noteRepo.save(note);
        return note;
    }

    //получение заметки по id
    @Override
    public Note findNoteById(Long id) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        return optionalNote.orElse(null);
    }

    //обновление заметки по id
    @Override
    public Note updateNoteById(Long id, Note note) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        if (optionalNote.isPresent()) {
            Note updatedNote = optionalNote.get();
            updatedNote.setTitle(note.getTitle());
            updatedNote.setDescription(note.getDescription());
            noteRepo.save(updatedNote);
            return updatedNote;
        }
        return null;
    }

    //удаление заметки по id
    @Override
    public Boolean deleteNoteById(Long id) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        optionalNote.ifPresent(noteRepo::delete);
        return optionalNote.isPresent();
    }

}
