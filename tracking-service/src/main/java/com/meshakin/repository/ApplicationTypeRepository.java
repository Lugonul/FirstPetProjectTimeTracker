package com.meshakin.repository;

import com.meshakin.entity.ApplicationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationTypeEntity, Long> {
}
