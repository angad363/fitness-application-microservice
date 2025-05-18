package com.fitness.activityService.service.implementation;

import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.exception.ActivityNotFoundException;
import com.fitness.activityService.exception.UserActivityNotFoundException;
import com.fitness.activityService.mapper.ActivityMapper;
import com.fitness.activityService.model.Activity;
import com.fitness.activityService.repository.ActivityRepository;
import com.fitness.activityService.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImplementation implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public ActivityResponse createNewActivity(ActivityRequest request) {
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurnt(request.getCaloriesBurnt())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return activityMapper.activityToActivityResponse(savedActivity);
    }

    @Override
    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);

        if(activities.isEmpty()) {
            throw new UserActivityNotFoundException(userId);
        }

        return activities.stream().map(activity ->
                activityMapper.activityToActivityResponse(activity))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityResponse getActivityById(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        return activityMapper.activityToActivityResponse(activity);
    }
}
