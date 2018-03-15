package com.rbs.controller;

import com.rbs.objects.Customer;
import com.rbs.objects.CustomerAddress;
import com.rbs.services.CustomerService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

/**
 * Created by dgup27 on 3/15/2017.
 */
@RestController
@Api(name = "Spring Rest Demo", description = "Services for Spring Rest Demo", visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiMethod(path = "/getCustomer/{id}", description = "Gets details of customer based on ID in XML Format", produces=
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, responsestatuscode = "200 - Ok")
    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<Customer> getCustomer(@ApiPathParam(name = "CustomerID", description = "Id for which details to be fetched") @PathVariable("id") String id) {
        Customer returnCustomer = customerService.findById(id);
        if(returnCustomer != null) {
            return new ResponseEntity<>(returnCustomer, HttpStatus.OK);
        } else {
            System.out.printf("Customer is not present");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/addCustomerDetails", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> addCustomerDetails(@RequestBody Customer customer, UriComponentsBuilder builder) {
        customer = customerService.save(customer);
        if(customer.getId() == null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/getCustomer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
