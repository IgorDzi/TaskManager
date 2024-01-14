package data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testCompleteTask() {
        Task task = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        assertFalse(task.isCompleted());
        task.completeTask();
        assertTrue(task.isCompleted());
        assertThrows(InvalidStatusException.class, task::completeTask);
    }

    @Test
    void testIsLate() {
        Task task1 = new Task(1, "Test Task", "Description", LocalDate.now().plusDays(1), Priority.MEDIUM);
        Task task2 = new Task(2, "Test Task", "Description", LocalDate.now().minusDays(1), Priority.LOW);

        assertFalse(task1.isLate());
        assertTrue(task2.isLate());
    }

    @Test
    void testDaysUntilDue() {
        Task task1 = new Task(1, "Test Task", "Description", LocalDate.now().plusDays(3), Priority.HIGH);
        Task task2 = new Task(2, "Test Task", "Description", LocalDate.now().minusDays(2), Priority.LOW);

        assertEquals(3, task1.daysUntilDue());
        assertEquals(-2, task2.daysUntilDue());
    }

    @Test
    void testEquals() {
        Task task1 = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        Task task2 = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        Task task3 = new Task(2, "Another Task", "Another Description", LocalDate.now(), Priority.LOW);

        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
    }

    @Test
    void testHashCode() {
        Task task1 = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        Task task2 = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        Task task3 = new Task(2, "Another Task", "Another Description", LocalDate.now(), Priority.LOW);

        assertEquals(task1.hashCode(), task2.hashCode());
        assertNotEquals(task1.hashCode(), task3.hashCode());
    }
    @Test
    void testToString() {
        Task task = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        String expectedString = "Task{taskId=1, title='Test Task', description='Description', dueDate=" + LocalDate.now() + ", completed=false, priority=HIGH}";
        assertEquals(expectedString, task.toString());
    }
    @Test
    void testSetDescription() {
        Task task = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        assertEquals("Description", task.getDescription());

        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    void testSetTitle() {
        Task task = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        assertEquals("Test Task", task.getTitle());

        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle());
    }

    @Test
    void testSetTaskId() {
        Task task = new Task(1, "Test Task", "Description", LocalDate.now(), Priority.HIGH);
        assertEquals(1, task.getTaskId());

        task.setTaskId(2);
        assertEquals(2, task.getTaskId());
    }

}
