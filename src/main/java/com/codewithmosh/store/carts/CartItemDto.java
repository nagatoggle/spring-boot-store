package com.codewithmosh.store.carts;

import java.math.BigDecimal;

public record CartItemDto(
    CartProductDto product,
    int quantity,
    BigDecimal totalPrice
) {}
