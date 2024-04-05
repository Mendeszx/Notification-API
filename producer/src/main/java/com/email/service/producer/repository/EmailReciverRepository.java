package com.email.service.producer.repository;

import com.email.service.producer.model.EmailReciver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailReciverRepository extends JpaRepository<EmailReciver, Long> {
}
