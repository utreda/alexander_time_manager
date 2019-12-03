package com.adaming.project.alexander_time_manager.repository;

import com.adaming.project.alexander_time_manager.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
