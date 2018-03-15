package com.rbs.services;

import com.rbs.objects.Customer;
import com.rbs.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by dgup27 on 3/15/2017.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
