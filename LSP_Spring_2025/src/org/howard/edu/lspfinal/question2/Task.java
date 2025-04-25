package org.howard.edu.lspfinal.question2;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming

/**
 * Represents a single task with a unique name, a priority integer,
 * and a status of TODO, IN_PROGRESS, or DONE.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Constructs a Task.
     *
     * @param name     unique name of the task
     * @param priority integer priority (lower = higher priority)
     * @param status   one of "TODO", "IN_PROGRESS", or "DONE"
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /** @return the task's unique name */
    public String getName() {
        return name;
    }

    /** @return the task's priority */
    public int getPriority() {
        return priority;
    }

    /** @return the task's current status */
    public String getStatus() {
        return status;
    }

    /**
     * Updates this task's status.
     *
     * @param status new status; must be "TODO", "IN_PROGRESS", or "DONE"
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of this task.
     *
     * @return formatted as Task{name='…', priority=…, status='…'}
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
