package com.codewithmosh.store.payments;

public record CheckoutResponse(
        Long orderId,
        String checkoutUrl
) {
    public CheckoutResponse(Long orderId, String checkoutUrl) {
        this.orderId = orderId;
        this.checkoutUrl = checkoutUrl;
    }
}
