package com.javaacademy.wedding_presenter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookWedding {

    private int monthNumber;
    private int dayNumber;
    private boolean isBooked;
}
