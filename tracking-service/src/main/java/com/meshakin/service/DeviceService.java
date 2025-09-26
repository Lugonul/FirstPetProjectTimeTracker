package com.meshakin.service;

import com.meshakin.dto.DeviceDto;
import com.meshakin.entity.DeviceEntity;
import com.meshakin.mapper.DeviceMapper;
import com.meshakin.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceDto create(DeviceDto deviceDto) {
        DeviceEntity deviceEntity = deviceMapper.toEntity(deviceDto);
        DeviceEntity savedEntity = deviceRepository.save(deviceEntity);
        return deviceMapper.toDto(savedEntity);
    }

    public DeviceDto readById(Long id) {
        DeviceEntity deviceEntity = deviceRepository.findById(id).orElse(null);
        if (deviceEntity == null) {
            return null;
        }
        return deviceMapper.toDto(deviceEntity);
    }

    public List<DeviceDto> readAll() {
        List<DeviceEntity> deviceEntityList = deviceRepository.findAll();
        List<DeviceDto> deviceDtoList = new ArrayList<>();
        for (DeviceEntity deviceEntity : deviceEntityList) {
            deviceDtoList.add(deviceMapper.toDto(deviceEntity));
        }
        return deviceDtoList;
    }

    public DeviceDto update(DeviceDto deviceDto) {
        if (deviceRepository.findById(deviceDto.id()).isEmpty()) {
            return null;
        }
        DeviceEntity deviceEntity = deviceMapper.toEntity(deviceDto);
        deviceRepository.flush();

        return deviceMapper.toDto(deviceEntity);
    }

    public void deleteById(Long id) {
        if (deviceRepository.findById(id).isEmpty()) throw new EntityNotFoundException();

        deviceRepository.deleteById(id);
    }
}