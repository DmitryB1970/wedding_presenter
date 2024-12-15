package com.javaacademy.wedding_presenter.repository;


import com.javaacademy.wedding_presenter.entity.BookWedding;
import com.javaacademy.wedding_presenter.storage.WeddingBookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WeddingRepository {

    private final WeddingBookingStorage weddingBookingStorage;


    public void save(int monthNumber, int dayNumber) {
        BookWedding bookWedding = new BookWedding(UUID.randomUUID(), monthNumber, dayNumber, true);
        weddingBookingStorage.getStorageMap().put(bookWedding.getUuid(), bookWedding);
    }

    public List<BookWedding> getAll() {
        return new ArrayList<>(weddingBookingStorage.getStorageMap().values());
    }

    public List<BookWedding> findBookingInMonth(int month) {
        return weddingBookingStorage.getStorageMap().values().stream()
                .filter(e -> e.getMonthNumber() == month)
                .collect(Collectors.toList());
    }

    public Integer bookingDaysInMonth(int month) {
        return findBookingInMonth(month).size();
    }

}
