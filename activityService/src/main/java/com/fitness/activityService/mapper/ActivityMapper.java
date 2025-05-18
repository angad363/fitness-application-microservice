package com.fitness.activityService.mapper;

import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    ActivityResponse activityToActivityResponse(Activity activity);
}
