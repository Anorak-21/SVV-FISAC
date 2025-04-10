// This is a mutant program.
// Author : ysma

import java.util.Scanner;


public class TaskManagementApp
{

    public static  void main( java.lang.String[] args )
    {
        TaskManager taskManager = new TaskManager();
        java.util.Scanner scanner = new java.util.Scanner( System.in );
        run( taskManager, scanner );
    }

    public static  void run( TaskManager taskManager, java.util.Scanner scanner )
    {
        while (true) {
            System.out.println( "\n--- Task Management Menu ---" );
            System.out.println( "1. View Tasks" );
            System.out.println( "2. Add Task" );
            System.out.println( "3. Edit Task" );
            System.out.println( "4. Delete Task" );
            System.out.println( "5. Mark Task as Complete" );
            System.out.println( "6. Exit" );
            System.out.print( "Choose an option: " );
            java.lang.String choice = scanner.nextLine();
            if (choice.equals( "1" )) {
                taskManager.displayTasks();
            } else {
                if (choice.equals( "2" )) {
                    addTask( taskManager, scanner );
                } else {
                    if (choice.equals( "3" )) {
                        editTask( taskManager, scanner );
                    } else {
                        if (choice.equals( "4" )) {
                            deleteTask( taskManager, scanner );
                        } else {
                            if (choice.equals( "5" )) {
                                markTaskAsComplete( taskManager, scanner );
                            } else {
                                if (choice.equals( "6" )) {
                                    System.out.println( "Exiting. Goodbye!" );
                                    break;
                                } else {
                                    System.out.println( "Invalid option. Try again." );
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static  void addTask( TaskManager taskManager, java.util.Scanner scanner )
    {
        System.out.print( "Title: " );
        java.lang.String title = scanner.nextLine();
        System.out.print( "Description: " );
        java.lang.String description = scanner.nextLine();
        System.out.print( "Due Date (YYYY-MM-DD): " );
        java.lang.String dueDate = scanner.nextLine();
        System.out.print( "Priority (1=High, 2=Medium, 3=Low): " );
        int priority = Integer.parseInt( scanner.nextLine() );
        Task task = new Task( title, description, dueDate, priority );
        taskManager.addTask( task );
        System.out.println( "Task added successfully." );
    }

    private static  void editTask( TaskManager taskManager, java.util.Scanner scanner )
    {
        taskManager.displayTasks();
        System.out.print( "Enter task number to edit: " );
        int index = Integer.parseInt( scanner.nextLine() ) - 1;
        System.out.print( "New Title: " );
        java.lang.String title = scanner.nextLine();
        System.out.print( "New Description: " );
        java.lang.String description = scanner.nextLine();
        System.out.print( "New Due Date (YYYY-MM-DD): " );
        java.lang.String dueDate = scanner.nextLine();
        System.out.print( "New Priority (1=High, 2=Medium, 3=Low): " );
        int priority = Integer.parseInt( scanner.nextLine() );
        Task updatedTask = new Task( title, description, dueDate, priority );
        taskManager.editTask( index, updatedTask );
        System.out.println( "Task updated successfully." );
    }

    private static  void deleteTask( TaskManager taskManager, java.util.Scanner scanner )
    {
        taskManager.displayTasks();
        System.out.print( "Enter task number to delete: " );
        int index = Integer.parseInt( scanner.nextLine() ) - 1;
        taskManager.deleteTask( index );
        System.out.println( "Task deleted." );
    }

    private static  void markTaskAsComplete( TaskManager taskManager, java.util.Scanner scanner )
    {
        taskManager.displayTasks();
        System.out.print( "Enter task number to mark as complete: " );
        int index = Integer.parseInt( scanner.nextLine() ) - 1;
        taskManager.markTaskAsComplete( index );
        System.out.println( "Task marked as complete." );
    }

}
