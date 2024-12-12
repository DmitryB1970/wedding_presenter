package com.javaacademy.wedding_presenter.mapper;

import com.javaacademy.wedding_presenter.dto.BookWeddingDto;
import com.javaacademy.wedding_presenter.entity.BookWedding;
import org.springframework.stereotype.Service;

@Service
public class BookWeddingMapper {

    public BookWeddingDto convertToDto(BookWedding bookWedding) {
        return new BookWeddingDto(bookWedding.getMonthNumber(), bookWedding.getDayNumber(), bookWedding.isBooked());
    }
}
