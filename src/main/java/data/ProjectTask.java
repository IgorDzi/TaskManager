package data;

import java.time.LocalDate;

public class ProjectTask extends Task {
    /**
     * Instantiates a new data.Task.
     *
     * @param taskId      the task id
     * @param title       the title
     * @param description the description
     * @param dueDate     the due date
     * @param priority    the priority
     */
    public ProjectTask(int taskId, String title, String description, LocalDate dueDate, Priority priority) {
        super(taskId, title, description, dueDate, priority);
    }

    /**
     * data.Priority check if less than 1 day until due date sets priority to high.
     */
    public void priorityCheck() {
        if (daysUntilDue() < 1) {
            setPriority(Priority.HIGH);
        }
    }

}
