package dev.dannyromero.springbootecommerce.controller;

import dev.dannyromero.springbootecommerce.dao.CustomerRepository;
import dev.dannyromero.springbootecommerce.dto.Purchase;
import dev.dannyromero.springbootecommerce.dto.PurchaseResponse;
import dev.dannyromero.springbootecommerce.entity.Customer;
import dev.dannyromero.springbootecommerce.entity.Order;
import dev.dannyromero.springbootecommerce.entity.OrderItem;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CustomerRepository customerRepository;

    public CheckoutController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/purchase")
    @Transactional
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = UUID.randomUUID().toString();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

}
