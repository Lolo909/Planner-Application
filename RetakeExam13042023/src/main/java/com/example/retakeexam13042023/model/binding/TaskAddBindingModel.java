package com.example.retakeexam13042023.model.binding;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskAddBindingModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @NotNull(message = "Enter date!")
    @Future(message = "Due Date must be in the future!")
    private LocalDate dueDate;

    @NotNull(message = "You must select priority!")
    private PriorityNameEnum priority;

    public TaskAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public TaskAddBindingModel setPriority(PriorityNameEnum priority) {
        this.priority = priority;
        return this;
    }
}
