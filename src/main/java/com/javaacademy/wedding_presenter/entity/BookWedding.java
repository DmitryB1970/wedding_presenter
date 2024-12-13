package com.javaacademy.wedding_presenter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BookWedding {
    private UUID id;
    private int monthNumber;
    private int dayNumber;
    private boolean isBooked;
}
