package org.example.Kuznetsov.Kuznetsov.controller;

import lombok.RequiredArgsConstructor;
import org.example.Kuznetsov.Kuznetsov.entity.Note;
import org.example.Kuznetsov.Kuznetsov.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }

        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
