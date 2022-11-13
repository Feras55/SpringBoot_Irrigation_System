package com.irrigationsystem.entity.dao;

import com.irrigationsystem.entity.dto.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Integer> {
}
