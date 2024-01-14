package data;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DailyTaskTest {

    @Test
    void testResetTaskCompleted() {

        DailyTask task1 = new DailyTask(1, "Task 1", "Description", LocalDate.now().plusDays(2), Priority.MEDIUM);
        task1.setCompleted(true);
        task1.resetTask();
        assertFalse(task1.isCompleted());
        assertEquals(LocalDate.now(), task1.getDueDate());
    }
    @Test
    void testResetTaskIncomplete() {

        DailyTask task2 = new DailyTask(2, "Task 2", "Description", LocalDate.now().plusDays(1), Priority.LOW);
        task2.setCompleted(false);
        task2.setDueDate(LocalDate.now().minusDays(1));
        task2.resetTask();
        assertFalse(task2.isCompleted());
        assertEquals(LocalDate.now(), task2.getDueDate());
    }
    @Test
    void testResetTaskToday() {

        DailyTask task3 = new DailyTask(3, "Task 3", "Description", LocalDate.now(), Priority.HIGH);
        task3.setCompleted(true);
        task3.resetTask();
        assertFalse(task3.isCompleted());
        assertEquals(LocalDate.now(), task3.getDueDate());
    }
}
