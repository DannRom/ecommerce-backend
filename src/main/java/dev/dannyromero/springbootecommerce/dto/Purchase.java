package dev.dannyromero.springbootecommerce.dto;

import dev.dannyromero.springbootecommerce.entity.Address;
import dev.dannyromero.springbootecommerce.entity.Customer;
import dev.dannyromero.springbootecommerce.entity.Order;
import dev.dannyromero.springbootecommerce.entity.OrderItem;

import java.util.Objects;
import java.util.Set;

public class Purchase {
    private Customer customer;
    private Address billingAddress;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

    public Purchase(Customer customer, Address billingAddress, Address shippingAddress, Order order, Set<OrderItem> orderItems) {
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.order = order;
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(getCustomer(), purchase.getCustomer()) && Objects.equals(getBillingAddress(), purchase.getBillingAddress()) && Objects.equals(getShippingAddress(), purchase.getShippingAddress()) && Objects.equals(getOrder(), purchase.getOrder()) && Objects.equals(getOrderItems(), purchase.getOrderItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getBillingAddress(), getShippingAddress(), getOrder(), getOrderItems());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "customer=" + customer +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", order=" + order +
                ", orderItems=" + orderItems +
                '}';
    }
}
