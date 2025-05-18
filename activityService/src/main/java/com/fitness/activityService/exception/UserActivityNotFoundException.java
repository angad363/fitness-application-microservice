package com.fitness.activityService.exception;

public class UserActivityNotFoundException extends RuntimeException{
    public UserActivityNotFoundException(String userId) {
        super("No activities found for user with ID: " + userId);
    }
}
