package service;

import data.Task;

import java.util.List;

/**
 * The interface Task processor.
 */
public interface TaskProcessor {
    /**
     * Save tasks.
     *
     * @param tasks    the tasks
     * @param filePath the file path
     */
    void saveTasks(List<Task> tasks, String filePath);

    /**
     * Import tasks list.
     *
     * @param filePath the file path
     * @return the list
     */
    List<Task> importTasks(String filePath);

}
