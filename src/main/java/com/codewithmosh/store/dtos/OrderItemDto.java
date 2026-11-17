package com.codewithmosh.store.dtos;

import java.math.BigDecimal;

public record OrderItemDto(
        OrderProductDto product,
        int quantity,
        BigDecimal totalPrice
) {}
