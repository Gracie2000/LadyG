package com.example.SubtaskCRUD.repository;

import com.example.SubtaskCRUD.entity.SubtaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<SubtaskEntity, Long> {
    //All crud methods for database
}
