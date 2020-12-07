package com.rmaj91.sender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class RabbitEvent implements Serializable {

    private final String description;
    private final String additionalData;
    private final int someId;
}
