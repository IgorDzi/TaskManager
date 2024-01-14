package data;

public class InvalidStatusException extends IllegalStateException {
    public InvalidStatusException() {
        super("Task is already completed!");
    }
}
