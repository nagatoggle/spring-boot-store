package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.NotNull;

public record addItemToCartRequest(
        @NotNull
        Long productId
) {}
