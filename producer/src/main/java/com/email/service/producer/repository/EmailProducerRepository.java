package com.email.service.producer.repository;

import com.email.service.producer.model.EmailProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailProducerRepository extends JpaRepository<EmailProducer, Long> {
}
