package ui;

import data.DailyTask;
import data.Priority;
import data.ProjectTask;
import data.Task;
import service.JsonTaskProcessor;
import service.TaskProcessor;
import service.XmlTaskProcessor;
import service.TaskManager;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create initial tasks
        List<Task> initialTasks = List.of(
                new DailyTask(1, "Morning Routine", "Complete morning tasks", null, Priority.HIGH),
                new ProjectTask(2, "Project Task", "Complete project task", LocalDate.now().plusDays(5), Priority.MEDIUM),
                new Task(3, "Generic Task", "Complete generic task", LocalDate.now().plusDays(3), Priority.LOW)
        );

        // Create TaskManager with initial tasks
        TaskManager taskManager = new TaskManager(initialTasks);

        // Display initial tasks
        System.out.println("Initial Tasks:");
        taskManager.getTasks().forEach(System.out::println);

        // Perform task completion
        taskManager.getTaskById(1).completeTask();

        // Display tasks after completing task
        System.out.println("\nTasks after adding New Task:");
        taskManager.getTasks().forEach(System.out::println);

        // Reset DailyTask
        Task dailyTask = taskManager.getTaskById(1);
        if (dailyTask instanceof DailyTask dailyTaskInstance) {
            dailyTaskInstance.resetTask();

            // Display updated DailyTask details
            System.out.println("\nDailyTask after Reset:");
            System.out.println(dailyTaskInstance);
        }

        // Perform priority check for ProjectTask
        Task projectTask = taskManager.getTaskById(2);
        if (projectTask instanceof ProjectTask projectTaskInstance) {
            projectTaskInstance.priorityCheck();

            // Display updated ProjectTask details
            System.out.println("\nProjectTask after Priority Check:");
            System.out.println(projectTaskInstance);
        }


        // Add a new task
        Task newTask = new Task(4, "New Task", "Complete new task", LocalDate.now().plusDays(2), Priority.HIGH);
        taskManager.addTask(newTask);


        // Display tasks after adding new task
        System.out.println("\nTasks after adding New Task:");
        taskManager.getTasks().forEach(System.out::println);

        // Remove a task
        Task taskToRemove = taskManager.getTaskById(3);
        taskManager.removeTask(taskToRemove);

        // Display tasks after removing a task
        System.out.println("\nTasks after removing Generic Task:");
        taskManager.getTasks().forEach(System.out::println);

        // Filter tasks by completed status
        List<Task> completedTasks = taskManager.filterTasksByStatus(true);
        System.out.println("\nCompleted Tasks:");
        completedTasks.forEach(System.out::println);

        // Filter tasks by priority
        List<Task> highPriorityTasks = taskManager.filterTasksByPriority(Priority.HIGH);
        System.out.println("\nHigh Priority Tasks:");
        highPriorityTasks.forEach(System.out::println);

        // Sort tasks by due date
        List<Task> sortedTasks = taskManager.sortTasksByDueDate();
        System.out.println("\nTasks Sorted by Due Date:");
        sortedTasks.forEach(System.out::println);

        // Generate and display task report
        String taskReport = taskManager.generateTaskReport();
        System.out.println("\nTask Report:");
        System.out.println(taskReport);

        // Save tasks to JSON file
        TaskProcessor jsonTaskProcessor = new JsonTaskProcessor();
        jsonTaskProcessor.saveTasks(taskManager.getTasks(), "tasks.json");

        // Import tasks from JSON file
        List<Task> importedTasksJson = jsonTaskProcessor.importTasks("tasks.json");

        // Display imported tasks from JSON
        System.out.println("\nImported Tasks from JSON:");
        importedTasksJson.forEach(System.out::println);

        // Save tasks to XML file
        TaskProcessor xmlTaskProcessor = new XmlTaskProcessor();
        xmlTaskProcessor.saveTasks(taskManager.getTasks(), "tasks.xml");

        // Import tasks from XML file
        List<Task> importedTasksXml = xmlTaskProcessor.importTasks("tasks.xml");

        // Display imported tasks from XML
        System.out.println("\nImported Tasks from XML:");
        importedTasksXml.forEach(System.out::println);
    }
}
