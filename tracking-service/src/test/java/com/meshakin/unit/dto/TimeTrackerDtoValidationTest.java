package com.meshakin.unit.dto;

import com.meshakin.dto.TimeTrackerDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.Set;

import static com.meshakin.entity.ApplicationType.BROWSER;
import static com.meshakin.entity.Device.COMPUTER;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TimeTrackerDtoValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void whenEndTimeBeforeStartTimeReturnTrue() {
        TimeTrackerDto dto = new TimeTrackerDto(null, "app", BROWSER, COMPUTER,
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now()
        );

        Set<ConstraintViolation<TimeTrackerDto>> violations = validator.validate(dto);

        assertThat(violations).isNotEmpty();
    }

    @Test
    void whenStartTimeBeforeEndTimeReturnFalse() {
        TimeTrackerDto dto = new TimeTrackerDto(null, "app", BROWSER, COMPUTER,
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now().minusHours(1)
        );

        Set<ConstraintViolation<TimeTrackerDto>> violations = validator.validate(dto);

        assertThat(violations).isEmpty();
    }
}
