package com.meshakin.dto;

public record ApplicationDto (
        Long id,
        String applicationName,
        Long deviceId,
        Long applicationTypeId
){
}
