package dev.dannyromero.springbootecommerce.dto;

import dev.dannyromero.springbootecommerce.entity.Address;
import dev.dannyromero.springbootecommerce.entity.Customer;
import dev.dannyromero.springbootecommerce.entity.Order;
import dev.dannyromero.springbootecommerce.entity.OrderItem;

import java.util.Objects;
import java.util.Set;

public class Transaction {
    private final Customer customer;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final Order order;
    private final Set<OrderItem> orderItems;

    public Transaction(Customer customer, Address billingAddress, Address shippingAddress, Order order, Set<OrderItem> orderItems) {
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.order = order;
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getBillingAddress(), that.getBillingAddress()) && Objects.equals(getShippingAddress(), that.getShippingAddress()) && Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getOrderItems(), that.getOrderItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getBillingAddress(), getShippingAddress(), getOrder(), getOrderItems());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer=" + customer +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", order=" + order +
                ", orderItems=" + orderItems +
                '}';
    }
}
