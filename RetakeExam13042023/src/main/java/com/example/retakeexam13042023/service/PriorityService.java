package com.example.retakeexam13042023.service;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;

public interface PriorityService {
    void initCategories();

    Priority findByCategoryNameEnum(PriorityNameEnum priority);
}
