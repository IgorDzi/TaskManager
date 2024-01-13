package service;

import data.Priority;
import data.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task newTask){
        tasks.add(newTask);
    }
    public void removeTask(Task taskToRemove){
        tasks.remove(taskToRemove);
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }
    public List<Task> filterTasksByStatus(boolean status) {
        return tasks.stream()
                .filter(task -> task.isCompleted() == status)
                .collect(Collectors.toList());
    }

    public List<Task> filterTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }
    public List<Task> sortTasksByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

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
        report.append("Task Report:\n");
        report.append("Total Tasks: ").append(totalTasks).append("\n");

        tasksByPriority.forEach((priority, count) ->
                report.append("Tasks with Priority ").append(priority).append(": ").append(count).append("\n"));
        report.append("Completed Tasks: ").append(completedTasks).append("\n");
        report.append("Overdue Tasks: ").append(overdueTasks).append("\n");

        return report.toString();
    }

    }




