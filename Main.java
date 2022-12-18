import controller.NoteController;
import model.FileOperation;
import model.FileOperationManager;
import model.Repository;
import model.RepositoryFile;
import Views.ViewUser;


class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationManager("note.txt");
        Repository repository = new RepositoryFile(fileOperation);
        NoteController noteController = new NoteController(repository);
        ViewUser view = new ViewUser(noteController);
        view.run();
    }
}


