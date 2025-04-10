// This is a mutant program.
// Author : ysma

public class Task
{

    private java.lang.String title;

    private java.lang.String description;

    private java.lang.String dueDate;

    private int priority;

    private boolean completed;

    public Task( java.lang.String title, java.lang.String description, java.lang.String dueDate, int priority )
    {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public  java.lang.String getTitle()
    {
        return title;
    }

    public  void setTitle( java.lang.String title )
    {
        this.title = title;
    }

    public  java.lang.String getDescription()
    {
        return description;
    }

    public  void setDescription( java.lang.String description )
    {
        this.description = description;
    }

    public  java.lang.String getDueDate()
    {
        return dueDate;
    }

    public  void setDueDate( java.lang.String dueDate )
    {
        this.dueDate = dueDate;
    }

    public  int getPriority()
    {
        return priority;
    }

    public  void setPriority( int priority )
    {
        this.priority = priority;
    }

    public  boolean isCompleted()
    {
        return completed;
    }

    public  void setCompleted( boolean completed )
    {
        this.completed = completed;
    }

    public  java.lang.String toString()
    {
        java.lang.String priorityText;
        switch (priority) {
        case 1 :
            priorityText = "High";
            break;

        case 2 :
            priorityText = "Medium";
            break;

        case 3 :
            priorityText = "Low";
            break;

        default  :
            priorityText = "Unknown";
            break;

        }
        return title + " | " + " | Due: " + dueDate + " | Priority: " + priorityText + " | Completed: " + completed;
    }

}
