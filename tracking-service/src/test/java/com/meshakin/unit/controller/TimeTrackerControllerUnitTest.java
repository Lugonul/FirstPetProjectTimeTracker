package com.meshakin.unit.controller;

import com.meshakin.controller.TimeTrackerController;
import com.meshakin.dto.TimeTrackerDto;
import com.meshakin.entity.ApplicationType;
import com.meshakin.entity.Device;
import com.meshakin.service.TimeTrackerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TimeTrackerControllerUnitTest {

    @Mock
    private TimeTrackerService timeTrackerService;

    @InjectMocks
    private TimeTrackerController timeTrackerController;


    private TimeTrackerDto timeTrackerDtoWitoutId = new TimeTrackerDto(
            null,
            "exampleName",
            ApplicationType.APPLICATION,
            Device.COMPUTER,
            LocalDateTime.now().minusHours(1),
            LocalDateTime.now()
    );

    private TimeTrackerDto timeTrackerDto = new TimeTrackerDto(
            1L,
            "exampleName",
            ApplicationType.APPLICATION,
            Device.COMPUTER,
            LocalDateTime.now().minusHours(1),
            LocalDateTime.now()
    );


    @Test
    public void post() {
        when(timeTrackerService.create(timeTrackerDtoWitoutId)).thenReturn(timeTrackerDto);

        TimeTrackerDto result = timeTrackerController.post(timeTrackerDtoWitoutId);
        Assertions.assertThat(result).isEqualTo(timeTrackerDto);
    }

    @Test
    public void readByIdShouldReturnTimeTrackerDto() {
        when(timeTrackerService.readById(anyLong())).thenReturn(timeTrackerDto);

        TimeTrackerDto readDto = timeTrackerController.readById(1L);

        assertThat(readDto).isEqualTo(timeTrackerDto);
    }

    @Test
    public void readByIdShouldReturnNullWhenNotFound() {
        when(timeTrackerService.readById(anyLong())).thenReturn(null);

        TimeTrackerDto readDto = timeTrackerController.readById(1L);

        assertThat(readDto).isEqualTo(null);
    }


}
