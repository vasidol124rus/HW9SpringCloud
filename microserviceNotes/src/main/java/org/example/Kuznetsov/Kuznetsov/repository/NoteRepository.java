package org.example.Kuznetsov.Kuznetsov.repository;

import org.example.Kuznetsov.Kuznetsov.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
