package com.meshakin.service;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.TimeTrackerEntity;
import com.meshakin.mapper.TimeTrackerMapper;
import com.meshakin.repository.TimeTrackerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeTrackerService {
    private final TimeTrackerRepository timeTrackerRepository;
    private final TimeTrackerMapper timeTrackerMapper;

    public TimeTrackerDto readById (Long id) {
        TimeTrackerEntity timeTrackerEntity = timeTrackerRepository.findById(id).orElse(null);
        if (timeTrackerEntity == null) {return null;}
        return timeTrackerMapper.toDto(timeTrackerEntity);
    }

    public List<TimeTrackerDto> readAll() {
        List<TimeTrackerEntity> timeTrackerEntityList = timeTrackerRepository.findAll();
        List<TimeTrackerDto> timeTrackerDtoList = new ArrayList<>();
        for (TimeTrackerEntity timeTrackerEntity : timeTrackerEntityList) {
            timeTrackerDtoList.add(timeTrackerMapper.toDto(timeTrackerEntity));
        }
        return timeTrackerDtoList;
    }

    public TimeTrackerDto create(TimeTrackerDto timeTrackerDto) {
        TimeTrackerEntity timeTrackerEntity = timeTrackerMapper.toEntity(timeTrackerDto);
        TimeTrackerEntity savedEntity = timeTrackerRepository.save(timeTrackerEntity);
        return timeTrackerMapper.toDto(savedEntity);
    }
}