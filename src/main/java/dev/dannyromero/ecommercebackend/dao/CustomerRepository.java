package dev.dannyromero.ecommercebackend.dao;

import dev.dannyromero.ecommercebackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
