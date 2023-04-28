package com.example.retakeexam13042023.model.entity;

import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private PriorityNameEnum name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority", fetch = FetchType.EAGER)
    private Set<Task> tasks;


    public Priority() {
    }

    public Priority(PriorityNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public PriorityNameEnum getName() {
        return name;
    }

    public Priority setName(PriorityNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Priority setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Priority setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
