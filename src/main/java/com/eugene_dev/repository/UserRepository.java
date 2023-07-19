package com.eugene_dev.repository;

import com.eugene_dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userid);
    User findByUserName(String userName);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
 }
