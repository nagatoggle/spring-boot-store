package com.codewithmosh.store.carts;

import jakarta.validation.constraints.NotNull;

public record addItemToCartRequest(
        @NotNull
        Long productId
) {}
