package org.howard.edu.lspfinal.question2;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming

import java.io.Serializable;

/**
 * Thrown when attempting to add a task whose name already exists in the system.
 */
public class DuplicateTaskException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new DuplicateTaskException with the specified detail message.
     *
     * @param message the detail message
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}
