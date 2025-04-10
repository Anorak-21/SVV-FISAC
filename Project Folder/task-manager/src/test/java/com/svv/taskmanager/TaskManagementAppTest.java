package com.svv.taskmanager;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;



class TaskManagementAppTest {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testAddDisplayEditDeleteCompleteTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Title", "Desc", "2025-04-15", "High");

        manager.addTask(task);
        assertEquals(1, manager.getTasks().size());

        manager.displayTasks();
        String output = outputStream.toString();
        assertTrue(output.contains("Title: Title"));

        Task updated = new Task("New", "Updated", "2025-05-01", "Low");
        manager.editTask(0, updated);
        assertEquals("New", manager.getTasks().get(0).getTitle());

        manager.markTaskAsComplete(0);
        assertTrue(manager.getTasks().get(0).isCompleted());

        manager.deleteTask(0);
        assertTrue(manager.getTasks().isEmpty());
    }

    @Test
    void testInvalidEditDeleteMark() {
        TaskManager manager = new TaskManager();

        manager.editTask(1, new Task("A", "B", "C", "D"));
        manager.deleteTask(2);
        manager.markTaskAsComplete(3);

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid task index."));
    }

    @Test
    void testTaskGettersAndSetters() {
        Task task = new Task("Test", "Test Desc", "2025-04-15", "High");

        task.setTitle("Updated Title");
        task.setDescription("Updated Desc");
        task.setDueDate("2025-04-20");
        task.setPriority("Low");

        assertEquals("Updated Title", task.getTitle());
        assertEquals("Updated Desc", task.getDescription());
        assertEquals("2025-04-20", task.getDueDate());
        assertEquals("Low", task.getPriority());
    }

    @Test
    void testDisplayTasks_empty() {
        TaskManager manager = new TaskManager();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.displayTasks();

        String output = outContent.toString().trim();
        assertTrue(output.contains("No tasks found."));
    }

    @Test
    void testDisplayTasks_withTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Title", "Desc", "2025-04-30", "High");
        manager.addTask(task);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.displayTasks();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Title"));
        assertTrue(output.contains("Desc"));
        assertTrue(output.contains("2025-04-30"));
        assertTrue(output.contains("High"));
    }

    @Test
    void testMainFullFlow() {
        String simulatedInput = String.join(System.lineSeparator(),
                "2", "Sample", "Desc", "2025-04-09", "High", // Add task
                "1",                                        // View
                "3", "0", "Edited", "New Desc", "2025-05-01", "Low", // Edit
                "5", "0",                                    // Mark complete
                "4", "0",                                    // Delete
                "6",                                         // Exit
                "", "", "", "", ""                           // padding
        );
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> TaskManagementApp.main(new String[]{}));
        String output = outputStream.toString();
        assertTrue(output.contains("Task added successfully."));
        assertTrue(output.contains("Tasks:"));
        assertTrue(output.contains("Task updated successfully."));
        assertTrue(output.contains("Task marked as complete."));
        assertTrue(output.contains("Task deleted successfully."));
        assertTrue(output.contains("Exiting Task Management App"));
    }

    @Test
    void testMainInvalidChoice() {
        String input = String.join(System.lineSeparator(),
                "99", "6", "", "", "", "" // invalid then exit
        );
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertDoesNotThrow(() -> TaskManagementApp.main(new String[]{}));
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid choice"));
        assertTrue(output.contains("Exiting Task Management App"));
    }

    @Test
    void testMainInvalidIndex() {
        String input = String.join(System.lineSeparator(),
                "5", "5", "3", "2", "X", "Y", "2025-12-12", "Low", "4", "4", "6",
                "", "", "", ""
        );
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertDoesNotThrow(() -> TaskManagementApp.main(new String[]{}));
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid task index."));
    }

    @Test
    void testMainTriggersClassLoad() throws Exception {
        assertNotNull(Class.forName("com.svv.taskmanager.TaskManagementApp").getDeclaredMethod("main", String[].class));
    }

    @Test
void testToString_completedAndNotCompleted() {
    Task completedTask = new Task("A", "B", "2025-01-01", "High");
    completedTask.setCompleted(true);
    String completedStr = completedTask.toString();
    assertTrue(completedStr.contains("Status: Completed"));

    Task notCompletedTask = new Task("X", "Y", "2025-02-02", "Low");
    notCompletedTask.setCompleted(false);
    String notCompletedStr = notCompletedTask.toString();
    assertTrue(notCompletedStr.contains("Status: Not Completed"));
}

@Test
void testEditDeleteComplete_negativeAndOutOfBoundsIndex() {
    TaskManager manager = new TaskManager();
    // No tasks added
    manager.editTask(-1, new Task("Neg", "Desc", "2025-01-01", "High"));
    manager.editTask(5, new Task("Big", "Desc", "2025-01-01", "High"));
    manager.deleteTask(-1);
    manager.deleteTask(3);
    manager.markTaskAsComplete(-1);
    manager.markTaskAsComplete(2);

    String output = outputStream.toString();
    assertTrue(output.contains("Invalid task index."));
}
///Test for 1 uncovered line

 @Test
    void testMainCoversClassDeclaration() {
        // Input only choice "6" to exit immediately
        String simulatedInput = "6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // This guarantees the main method (and thus the class) is invoked
        assertDoesNotThrow(() -> TaskManagementApp.main(new String[]{}));
    }

    @Test
    void mytest(){

        TaskManagementApp testtask = new TaskManagementApp();
        
    }



}
