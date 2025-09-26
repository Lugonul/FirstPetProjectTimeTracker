package com.meshakin.mapper;

import com.meshakin.dto.DeviceDto;
import com.meshakin.entity.DeviceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T20:55:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public DeviceDto toDto(DeviceEntity device) {
        if ( device == null ) {
            return null;
        }

        Long id = null;
        String deviceName = null;

        id = device.getId();
        deviceName = device.getDeviceName();

        DeviceDto deviceDto = new DeviceDto( id, deviceName );

        return deviceDto;
    }

    @Override
    public DeviceEntity toEntity(DeviceDto dto) {
        if ( dto == null ) {
            return null;
        }

        DeviceEntity.DeviceEntityBuilder deviceEntity = DeviceEntity.builder();

        deviceEntity.id( dto.id() );
        deviceEntity.deviceName( dto.deviceName() );

        return deviceEntity.build();
    }
}
