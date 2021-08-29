package dev.dannyromero.springbootecommerce.dao;

import dev.dannyromero.springbootecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
