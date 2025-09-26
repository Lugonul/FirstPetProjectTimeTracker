package com.meshakin.dto;

import java.time.LocalDateTime;

public record TimeTrackerDto (
        Long id,
        Long applicationId,
        LocalDateTime startTime,
        LocalDateTime endTime
){}