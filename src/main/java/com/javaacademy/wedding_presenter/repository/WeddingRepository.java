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
    private BookWedding bookWedding;

    public void save(int monthNumber, int dayNumber) {
        Map<UUID, BookWedding> bookDay = new HashMap<>(weddingBookingStorage.getStorageMap());
        bookWedding.setDayNumber(dayNumber);
        bookWedding.setMonthNumber(monthNumber);
        bookWedding.setBooked(true);
        UUID uuid = UUID.randomUUID();
        if (uuid != null && bookDay.containsKey(uuid)) {
            throw new RuntimeException(
                    String.format("Заказ под таким номером %s уже сделан", uuid));
        }
        bookDay.put(uuid, bookWedding);
    }

    public List<BookWedding> getAll() {
        return new ArrayList<>(weddingBookingStorage.getStorageMap().values());
    }

    public List<BookWedding> findBookingInMonth(int month) {
        return weddingBookingStorage.getStorageMap().values().stream()
                .filter(e -> e.getMonthNumber() == month)
                .collect(Collectors.toList());
    }

    public int bookingDaysInMonth(int month) {
        return findBookingInMonth(month).size();
    }

}
