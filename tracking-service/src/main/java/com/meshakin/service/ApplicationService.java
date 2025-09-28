package com.meshakin.service;

import com.meshakin.entity.ApplicationEntity;
import com.meshakin.entity.ApplicationType;
import com.meshakin.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationEntity findOrCreate (String applicationName, ApplicationType applicationType){
        Optional<ApplicationEntity> existingApp = applicationRepository
                .findByApplicationNameAndApplicationType(applicationName, applicationType);
        if(existingApp.isPresent()) return existingApp.get();

        ApplicationEntity newApplication = ApplicationEntity.builder()
                .applicationName(applicationName)
                .applicationType(applicationType)
                .build();

        return applicationRepository.save(newApplication);
    }
}
