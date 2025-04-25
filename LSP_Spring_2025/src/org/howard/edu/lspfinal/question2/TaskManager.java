package org.howard.edu.lspfinal.question2;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of tasks, ensuring unique names and
 * allowing lookup, status updates, and grouped printing.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the system.
     *
     * @param name     unique name of the task
     * @param priority integer priority (lower = higher priority)
     * @param status   one of "TODO", "IN_PROGRESS", or "DONE"
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name the unique task name to look up
     * @return the Task object
     * @throws TaskNotFoundException if no task with that name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name      the name of the task to update
     * @param newStatus the new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException    if the task does not exist
     * @throws IllegalArgumentException if newStatus is not one of the valid statuses
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task t = getTaskByName(name);
        if (!newStatus.equals("TODO") &&
            !newStatus.equals("IN_PROGRESS") &&
            !newStatus.equals("DONE")) {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
        t.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped under each status heading in the order:
     * TODO, IN_PROGRESS, DONE.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        String[] statuses = {"TODO", "IN_PROGRESS", "DONE"};
        for (String status : statuses) {
            System.out.println(status + ":");
            for (Task t : tasks.values()) {
                if (t.getStatus().equals(status)) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}
