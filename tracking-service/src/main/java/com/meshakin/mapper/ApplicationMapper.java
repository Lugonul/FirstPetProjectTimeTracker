package com.meshakin.mapper;

import com.meshakin.dto.ApplicationDto;
import com.meshakin.dto.DeviceDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.ApplicationTypeEntity;
import com.meshakin.entity.DeviceEntity;
import com.meshakin.repository.ApplicationTypeRepository;
import com.meshakin.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ApplicationMapper {

    @Autowired
    ApplicationTypeRepository applicationTypeRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Mapping(target = "applicationTypeId", source = "applicationType.id")
    @Mapping(target = "deviceId", source = "device.id")
    public abstract ApplicationDto toDto(ApplicationEntity entity);

    @Mapping(target = "applicationType", source = "applicationTypeId", qualifiedByName = "idToApplicationType")
    @Mapping(target = "device", source = "deviceId", qualifiedByName = "idToDevice")
    public abstract ApplicationEntity toEntity(ApplicationDto applicationDto);

    @Named("idToApplicationType")
    protected ApplicationTypeEntity idToApplicationType(Long applicationTypeId) {
        if (applicationTypeId == null) return null;
        return applicationTypeRepository.findById(applicationTypeId)
                .orElseThrow(() -> new EntityNotFoundException("ApplicationType not found"));
    }

    @Named("idToDevice")
    protected DeviceEntity idToDevice(Long deviceId) {
        if (deviceId == null) return null;
        return deviceRepository.findById(deviceId)
                .orElseThrow(() -> new EntityNotFoundException("Device not found"));
    }

}
