package com.fitness.activityService.service;

import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;

import java.util.List;

public interface ActivityService {
    ActivityResponse createNewActivity(ActivityRequest request);

    List<ActivityResponse> getUserActivities(String userId);

    ActivityResponse getActivityById(String activityId);
}
