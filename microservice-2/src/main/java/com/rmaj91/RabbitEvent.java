package com.rmaj91;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RabbitEvent implements Serializable {

    private String description;
    private String additionalData;
    private int someId;

    @Override
    public String toString() {
        return "RabbitEvent{" +
                "description='" + description + '\'' +
                ", additionalData='" + additionalData + '\'' +
                ", someId=" + someId +
                '}';
    }
}
