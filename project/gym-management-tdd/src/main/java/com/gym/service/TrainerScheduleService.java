package com.gym.service;

import com.gym.model.GymClass;
import com.gym.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerScheduleService {

    private final List<GymClass> assignedClasses = new ArrayList<>();

    public void assignTrainerToClass(Trainer trainer, GymClass newClass) {
        if (trainer == null) {
            throw new IllegalArgumentException("Trainer is required");
        }

        if (newClass == null) {
            throw new IllegalArgumentException("Gym class is required");
        }

        for (GymClass assignedClass : assignedClasses) {
            boolean sameTrainer = assignedClass.getTrainer() != null
                    && assignedClass.getTrainer().getId().equals(trainer.getId());

            if (sameTrainer && assignedClass.overlapsWith(newClass)) {
                throw new IllegalStateException("Trainer already has an overlapping class");
            }
        }

        newClass.assignTrainer(trainer);
        assignedClasses.add(newClass);
    }

    public List<GymClass> getAssignedClassesForTrainer(Trainer trainer) {
        List<GymClass> result = new ArrayList<>();

        for (GymClass gymClass : assignedClasses) {
            if (gymClass.getTrainer() != null && gymClass.getTrainer().getId().equals(trainer.getId())) {
                result.add(gymClass);
            }
        }

        return result;
    }
}