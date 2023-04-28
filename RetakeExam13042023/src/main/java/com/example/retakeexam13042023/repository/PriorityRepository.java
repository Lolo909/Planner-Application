package com.example.retakeexam13042023.repository;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Optional<Priority> findByName(PriorityNameEnum categoryNameEnum);
}
