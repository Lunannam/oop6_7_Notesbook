package Views;
import java.util.List;
import java.util.Scanner;
import controller.NoteController;
import model.Note;


public class ViewUser {

    private NoteController noteController;

    public ViewUser(NoteController noteController) {
        this.noteController = noteController;
    }

    /**
     * 
     */
    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("ENETER COMMAND: ");
            try{
            com = Commands.valueOf(command);
            }
            catch (IllegalArgumentException e) {
                System.out.println("UNKNOWM COMMAND");
            }
            if (com == Commands.EXIT) 
            return;
            try {
            switch (com) {
                case CREATE:
                Note note = setNote(false);
                    noteController.saveNote(note);
                    break;
                case READ:
                    String id = prompt("id : ");
                   
                        Note readNote = noteController.readNote(id);
                        System.out.println(readNote);
                    break;
                case LIST:
                    List<Note> noteList = noteController.readNoteList();
                    for (Note u  : noteList) {
                        System.out.println(u);
                    }
                    break;
                case UPDATE:
                        Note updatedNote = setNote(true);
                        noteController.updateNote(updatedNote);
                    }
                }
                catch (Exception e) {
                System.out.println(e.getMessage());
                }    
            
            }
        }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Note setNote(boolean forUpdate){
        String idString = "";
        if (forUpdate) {
             idString= prompt("Id: ");
        }
        
        String date = prompt("Date: ");
        String title = prompt("Title: ");
        String bodyNote = prompt("Comment: ");
        if(forUpdate){
            return new Note(idString, date, title, bodyNote);
        }
            return new Note( idString, date, title, bodyNote);
    }
}
