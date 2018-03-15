package com.rbs.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jsondoc.core.annotation.ApiObject;
import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dgup27 on 3/15/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiObject(name = "customer")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement
    @Id
    private String id;

    @XmlElement
    private CustomerAddress customerAddress;

    @XmlElement
    private String name;

    @XmlElement
    private String email;

    @XmlElement
    private String contactNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}