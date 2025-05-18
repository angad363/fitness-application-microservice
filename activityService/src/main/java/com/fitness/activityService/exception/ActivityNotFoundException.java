package com.fitness.activityService.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(String activityId) {
        super("Activity not found with ID: " + activityId);
    }
}
