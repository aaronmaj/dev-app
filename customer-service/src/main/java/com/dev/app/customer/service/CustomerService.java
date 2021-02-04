package com.dev.app.customer.service;

import com.dev.app.common.resources.dto.CustomerDto;
import com.dev.app.customer.domain.Customer;
import com.dev.app.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public List<CustomerDto> findAll() {
        log.debug("Retrieving all customers...");
        return customerRepository.findAll()
                .stream()
                .map(customer -> convertToDto(customer))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        log.debug("Retrieving customer with Id : {}...", id);
        return convertToDto(customerRepository.findById(id).orElse(null));
    }

    public CustomerDto create(CustomerDto customerDto) {
        log.debug("Creating/updating a new customer with name : {}...", customerDto.getName());
        return convertToDto(customerRepository.save(convertToEntity(customerDto)));
    }
    public String delete(Long id){
        log.debug("Deleting customer with Id : {}...", id);
        customerRepository.deleteById(id);
        return "Customer deleted successfully";
    }
    private CustomerDto convertToDto(Customer customer) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(customer, CustomerDto.class);
    }

    private Customer convertToEntity(CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);

        if (customerDto.getId() != null) {
            Customer oldCustomer = customerRepository.findById(customerDto.getId()).get();
            customer.setId(oldCustomer.getId());
            //add setters here
        }
        return customer;
    }
}
