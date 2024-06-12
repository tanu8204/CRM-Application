package com.example.CRMProject.controller;
import com.example.CRMProject.dto.CustomerDetailsResponse;
import com.example.CRMProject.entity.Customer;
import com.example.CRMProject.entity.Order;
import com.example.CRMProject.reposiory.CustomerRepository;
import com.example.CRMProject.reposiory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customerDetails) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerDetails.getName());
                    customer.setEmail(customerDetails.getEmail());
                    Customer updatedCustomer = customerRepository.save(customer);
                    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    List<Order> orders = orderRepository.findByCustomerId(id);
                    orderRepository.deleteAll(orders);
                    customerRepository.delete(customer);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/getDetails")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("getDetailsbyId/{id}")
    public ResponseEntity<CustomerDetailsResponse> getCustomerDetails(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    List<Order> orders = orderRepository.findByCustomerId(id);
                    CustomerDetailsResponse response = new CustomerDetailsResponse(customer, orders);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
