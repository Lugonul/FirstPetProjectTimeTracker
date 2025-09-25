package com.meshakin.mapper;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.TimeTrackerEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TimeTrackerMapper {

    TimeTrackerDto toDto(TimeTrackerEntity timeTrackerEntity);
    TimeTrackerEntity toEntity(TimeTrackerDto timeTrackerDto);

}
