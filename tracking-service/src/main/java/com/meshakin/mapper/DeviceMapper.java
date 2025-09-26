package com.meshakin.mapper;

import com.meshakin.dto.DeviceDto;
import com.meshakin.entity.DeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceDto toDto(DeviceEntity device);
    DeviceEntity toEntity(DeviceDto dto);

}
