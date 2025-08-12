package controller;

import model.Task;
import model.TaskManager;
import view.ToDoAppView;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class ToDoAppController {
    private final TaskManager model;
    private final ToDoAppView view;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public ToDoAppController(TaskManager model, ToDoAppView view) {
        this.model = model;
        this.view = view;
        model.loadTasks();
        refreshTaskList();
        initListeners();
    }

    private void refreshTaskList() {
        view.taskListModel.clear();
        for (Task task : model.getTasks()) {
            view.taskListModel.addElement(task.toString());
        }
    }

    private void initListeners() {
        view.addButton.addActionListener(e -> {
            String desc = view.taskField.getText().trim();
            if (!desc.isEmpty()) {
                model.addTask(new Task(
                        (String) view.priorityBox.getSelectedItem(),
                        desc,
                        (java.util.Date) view.dateSpinner.getValue()
                ));
                refreshTaskList();
                view.taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(view, "Please enter a task.");
            }
        });

        view.editButton.addActionListener(e -> {
            int index = view.taskList.getSelectedIndex();
            if (index != -1) {
                Task currentTask = model.getTasks().get(index);
                view.taskField.setText(currentTask.getDescription());
                view.priorityBox.setSelectedItem(currentTask.getPriority());
                view.dateSpinner.setValue(currentTask.getDueDate());

                view.addButton.setText("Save Edit");
                view.addButton.addActionListener(ev -> {
                    model.updateTask(index, new Task(
                            (String) view.priorityBox.getSelectedItem(),
                            view.taskField.getText().trim(),
                            (java.util.Date) view.dateSpinner.getValue()
                    ));
                    refreshTaskList();
                    view.addButton.setText("Add Task");
                    view.taskField.setText("");
                });
            } else {
                JOptionPane.showMessageDialog(view, "Select a task to edit.");
            }
        });

        view.deleteButton.addActionListener(e -> {
            int index = view.taskList.getSelectedIndex();
            if (index != -1) {
                model.deleteTask(index);
                refreshTaskList();
            } else {
                JOptionPane.showMessageDialog(view, "Select a task to delete.");
            }
        });
    }
}
