package com.meshakin.controller;

import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.service.TimeTrackerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("time_tracker")
@RequiredArgsConstructor
public class TimeTrackerController {
    private final TimeTrackerService timeTrackerService;

    @PostMapping
    public TimeTrackerDto post(@RequestBody @Valid TimeTrackerDto timeTrackerDto) {

        return timeTrackerService.create(timeTrackerDto);
    }

    @GetMapping("/{id}")
    public TimeTrackerDto readById(@PathVariable("id") Long id) {
        return timeTrackerService.readById(id);
    }

    @GetMapping
    public List<TimeTrackerDto> readAll() {
        return timeTrackerService.readAll();
    }
}
