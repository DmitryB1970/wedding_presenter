package com.javaacademy.wedding_presenter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookDto {
    private Integer month;
    private Integer day;
}
