package data;

import java.time.LocalDate;

/**
 * The type Daily task.
 */
public class DailyTask extends Task{
    /**
     * Instantiates a new data.Task.
     *
     * @param taskId      the task id
     * @param title       the title
     * @param description the description
     * @param dueDate     the due date
     * @param priority    the priority
     */
    public DailyTask(int taskId, String title, String description, LocalDate dueDate, Priority priority) {
        super(taskId, title, description, LocalDate.now(), priority);

    }

    /**
     * Reset task.
     */
    public void resetTask(){
        setCompleted(false);
        setDueDate(LocalDate.now());
    }

}
