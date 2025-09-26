package com.meshakin.mapper;

import com.meshakin.dto.ApplicationTypeDto;
import com.meshakin.entity.ApplicationTypeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T00:00:37+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ApplicationTypeMapperImpl implements ApplicationTypeMapper {

    @Override
    public ApplicationTypeDto toDto(ApplicationTypeEntity applicationTypeEntity) {
        if ( applicationTypeEntity == null ) {
            return null;
        }

        Long id = null;
        String applicationTypeName = null;

        id = applicationTypeEntity.getId();
        applicationTypeName = applicationTypeEntity.getApplicationTypeName();

        ApplicationTypeDto applicationTypeDto = new ApplicationTypeDto( id, applicationTypeName );

        return applicationTypeDto;
    }

    @Override
    public ApplicationTypeEntity toEntity(ApplicationTypeDto applicationTypeDto) {
        if ( applicationTypeDto == null ) {
            return null;
        }

        ApplicationTypeEntity.ApplicationTypeEntityBuilder applicationTypeEntity = ApplicationTypeEntity.builder();

        applicationTypeEntity.id( applicationTypeDto.id() );
        applicationTypeEntity.applicationTypeName( applicationTypeDto.applicationTypeName() );

        return applicationTypeEntity.build();
    }
}
