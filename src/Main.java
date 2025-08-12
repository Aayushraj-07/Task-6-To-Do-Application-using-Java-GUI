import controller.ToDoAppController;
import model.TaskManager;
import view.ToDoAppView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TaskManager model = new TaskManager();
            ToDoAppView view = new ToDoAppView();
            new ToDoAppController(model, view);
            view.setVisible(true);
        });
    }
}
