package com.javaacademy.wedding_presenter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookWeddingDto {

    private int monthNumber;
    private int dayNumber;
    private boolean isBooked;

}
