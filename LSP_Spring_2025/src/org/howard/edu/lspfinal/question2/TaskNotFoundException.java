package org.howard.edu.lspfinal.question2;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming

import java.io.Serializable;

/**
 * Thrown when a requested task cannot be found in the system.
 */
public class TaskNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new TaskNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
