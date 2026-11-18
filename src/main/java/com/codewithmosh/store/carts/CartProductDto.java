package com.codewithmosh.store.carts;

import java.math.BigDecimal;

public record CartProductDto(
    Long id,
    String name,
    BigDecimal price
) {}
