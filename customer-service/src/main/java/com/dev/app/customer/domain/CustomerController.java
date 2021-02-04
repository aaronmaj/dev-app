package com.dev.app.customer.domain;

import com.dev.app.common.resources.dto.CustomerDto;
import com.dev.app.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dev.app.common.resources.util.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = API + "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDto>> findAll() {
        return ResponseEntity.ok(customerService.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> create(CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.create(customerDto));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDto> update(CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.create(customerDto));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.delete(id));
    }
}
