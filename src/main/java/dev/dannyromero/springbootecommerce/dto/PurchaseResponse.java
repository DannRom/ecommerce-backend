package dev.dannyromero.springbootecommerce.dto;

import java.util.Objects;

public class PurchaseResponse {
    private String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseResponse)) return false;
        PurchaseResponse that = (PurchaseResponse) o;
        return Objects.equals(getOrderTrackingNumber(), that.getOrderTrackingNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderTrackingNumber());
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "orderTrackingNumber='" + orderTrackingNumber + '\'' +
                '}';
    }
}
