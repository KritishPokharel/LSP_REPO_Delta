package org.howard.edu.lsp.assignment6;
// Created the class to meet the IntergetSetException requirement given in the assignment
//Extends to RuntimeException instead of Exception so the old driver code works without any changes!!

public class IntegerSetException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IntegerSetException(String message) {
        super(message);
    }
}
