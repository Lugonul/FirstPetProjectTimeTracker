package com.meshakin.mapper;

import com.meshakin.dto.ApplicationDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.ApplicationTypeEntity;
import com.meshakin.entity.DeviceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T20:55:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ApplicationMapperImpl extends ApplicationMapper {

    @Override
    public ApplicationDto toDto(ApplicationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long applicationTypeId = null;
        Long deviceId = null;
        Long id = null;
        String applicationName = null;

        applicationTypeId = entityApplicationTypeId( entity );
        deviceId = entityDeviceId( entity );
        id = entity.getId();
        applicationName = entity.getApplicationName();

        ApplicationDto applicationDto = new ApplicationDto( id, applicationName, deviceId, applicationTypeId );

        return applicationDto;
    }

    @Override
    public ApplicationEntity toEntity(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }

        ApplicationEntity.ApplicationEntityBuilder applicationEntity = ApplicationEntity.builder();

        applicationEntity.applicationType( idToApplicationType( applicationDto.applicationTypeId() ) );
        applicationEntity.device( idToDevice( applicationDto.deviceId() ) );
        applicationEntity.id( applicationDto.id() );
        applicationEntity.applicationName( applicationDto.applicationName() );

        return applicationEntity.build();
    }

    private Long entityApplicationTypeId(ApplicationEntity applicationEntity) {
        if ( applicationEntity == null ) {
            return null;
        }
        ApplicationTypeEntity applicationType = applicationEntity.getApplicationType();
        if ( applicationType == null ) {
            return null;
        }
        Long id = applicationType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityDeviceId(ApplicationEntity applicationEntity) {
        if ( applicationEntity == null ) {
            return null;
        }
        DeviceEntity device = applicationEntity.getDevice();
        if ( device == null ) {
            return null;
        }
        Long id = device.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
