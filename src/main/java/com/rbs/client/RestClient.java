package com.rbs.client;

import com.rbs.objects.Customer;
import com.rbs.objects.CustomerAddress;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestClient {

    public static void main(String args[]) {
        RestClient util = new RestClient();
        util.getCustomerByIdDemo();
        //util.addCustomerDemo();
    }


    public void getCustomerByIdDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/customer/getCustomer/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer.class, 1);
        Customer customer = responseEntity.getBody();
        System.out.println("Id:"+customer.getId()+", Name:"+customer.getName()
                +", Email:"+customer.getEmail());
    }


    public void addCustomerDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/customer/addCustomerDetails";
        Customer objCustomer = new Customer();
        objCustomer.setId("4");         //Change this for new add. This can be set to dynamic using ORM
        objCustomer.setName("33");
        objCustomer.setContactNumber("3333");
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setCity("33");
        customerAddress.setPostalCode("33");
        customerAddress.setState("33");
        customerAddress.setStreet("33");
        customerAddress.setHouseNo(3);
        objCustomer.setCustomerAddress(customerAddress);
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(objCustomer, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
}
