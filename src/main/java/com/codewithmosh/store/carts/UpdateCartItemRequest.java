package com.codewithmosh.store.carts;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateCartItemRequest(
        @NotNull(message = "Quantity must be provided")
        @Min(value = 1, message = "Quantity must be greater than zero")
        @Max(value = 1000, message= "Quantity must be less than or equal to 1000")
        // int型にすると､空のJSONが送られてきたとき､0として扱われてしまう
        // 空のJSONが送られたときには､NotNullに書いたようなmessageを送るために､Integer型になっている
        Integer quantity
) {}
