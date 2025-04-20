package com.projects.todo.exceptions;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String term) {
        super("No tasks found with term: " + term);
    }
}
