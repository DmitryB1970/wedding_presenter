package com.javaacademy.wedding_presenter.storage;

import com.javaacademy.wedding_presenter.entity.BookWedding;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class WeddingBookingStorage {
    @Getter
    private final Map<UUID, BookWedding> storageMap = new HashMap<>();

}
