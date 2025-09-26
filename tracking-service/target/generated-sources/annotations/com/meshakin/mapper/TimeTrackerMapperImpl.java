package com.meshakin.mapper;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.TimeTrackerEntity;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T20:55:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class TimeTrackerMapperImpl extends TimeTrackerMapper {

    @Override
    public TimeTrackerDto toDto(TimeTrackerEntity timeTrackerEntity) {
        if ( timeTrackerEntity == null ) {
            return null;
        }

        Long applicationId = null;
        Long id = null;
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        applicationId = timeTrackerEntityApplicationId( timeTrackerEntity );
        id = timeTrackerEntity.getId();
        startTime = timeTrackerEntity.getStartTime();
        endTime = timeTrackerEntity.getEndTime();

        TimeTrackerDto timeTrackerDto = new TimeTrackerDto( id, applicationId, startTime, endTime );

        return timeTrackerDto;
    }

    @Override
    public TimeTrackerEntity toEntity(TimeTrackerDto timeTrackerDto) {
        if ( timeTrackerDto == null ) {
            return null;
        }

        TimeTrackerEntity.TimeTrackerEntityBuilder timeTrackerEntity = TimeTrackerEntity.builder();

        timeTrackerEntity.application( idToApplication( timeTrackerDto.applicationId() ) );
        timeTrackerEntity.id( timeTrackerDto.id() );
        timeTrackerEntity.startTime( timeTrackerDto.startTime() );
        timeTrackerEntity.endTime( timeTrackerDto.endTime() );

        return timeTrackerEntity.build();
    }

    private Long timeTrackerEntityApplicationId(TimeTrackerEntity timeTrackerEntity) {
        if ( timeTrackerEntity == null ) {
            return null;
        }
        ApplicationEntity application = timeTrackerEntity.getApplication();
        if ( application == null ) {
            return null;
        }
        Long id = application.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
