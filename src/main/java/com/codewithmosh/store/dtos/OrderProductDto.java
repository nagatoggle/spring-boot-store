package com.codewithmosh.store.dtos;

import java.math.BigDecimal;

public record OrderProductDto(
        Long id,
        String name,
        BigDecimal price
) {}
