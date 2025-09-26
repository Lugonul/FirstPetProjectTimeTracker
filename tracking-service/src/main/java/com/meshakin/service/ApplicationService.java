package com.meshakin.service;

import com.meshakin.dto.ApplicationDto;
import com.meshakin.entity.ApplicationEntity;
import com.meshakin.mapper.ApplicationMapper;
import com.meshakin.mapper.ApplicationMapper;
import com.meshakin.repository.ApplicationRepository;
import com.meshakin.repository.ApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationDto create(ApplicationDto applicationDto) {
        ApplicationEntity applicationEntity = applicationMapper.toEntity(applicationDto);
        ApplicationEntity savedEntity = applicationRepository.save(applicationEntity);
        return applicationMapper.toDto(savedEntity);
    }

    public ApplicationDto readById(Long id) {
        ApplicationEntity applicationEntity = applicationRepository.findById(id).orElse(null);
        if (applicationEntity == null) {
            return null;
        }
        return applicationMapper.toDto(applicationEntity);
    }

    public List<ApplicationDto> readAll() {
        List<ApplicationEntity> applicationEntityList = applicationRepository.findAll();
        List<ApplicationDto> applicationDtoList = new ArrayList<>();
        for (ApplicationEntity applicationEntity : applicationEntityList) {
            applicationDtoList.add(applicationMapper.toDto(applicationEntity));
        }
        return applicationDtoList;
    }

    public ApplicationDto update(ApplicationDto applicationDto) {
        if (applicationRepository.findById(applicationDto.id()).isEmpty()) {
            return null;
        }
        ApplicationEntity applicationEntity = applicationMapper.toEntity(applicationDto);
        applicationRepository.flush();

        return applicationMapper.toDto(applicationEntity);
    }

    public void deleteById(Long id) {
        if (applicationRepository.findById(id).isEmpty()) throw new EntityNotFoundException();

        applicationRepository.deleteById(id);
    }
}
