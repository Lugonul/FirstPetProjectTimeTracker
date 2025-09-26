package com.meshakin.controller;

import com.meshakin.dto.ApplicationTypeDto;
import com.meshakin.service.ApplicationTypeService;
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
@RequestMapping("applicationType")
@RequiredArgsConstructor
public class ApplicationTypeController {
    private final ApplicationTypeService applicationTypeService;

    @PostMapping
    public ResponseEntity<ApplicationTypeDto> post(@RequestBody @Valid ApplicationTypeDto applicationTypeDto) {
        ApplicationTypeDto createdDto = applicationTypeService.create(applicationTypeDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDto.id())
                .toUri();

        return ResponseEntity.created(location).body(createdDto);
    }

    @GetMapping("/{id}")
    public ApplicationTypeDto readById(@PathVariable("id") Long id) {
        return applicationTypeService.readById(id);
    }

    @GetMapping
    public List<ApplicationTypeDto> readAll() {
        return applicationTypeService.readAll();
    }

    @PutMapping()
    public ApplicationTypeDto put(@RequestBody @Valid ApplicationTypeDto applicationTypeDto) {
        return applicationTypeService.update(applicationTypeDto);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        applicationTypeService.deleteById(id);
    }
}
