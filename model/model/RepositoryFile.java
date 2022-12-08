package model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private  List<Note> notes;
    private NoteMapper mapper = new NoteMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Note note) {

        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }


    private void saveNotes(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item  : notes) {
          lines.add(mapper.map(item));  
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public Note updateNote(Note note) throws Exception {
        List<Note> notes = getAllNotes();
        Note foundNote = findNoteById(notes, note.getId());
        foundNote.setDate(note.getDate());
        foundNote.setTitle(note.getTitle());
        foundNote.setBodyNote(note.getBodyNote());
        saveNotes(notes);
        return foundNote;
    }

    private Note findNoteById(List<Note> notes, String id) {
        return null;
    }


    public Note readNote(String noteId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    
   
 }
