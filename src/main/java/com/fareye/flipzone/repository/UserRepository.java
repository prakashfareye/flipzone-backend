package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // userEmailId
    User findByUserEmailId(String email);

}
