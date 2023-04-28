package com.example.retakeexam13042023.model.service;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class TaskAddServiceModel {

    private Long id;

    private String description;

    private LocalDate dueDate;

    private PriorityNameEnum priority;

    public TaskAddServiceModel() {
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public TaskAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public TaskAddServiceModel setPriority(PriorityNameEnum priority) {
        this.priority = priority;
        return this;
    }
}
