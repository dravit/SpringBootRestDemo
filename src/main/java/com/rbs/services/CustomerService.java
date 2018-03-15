package com.rbs.services;

import com.rbs.objects.Customer;

/**
 * Created by dgup27 on 3/15/2017.
 */
public interface CustomerService {

    Customer findById(String id);

    Customer save(Customer customer);
}
