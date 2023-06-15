package com.example.WebApplication.Controller;


import com.example.WebApplication.Entity.Customer;
import com.example.WebApplication.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository customers;

    public CustomerController(CustomerRepository customers) {
        this.customers = customers;
    }

    @GetMapping("/customers/{customerId}")
    public Customer GetUserById(@PathVariable("customerId") int customerId){

        return customers.findById(customerId);
    }

    @PostMapping ("/customers/new")
    public String CreateUserById( @RequestBody Customer customer ){
        customers.insertUser(customer.getFirstName(),customer.getFirstName(), customer.getAddress(), customer.getCity(), customer.getTelephone());
        customers.save(customer);
        return "redirect:/customers/"+ customer.getId();
    }

    @PutMapping("/customers/{customerId}/edit")
    public String UpdateUserById(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        customers.updateById(customerId, customer.getFirstName(),customer.getFirstName(), customer.getAddress(), customer.getCity(), customer.getTelephone());
        customers.save(customer);
        return "redirect:/customers/{customerId}";
    }

    @DeleteMapping ("/customers/{customerId}")
    public void DelUser(@PathVariable("customerId") int customerId){
        customers.delById(customerId);
    }
}
