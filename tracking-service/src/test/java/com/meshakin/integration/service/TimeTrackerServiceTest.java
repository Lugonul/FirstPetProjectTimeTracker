package com.meshakin.integration.service;

import com.meshakin.TestContainersBase;
import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.service.TimeTrackerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TimeTrackerServiceTest extends TestContainersBase {
    @Autowired
    private TimeTrackerService timeTrackerService;

    private final TimeTrackerDto timeTrackerDto = new TimeTrackerDto(
            null,
            1000L
    );


    @Test
    public void CreateTest() {
        TimeTrackerDto created = timeTrackerService.create(timeTrackerDto);
        assertThat(created.time()).isEqualTo(timeTrackerDto.time());
    }

    @Test
    public void ReadTest() {
        Long createdId = timeTrackerService.create(timeTrackerDto).id();
        TimeTrackerDto readDto = timeTrackerService.readById(createdId);

        assertThat(readDto.time()).isEqualTo(timeTrackerDto.time());
    }

    @Test
    public void ReadAllTest() {
        int size = timeTrackerService.readAll().size();
        timeTrackerService.create(timeTrackerDto);
        timeTrackerService.create(timeTrackerDto);
        assertThat(timeTrackerService.readAll()).hasSize(size + 2);
    }

}
