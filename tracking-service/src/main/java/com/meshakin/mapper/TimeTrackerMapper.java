package com.meshakin.mapper;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.TimeTrackerEntity;
import com.meshakin.repository.ApplicationRepository;
import com.meshakin.service.ApplicationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public abstract class TimeTrackerMapper {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationMapper  applicationMapper;

    @Mapping(target = "applicationId", source = "application.id")
    public abstract TimeTrackerDto toDto(TimeTrackerEntity timeTrackerEntity);

    @Mapping(target = "application", source = "applicationId", qualifiedByName = "idToApplication")
    public abstract TimeTrackerEntity toEntity(TimeTrackerDto timeTrackerDto);

    @Named("idToApplication")
    protected ApplicationEntity idToApplication(Long applicationId) {
        if (applicationId == null) return null;
        return applicationMapper.toEntity(applicationService.readById(applicationId));
    }

}

