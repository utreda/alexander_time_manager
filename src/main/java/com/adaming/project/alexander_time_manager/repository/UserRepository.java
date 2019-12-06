package com.adaming.project.alexander_time_manager.repository;

import com.adaming.project.alexander_time_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User As u WHERE u.pseudo=:pseudo")
    User getByPseudo(String pseudo);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM User WHERE id =:id")
    void deleteById(Long id);
}
