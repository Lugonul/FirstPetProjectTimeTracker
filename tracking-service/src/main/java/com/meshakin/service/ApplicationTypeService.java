package com.meshakin.service;

import com.meshakin.dto.ApplicationTypeDto;
import com.meshakin.entity.ApplicationTypeEntity;
import com.meshakin.mapper.ApplicationTypeMapper;
import com.meshakin.repository.ApplicationTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationTypeService {

    private final ApplicationTypeRepository applicationTypeRepository;
    private final ApplicationTypeMapper applicationTypeMapper;

    public ApplicationTypeDto create(ApplicationTypeDto applicationTypeDto) {
        ApplicationTypeEntity applicationTypeEntity = applicationTypeMapper.toEntity(applicationTypeDto);
        ApplicationTypeEntity savedEntity = applicationTypeRepository.save(applicationTypeEntity);
        return applicationTypeMapper.toDto(savedEntity);
    }

    public ApplicationTypeDto readById(Long id) {
        ApplicationTypeEntity applicationTypeEntity = applicationTypeRepository.findById(id).orElse(null);
        if (applicationTypeEntity == null) {
            return null;
        }
        return applicationTypeMapper.toDto(applicationTypeEntity);
    }

    public List<ApplicationTypeDto> readAll() {
        List<ApplicationTypeEntity> applicationTypeEntityList = applicationTypeRepository.findAll();
        List<ApplicationTypeDto> applicationTypeDtoList = new ArrayList<>();
        for (ApplicationTypeEntity applicationTypeEntity : applicationTypeEntityList) {
            applicationTypeDtoList.add(applicationTypeMapper.toDto(applicationTypeEntity));
        }
        return applicationTypeDtoList;
    }

    public ApplicationTypeDto update(ApplicationTypeDto applicationTypeDto) {
        if (applicationTypeRepository.findById(applicationTypeDto.id()).isEmpty()) {
            return null;
        }
        ApplicationTypeEntity applicationTypeEntity = applicationTypeMapper.toEntity(applicationTypeDto);
        applicationTypeRepository.flush();

        return applicationTypeMapper.toDto(applicationTypeEntity);
    }

    public void deleteById(Long id) {
        if (applicationTypeRepository.findById(id).isEmpty()) throw new EntityNotFoundException();

        applicationTypeRepository.deleteById(id);
    }
}