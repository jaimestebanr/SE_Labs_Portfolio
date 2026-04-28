package com.gym.service;

import com.gym.model.GymClass;
import com.gym.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerScheduleServiceTest {

    private TrainerScheduleService trainerScheduleService;
    private Trainer trainer;

    @BeforeEach
    void setUp() {
        trainerScheduleService = new TrainerScheduleService();
        trainer = new Trainer("T001", "David Trainer");
    }

    @Test
    void shouldAssignTrainerToClass() {
        GymClass spinning = createClass(
                "C001",
                "Spinning",
                10,
                0,
                11,
                0
        );

        trainerScheduleService.assignTrainerToClass(trainer, spinning);

        assertEquals(trainer, spinning.getTrainer());
    }

    @Test
    void shouldRejectTrainerAssignmentWhenClassOverlaps() {
        GymClass spinning = createClass(
                "C001",
                "Spinning",
                10,
                0,
                11,
                0
        );

        GymClass boxing = createClass(
                "C002",
                "Boxing",
                10,
                30,
                11,
                30
        );

        trainerScheduleService.assignTrainerToClass(trainer, spinning);

        assertThrows(
                IllegalStateException.class,
                () -> trainerScheduleService.assignTrainerToClass(trainer, boxing)
        );
    }

    @Test
    void shouldAllowTrainerAssignmentWhenClassesDoNotOverlap() {
        GymClass spinning = createClass(
                "C001",
                "Spinning",
                10,
                0,
                11,
                0
        );

        GymClass pilates = createClass(
                "C002",
                "Pilates",
                11,
                0,
                12,
                0
        );

        trainerScheduleService.assignTrainerToClass(trainer, spinning);
        trainerScheduleService.assignTrainerToClass(trainer, pilates);

        List<GymClass> assignedClasses = trainerScheduleService.getAssignedClassesForTrainer(trainer);

        assertEquals(2, assignedClasses.size());
    }

    private GymClass createClass(String id, String name, int startHour, int startMinute, int endHour, int endMinute) {
        return new GymClass(
                id,
                name,
                LocalDateTime.of(2026, 4, 20, startHour, startMinute),
                LocalDateTime.of(2026, 4, 20, endHour, endMinute),
                10
        );
    }
}