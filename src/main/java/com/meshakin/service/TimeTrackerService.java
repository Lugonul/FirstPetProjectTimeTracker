package com.meshakin.service;

import com.meshakin.entity.TimeTrackerEntity;
import com.meshakin.repository.TimeTrackerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTrackerService {
    private final TimeTrackerRepository timeTrackerRepository;


}
