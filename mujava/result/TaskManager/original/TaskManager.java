// This is a mutant program.
// Author : ysma

import java.util.ArrayList;
import java.util.List;


public class TaskManager
{

    private java.util.List<Task> tasks;

    public TaskManager()
    {
        tasks = new java.util.ArrayList<Task>();
    }

    public  void addTask( Task task )
    {
        tasks.add( task );
    }

    public  void deleteTask( int index )
    {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove( index );
        }
    }

    public  void editTask( int index, Task updatedTask )
    {
        if (index >= 0 && index < tasks.size()) {
            tasks.set( index, updatedTask );
        }
    }

    public  void markTaskAsComplete( int index )
    {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get( index );
            task.setCompleted( true );
        }
    }

    public  void displayTasks()
    {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get( i );
            System.out.println( i + 1 + ". " + task );
        }
    }

    public  java.util.List<Task> getTasks()
    {
        return tasks;
    }

}
