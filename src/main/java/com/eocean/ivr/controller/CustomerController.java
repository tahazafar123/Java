package com.eocean.ivr.controller;

import com.eocean.ivr.persistance.domain.Customer;
import com.eocean.ivr.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/add")
    public ResponseEntity addCustomer(Customer customer){

        customerRepository.save(customer);

        return null;
    }


    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        List<Customer> customers  = (List<Customer>) customerRepository.findAll();
        return customers;
    }


    @GetMapping(value = "/byid" , params = {"id"})
    public String getAllCustomer(@Param("id") Long customerId){
        try{
            Optional<Customer> customers =  customerRepository.findById(customerId);
            //if(custom == null)
        }
        catch (NullPointerException n){

        }
        catch (Exception e ){

            return "No data found";
        }
        String customer;
        return "customer";
    }


}
