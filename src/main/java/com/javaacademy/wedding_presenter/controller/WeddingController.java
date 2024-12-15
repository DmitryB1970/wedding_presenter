package com.javaacademy.wedding_presenter.controller;

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

    @GetMapping("/month/{month}")
    public List<CreateBookDto> findByMonth(@PathVariable Integer month) {
        return weddingService.findABookingInMonth(month);
    }


    @PostMapping
    public void save(@RequestBody CreateBookDto dto) {
        weddingService.save(dto.getMonth(), dto.getDay());
    }


    @GetMapping("/month/{month}/free")
    public Map<String, Integer> bookingDaysInMonth(@RequestParam Integer month) {
        return Map.of("count", weddingService.bookingDaysInMonth(month));
    }

    @GetMapping
    public void findAll() {
        weddingService.getAll();
    }
}
