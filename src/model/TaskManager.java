package model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public List<Task> getTasks() { return tasks; }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public void updateTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, updatedTask);
            saveTasks();
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        }
    }

    public void loadTasks() {
        tasks.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String priority = parts[0].trim();
                    String description = parts[1].trim();
                    Date dueDate = dateFormat.parse(parts[2].replace("Due:", "").trim());
                    tasks.add(new Task(priority, description, dueDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
