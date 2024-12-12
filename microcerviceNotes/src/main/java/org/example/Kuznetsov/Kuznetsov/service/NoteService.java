package org.example.Kuznetsov.Kuznetsov.service;

import org.example.Kuznetsov.Kuznetsov.entity.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Note note);
    void deleteNote(Long id);
}