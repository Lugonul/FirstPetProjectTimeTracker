package com.meshakin.integration.service;

import com.meshakin.TestContainersBase;
import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.ApplicationType;
import com.meshakin.entity.Device;
import com.meshakin.service.TimeTrackerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TimeTrackerServiceIntegrationTest extends TestContainersBase {
    @Autowired
    private TimeTrackerService timeTrackerService;

    private final TimeTrackerDto timeTrackerDto = new TimeTrackerDto(
            null,
            "exampleName",
            ApplicationType.BROWSER,
            Device.MOBILE,
            LocalDateTime.of(2025, 8 , 20 ,20 , 0),
            LocalDateTime.of(2025, 9 , 20 ,20 , 0)
    );


    @Test
    public void CreateTest() {
        TimeTrackerDto created = timeTrackerService.create(timeTrackerDto);
        Assertions.assertAll(
                () -> assertThat(created.applicationName()).isEqualTo(timeTrackerDto.applicationName()),
                () -> assertThat(created.applicationType()).isEqualTo(timeTrackerDto.applicationType()),
                () -> assertThat(created.device()).isEqualTo(timeTrackerDto.device()),
                () -> assertThat(created.startTime()).isEqualTo(timeTrackerDto.startTime()),
                () -> assertThat(created.endTime()).isEqualTo(timeTrackerDto.endTime())
        );

    }

    @Test
    public void ReadTest() {
        Long createdId = timeTrackerService.create(timeTrackerDto).id();
        TimeTrackerDto readDto = timeTrackerService.readById(createdId);

        Assertions.assertAll(
                () -> assertThat(readDto.applicationName()).isEqualTo(timeTrackerDto.applicationName()),
                () -> assertThat(readDto.applicationType()).isEqualTo(timeTrackerDto.applicationType()),
                () -> assertThat(readDto.device()).isEqualTo(timeTrackerDto.device()),
                () -> assertThat(readDto.startTime()).isEqualTo(timeTrackerDto.startTime()),
                () -> assertThat(readDto.endTime()).isEqualTo(timeTrackerDto.endTime())
        );
    }

    @Test
    public void ReadAllTest() {
        int size = timeTrackerService.readAll().size();
        timeTrackerService.create(timeTrackerDto);
        timeTrackerService.create(timeTrackerDto);
        assertThat(timeTrackerService.readAll()).hasSize(size + 2);
    }

}
