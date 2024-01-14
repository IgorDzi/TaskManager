package data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void testPriorityCheckMore() {

        ProjectTask task1 = new ProjectTask(1, "Task 1", "Description", LocalDate.now().plusDays(2), Priority.MEDIUM);
        task1.priorityCheck();
        assertEquals(Priority.MEDIUM, task1.getPriority());
    }
    @Test
    void testPriorityCheckExactly() {
        ProjectTask task2 = new ProjectTask(2, "Task 2", "Description", LocalDate.now().plusDays(1), Priority.LOW);
        task2.priorityCheck();
        assertEquals(Priority.LOW, task2.getPriority());
    }
    @Test
    void testPriorityCheckLess() {

        ProjectTask task3 = new ProjectTask(3, "Task 3", "Description", LocalDate.now().plusDays(-1), Priority.LOW);
        task3.priorityCheck();
        assertEquals(Priority.HIGH, task3.getPriority());
    }
    @Test
    void testPriorityCheckCompleted() {

        ProjectTask task4 = new ProjectTask(4, "Task 4", "Description", LocalDate.now().plusDays(2), Priority.MEDIUM);
        task4.setCompleted(true);
        task4.priorityCheck();
        assertEquals(Priority.MEDIUM, task4.getPriority());
    }
}
