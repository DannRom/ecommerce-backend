package dev.dannyromero.springbootecommerce.service;

import dev.dannyromero.springbootecommerce.dto.Purchase;
import dev.dannyromero.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
