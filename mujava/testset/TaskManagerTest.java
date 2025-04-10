import org.junit.Test;

public class TaskManagerTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteTaskOutOfBoundsShouldThrow() {
        TaskManager manager = new TaskManager();
        // No tasks added yet — index 0 is out of bounds
        manager.deleteTask(0); // should throw in original; will not check upper bound in mutant
    }
}
