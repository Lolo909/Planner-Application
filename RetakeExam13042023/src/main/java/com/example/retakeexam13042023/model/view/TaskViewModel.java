package com.example.retakeexam13042023.model.view;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;

import java.time.LocalDate;

public class TaskViewModel {
    private Long id;

    private String description;

    private LocalDate dueDate;

    private PriorityNameEnum priority;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public TaskViewModel setPriority(PriorityNameEnum priority) {
        this.priority = priority;
        return this;
    }
}
