package com.meshakin.repository;

import com.meshakin.entity.TimeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackerRepository extends JpaRepository<TimeTrackerEntity,Long> {
}
