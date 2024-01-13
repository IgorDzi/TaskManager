package data;

public class InvalidStatusException extends IllegalStateException {
    public InvalidStatusException() {
        super("data.Task is already completed!");
    }
}
