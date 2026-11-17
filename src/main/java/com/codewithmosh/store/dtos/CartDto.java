package com.codewithmosh.store.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record CartDto(
        UUID id,
        List<CartItemDto> items,
        BigDecimal totalPrice
) {
    public CartDto {
        if (items == null) {
            items = new ArrayList<>();
        }

        if (totalPrice == null) {
            totalPrice = BigDecimal.ZERO;
        }
    }
}