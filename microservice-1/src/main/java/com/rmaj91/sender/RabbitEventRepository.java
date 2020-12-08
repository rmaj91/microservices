package com.rmaj91.sender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabbitEventRepository extends JpaRepository<RabbitEventEntity, Long> {
}
