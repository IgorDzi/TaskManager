package service;

import data.Priority;
import data.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Task manager.
 */
public class TaskManager {
    /**
     * Gets tasks.
     *
     * @return the tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    private List<Task> tasks;

    /**
     * Instantiates a new Task manager.
     *
     * @param tasks the tasks
     */
    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add task.
     *
     * @param newTask the new task
     */
    public void addTask(Task newTask){
        tasks.add(newTask);
    }

    /**
     * Remove task.
     *
     * @param taskToRemove the task to remove
     */
    public void removeTask(Task taskToRemove){
        tasks.remove(taskToRemove);
    }

    /**
     * Gets task by id.
     *
     * @param taskId the task id
     * @return the task by id
     */
    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    /**
     * Filter tasks by status list.
     *
     * @param status the status
     * @return the list
     */
    public List<Task> filterTasksByStatus(boolean status) {
        return tasks.stream()
                .filter(task -> task.isCompleted() == status)
                .collect(Collectors.toList());
    }

    /**
     * Filter tasks by priority list.
     *
     * @param priority the priority
     * @return the list
     */
    public List<Task> filterTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    /**
     * Sort tasks by due date list.
     *
     * @return the list
     */
    public List<Task> sortTasksByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    /**
     * Generate task report string.
     *
     * @return the string
     */
    public String generateTaskReport() {
        long totalTasks = tasks.size();

        Map<Priority, Long> tasksByPriority = tasks.stream()
                .collect(Collectors.groupingBy(Task::getPriority, Collectors.counting()));

        long completedTasks = tasks.stream()
                .filter(Task::isCompleted)
                .count();

        long overdueTasks = tasks.stream()
                .filter(task -> task.isLate() && !task.isCompleted())
                .count();

        StringBuilder report = new StringBuilder();
        report.append("Tasks Report:\n");
        report.append("Total Tasks: ").append(totalTasks).append("\n");

        tasksByPriority.forEach((priority, count) ->
                report.append("Tasks with Priority ").append(priority).append(": ").append(count).append("\n"));
        report.append("Completed Tasks: ").append(completedTasks).append("\n");
        report.append("Overdue Tasks: ").append(overdueTasks).append("\n");

        return report.toString();
    }

    }




