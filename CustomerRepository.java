package com.rbs.repositories;

import com.rbs.objects.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dgup27 on 3/15/2017.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer save(Customer customer);
}
