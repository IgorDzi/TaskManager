package data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The type data.Task.
 */
public class Task {



    /**
     * Gets task id.
     *
     * @return the task id
     */
    public int getTaskId() {
        return taskId;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
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
     * Is completed boolean.
     *
     * @return the boolean
     */
    public boolean isCompleted() {
        return completed;
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
     * Sets completed.
     *
     * @param completed the completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
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
     * Sets priority.
     *
     * @param priority the priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    private final int taskId;
    private final String title;
    private final String description;

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
     * Complete task.
     */
    public void completeTask(){
        if(!completed){
            setCompleted(true);
        }
        else {throw new InvalidStatusException();}
        }

    /**
     * Change due date.
     *
     * @param newDueDate the new due date
     */
    public void changeDueDate(LocalDate newDueDate){
        setDueDate(newDueDate);
    }

    /**
     * Is late boolean.
     *
     * @return the boolean
     */
    public boolean isLate(){
        return daysUntilDue() < 0;
    }

    /**
     * Days until due int.
     *
     * @return the int
     */
    public int daysUntilDue(){
        LocalDate currentTime = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(currentTime,dueDate);
    }


}

