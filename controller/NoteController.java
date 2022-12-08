package controller;

import model.Repository;
import model.Note;

import java.util.List;

public class NoteController {
    private static Repository repository;

    public NoteController(Repository repository) {
        NoteController.repository = repository;
    }

    public void saveNote(Note note) throws Exception {
        validateNote(note);
        repository.createNote(note);
    }

    public Note readNote(String noteId) throws Exception {
                return repository.readNote(noteId);
            }

    public List<Note> readNoteList(){
        return repository.getAllNotes();
    }

    public Note updateNote(Note note) throws Exception{
        validateNote(note);
        return repository.updateNote(note);
    }

    private static void validateNote(Note note) throws Exception{
        if(note.getTitle().isEmpty()){
            throw new Exception("Note not found");
        }
        if(note.getBodyNote().isEmpty()){
            throw new Exception(" No comments added");
        }
        if(note.getDate().isEmpty()){
            throw new Exception("Date not found");
        }
    }
}