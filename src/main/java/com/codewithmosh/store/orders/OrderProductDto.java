package com.codewithmosh.store.orders;

import java.math.BigDecimal;

public record OrderProductDto(
        Long id,
        String name,
        BigDecimal price
) {}
