package com.adaming.project.alexander_time_manager.repository;

import com.adaming.project.alexander_time_manager.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
