package com.javaacademy.wedding_presenter.controller;

import com.javaacademy.wedding_presenter.dto.BookWeddingDto;
import com.javaacademy.wedding_presenter.service.WeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class WeddingController {

    private final WeddingService weddingService;

    @GetMapping("/month/{monthNumber}")
    public List<BookWeddingDto> findByMonth(@PathVariable int monthNumber) {
        return weddingService.findABookingInMonth(monthNumber);
    }


    @PostMapping
    public void save(@RequestBody BookWeddingDto dto) {
        weddingService.save(dto.getMonthNumber(), dto.getDayNumber());
    }


    @GetMapping("/month/{monthNumber}/free")
    public int bookingDaysInMonth(@RequestParam int monthNumber) {
        return weddingService.bookingDaysInMonth(monthNumber);
    }

    @GetMapping
    public void findAll() {
        weddingService.getAll();
    }
}
