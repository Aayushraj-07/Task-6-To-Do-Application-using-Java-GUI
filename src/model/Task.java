package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String description;
    private String priority;
    private Date dueDate;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Task(String priority, String description, Date dueDate) {
        this.priority = priority;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public Date getDueDate() { return dueDate; }

    public void setDescription(String description) { this.description = description; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return priority + " | " + description + " | Due: " + dateFormat.format(dueDate);
    }
}
