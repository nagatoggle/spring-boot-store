package com.codewithmosh.store.dtos;

import java.math.BigDecimal;

public record CartItemDto(
    CartProductDto product,
    int quantity,
    BigDecimal totalPrice
) {}
