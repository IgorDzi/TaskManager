package data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * The type data.Task.
 */
public class Task {

    private int taskId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Priority priority;

    /**
     * Instantiates a new data.Task.
     *
     * @param taskId      the task id
     * @param title       the title
     * @param description the description
     * @param dueDate     the due date
     * @param priority    the priority
     */
    public Task(int taskId, String title, String description, LocalDate dueDate, Priority priority) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.priority = priority;
    }

    /**
     * Instantiates a new Task.
     */
    public Task() {
        // Empty constructor for Jackson
    }

    /**
     * Gets task id.
     *
     * @return the task id
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets task id.
     *
     * @param taskId the task id
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Is completed boolean.
     *
     * @return the boolean
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets completed.
     *
     * @param completed the completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets priority.
     *
     * @param priority the priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return taskId == task.taskId && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, title, description, dueDate, completed, priority);
    }

    /**
     * Complete task.
     */
    public void completeTask() {
        if (!completed) {
            setCompleted(true);
        } else {
            throw new InvalidStatusException();
        }
    }

    /**
     * Change due date.
     *
     * @param newDueDate the new due date
     */
    public void changeDueDate(LocalDate newDueDate) {
        setDueDate(newDueDate);
    }

    /**
     * Is late boolean.
     *
     * @return the boolean
     */
    public boolean isLate() {
        return daysUntilDue() < 0;
    }

    /**
     * Days until due int.
     *
     * @return the int
     */
    public int daysUntilDue() {
        LocalDate currentTime = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(currentTime, dueDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + getTaskId() +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", dueDate=" + getDueDate() +
                ", completed=" + isCompleted() +
                ", priority=" + getPriority() +
                '}';
    }


}

