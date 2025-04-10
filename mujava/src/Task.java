public class Task {
    private String title;
    private String description;
    private String dueDate;
    private int priority; // 1 = High, 2 = Medium, 3 = Low
    private boolean completed;

    public Task(String title, String description, String dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String toString() {
        String priorityText;
        switch (priority) {
            case 1: priorityText = "High"; break;
            case 2: priorityText = "Medium"; break;
            case 3: priorityText = "Low"; break;
            default: priorityText = "Unknown"; break;
        }
        return title + " | " + description + " | Due: " + dueDate + " | Priority: " + priorityText + " | Completed: " + completed;
    }
}
