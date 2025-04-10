import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskManagerMutantTest {

    private TaskManager manager;

    @Before
    public void setUp() {
        manager = new TaskManager();
    }

    @Test
    public void testDeleteTaskValidIndex() {
        Task task = new Task("Test", "Test Description", "2025-01-01", 1);
        manager.addTask(task);
        assertEquals(1, manager.getTasks().size());

        manager.deleteTask(0);

        assertEquals(0, manager.getTasks().size());
    }

    @Test
    public void testDeleteTaskNegativeIndex() {
        Task task = new Task("Test", "Test Description", "2025-01-01", 1);
        manager.addTask(task);
        manager.deleteTask(-1); // should do nothing, no exception

        assertEquals(1, manager.getTasks().size());
    }

    @Test
    public void testDeleteTaskInvalidIndexThrows() {
        // list is empty, so removing at any index should throw
        try {
            manager.deleteTask(0);
            fail("Expected IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected behavior
        }
    }
}
