package com.javaacademy.wedding_presenter.service;

import com.javaacademy.wedding_presenter.dto.BookWeddingDto;
import com.javaacademy.wedding_presenter.mapper.BookWeddingMapper;
import com.javaacademy.wedding_presenter.repository.WeddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeddingService {

    private final WeddingRepository weddingRepository;
    private final BookWeddingMapper bookWeddingMapper;

    public void save(int monthNumber, int dayNumber) {
        weddingRepository.save(monthNumber, dayNumber);
    }

    public List<BookWeddingDto> findABookingInMonth(int month) {
        return weddingRepository.getAll().stream()
                .map(e -> bookWeddingMapper.convertToDto(e))
                .collect(Collectors.toList());
    }

    public int bookingDaysInMonth(int month) {
        return weddingRepository.bookingDaysInMonth(month);
    }

    public void getAll() {
        weddingRepository.getAll();
    }
}
