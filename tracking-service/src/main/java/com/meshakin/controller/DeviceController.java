package com.meshakin.controller;

import com.meshakin.dto.DeviceDto;
import com.meshakin.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("device")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceDto> post(@RequestBody @Valid DeviceDto deviceDto) {
        DeviceDto createdDto = deviceService.create(deviceDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDto.id())
                .toUri();

        return ResponseEntity.created(location).body(createdDto);
    }

    @GetMapping("/{id}")
    public DeviceDto readById(@PathVariable("id") Long id) {
        return deviceService.readById(id);
    }

    @GetMapping
    public List<DeviceDto> readAll() {
        return deviceService.readAll();
    }

    @PutMapping()
    public DeviceDto put(@RequestBody @Valid DeviceDto deviceDto) {
        return deviceService.update(deviceDto);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        deviceService.deleteById(id);
    }
}