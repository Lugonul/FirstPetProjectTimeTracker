package com.meshakin.mapper;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.ApplicationType;
import com.meshakin.entity.Device;
import com.meshakin.entity.TimeTrackerEntity;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-02T20:23:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class TimeTrackerMapperImpl extends TimeTrackerMapper {

    @Override
    public TimeTrackerEntity toEntity(TimeTrackerDto dto) {
        if ( dto == null ) {
            return null;
        }

        TimeTrackerEntity.TimeTrackerEntityBuilder timeTrackerEntity = TimeTrackerEntity.builder();

        timeTrackerEntity.application( mapApplication( dto ) );
        timeTrackerEntity.id( dto.id() );
        timeTrackerEntity.device( dto.device() );
        timeTrackerEntity.startTime( dto.startTime() );
        timeTrackerEntity.endTime( dto.endTime() );

        return timeTrackerEntity.build();
    }

    @Override
    public TimeTrackerDto toDto(TimeTrackerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String applicationName = null;
        ApplicationType applicationType = null;
        Long id = null;
        Device device = null;
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        applicationName = entityApplicationApplicationName( entity );
        applicationType = entityApplicationApplicationType( entity );
        id = entity.getId();
        device = entity.getDevice();
        startTime = entity.getStartTime();
        endTime = entity.getEndTime();

        TimeTrackerDto timeTrackerDto = new TimeTrackerDto( id, applicationName, applicationType, device, startTime, endTime );

        return timeTrackerDto;
    }

    private String entityApplicationApplicationName(TimeTrackerEntity timeTrackerEntity) {
        if ( timeTrackerEntity == null ) {
            return null;
        }
        ApplicationEntity application = timeTrackerEntity.getApplication();
        if ( application == null ) {
            return null;
        }
        String applicationName = application.getApplicationName();
        if ( applicationName == null ) {
            return null;
        }
        return applicationName;
    }

    private ApplicationType entityApplicationApplicationType(TimeTrackerEntity timeTrackerEntity) {
        if ( timeTrackerEntity == null ) {
            return null;
        }
        ApplicationEntity application = timeTrackerEntity.getApplication();
        if ( application == null ) {
            return null;
        }
        ApplicationType applicationType = application.getApplicationType();
        if ( applicationType == null ) {
            return null;
        }
        return applicationType;
    }
}
