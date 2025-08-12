# Task-6-To-Do-Application-using-Java-GUI

# Java Swing To-Do App

Company: Elevate Labs

Type: Internship Project

Objective: Build a Java GUI To-Do List with persistence, editing, priorities, and deadlines, following loose coupling and MVC principles.

**Features**

-> Add Tasks with priority level and deadline.

-> Edit Tasks – modify existing tasks in place.

-> Delete Tasks – remove selected tasks.

-> Priority Levels – color-coded:

  🟢 Low

  🟠 Medium

  🔴 High

-> Deadlines – select due dates with a date picker (JSpinner).

-> Data Persistence – tasks are saved in tasks.txt automatically.

-> MVC Architecture – clean separation of Model, View, and Controller for maintainability.

**Tools & Technologies**

-> Java SE

-> Java Swing (built-in GUI library)

-> IntelliJ IDEA 

**Project Structure**

   src/
   
    ├── model/
    
    │   ├── Task.java
    
    │   └── TaskManager.java
    
    ├── view/
    
    │   ├── ToDoAppView.java
    
    │   └── PriorityCellRenderer.java
    
    ├── controller/
    
    │   └── ToDoAppController.java
    
    └── Main.java
    
    └── tasks.txt

    
**How It Works**

1. Main.java :- Launches the application.

2. Instantiates the TaskManager (Model), ToDoAppView (View), and ToDoAppController (Controller).

3. Model (model package)

      -> Task → Represents a task with priority, description, and due date.

      -> TaskManager → Handles adding, editing, deleting, loading, and saving tasks to tasks.txt.

4. View (view package)

      -> ToDoAppView → Builds the GUI components.

      -> PriorityCellRenderer → Colors tasks based on their priority.

5. Controller (controller package)

      -> ToDoAppController → Handles all event listeners, updates model data, and refreshes the view.

6. Data Persistence
      -> Tasks are stored in a local file: tasks.txt.

On startup, the app automatically loads tasks from this file.

When tasks are added, edited, or deleted → file is updated instantly.



