package com.meshakin.controller;

import com.meshakin.dto.ApplicationDto;
import com.meshakin.service.ApplicationService;
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
@RequestMapping("application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDto> post(@RequestBody @Valid ApplicationDto applicationDto) {
        ApplicationDto createdDto = applicationService.create(applicationDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDto.id())
                .toUri();

        return ResponseEntity.created(location).body(createdDto);
    }

    @GetMapping("/{id}")
    public ApplicationDto readById(@PathVariable("id") Long id) {
        return applicationService.readById(id);
    }

    @GetMapping
    public List<ApplicationDto> readAll() {
        return applicationService.readAll();
    }

    @PutMapping()
    public ApplicationDto put(@RequestBody @Valid ApplicationDto applicationDto) {
        return applicationService.update(applicationDto);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        applicationService.deleteById(id);
    }
}
