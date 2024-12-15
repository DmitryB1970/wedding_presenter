package com.javaacademy.wedding_presenter.mapper;

import com.javaacademy.wedding_presenter.dto.CreateBookDto;
import com.javaacademy.wedding_presenter.entity.BookWedding;
import org.springframework.stereotype.Service;

@Service
public class BookWeddingMapper {

    public CreateBookDto convertToDto(BookWedding bookWedding) {
        return new CreateBookDto(bookWedding.getMonthNumber(), bookWedding.getDayNumber());
    }
}
