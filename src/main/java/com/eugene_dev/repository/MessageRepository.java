package com.eugene_dev.repository;

import com.eugene_dev.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findByMessageId(Long id);
}
