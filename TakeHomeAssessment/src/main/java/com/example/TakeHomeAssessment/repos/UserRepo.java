package com.example.TakeHomeAssessment.repos;

import com.example.TakeHomeAssessment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
