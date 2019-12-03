package com.adaming.project.alexander_time_manager.repository;

import com.adaming.project.alexander_time_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
