package view;

import javax.swing.*;
import java.awt.*;

public class ToDoAppView extends JFrame {
    public DefaultListModel<String> taskListModel = new DefaultListModel<>();
    public JList<String> taskList = new JList<>(taskListModel);
    public JTextField taskField = new JTextField();
    public JComboBox<String> priorityBox = new JComboBox<>(new String[]{"Low", "Medium", "High"});
    public JSpinner dateSpinner;
    public JButton addButton = new JButton("Add Task");
    public JButton editButton = new JButton("Edit Task");
    public JButton deleteButton = new JButton("Delete Task");

    public ToDoAppView() {
        super("Advanced To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Task List
        taskList.setCellRenderer(new PriorityCellRenderer());
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Date Picker
        dateSpinner = new JSpinner(new SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(dateEditor);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(1, 4));
        inputPanel.add(taskField);
        inputPanel.add(priorityBox);
        inputPanel.add(dateSpinner);
        inputPanel.add(addButton);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Top panel
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
