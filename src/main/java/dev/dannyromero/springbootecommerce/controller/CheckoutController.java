package dev.dannyromero.springbootecommerce.controller;

import dev.dannyromero.springbootecommerce.dao.CustomerRepository;
import dev.dannyromero.springbootecommerce.dto.Response;
import dev.dannyromero.springbootecommerce.dto.Transaction;
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

    @PostMapping("/transaction")
    @Transactional
    public Response placeOrder(@RequestBody Transaction transaction) {
        Order order = transaction.getOrder();

        String orderTrackingNumber = UUID.randomUUID().toString();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = transaction.getOrderItems();
        orderItems.forEach(order::add);

        order.setBillingAddress(transaction.getBillingAddress());
        order.setShippingAddress(transaction.getShippingAddress());

        Customer customer = transaction.getCustomer();
        customer.add(order);

        customerRepository.save(customer);
        return new Response(orderTrackingNumber);
    }

}
