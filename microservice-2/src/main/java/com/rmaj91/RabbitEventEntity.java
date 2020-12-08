package com.rmaj91;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "rabbit_event_receiver")
public class RabbitEventEntity {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String message;
    @CreationTimestamp
    private LocalDateTime created;
}
