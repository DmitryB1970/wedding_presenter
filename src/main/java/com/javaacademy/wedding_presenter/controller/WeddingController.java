package com.javaacademy.wedding_presenter.controller;

import com.javaacademy.wedding_presenter.dto.BookWeddingDto;
import com.javaacademy.wedding_presenter.dto.CreateBookDto;
import com.javaacademy.wedding_presenter.service.WeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
public class WeddingController {

    private final WeddingService weddingService;

    @GetMapping("/month/{monthNumber}")
    public List<BookWeddingDto> findByMonth(@PathVariable Integer monthNumber) {
        return weddingService.findABookingInMonth(monthNumber);
    }


    @PostMapping
    public void save(@RequestBody CreateBookDto dto) {
        weddingService.save(dto.getMonth(), dto.getDay());
    }


    @GetMapping("/month/{monthNumber}/free")
    public Map<String, Integer> bookingDaysInMonth(@PathVariable Integer monthNumber) {
        return Map.of("count", weddingService.bookingDaysInMonth(monthNumber));
    }

    @GetMapping
    public void findAll() {
        weddingService.getAll();
    }
}
