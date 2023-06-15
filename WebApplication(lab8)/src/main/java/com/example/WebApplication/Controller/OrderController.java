package com.example.WebApplication.Controller;

import com.example.WebApplication.Entity.Order;
import com.example.WebApplication.Repository.OrderRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderRepository orders;

    public OrderController(OrderRepository orders) {
        this.orders = orders;
    }

    @GetMapping("/orders/{orderId}")
    public Order GetUserById(@PathVariable("orderId") int orderId){

        return orders.findById(orderId);
    }

    @PostMapping("/orders/new")
    public String CreateUserById(@RequestBody Order order){
        orders.insertUser(order.getCustomerId(), order.getAddress(), order.getCity(), order.getTelephone());
        orders.save(order);
        return "redirect:/orders/"+ order.getId();
    }

    @PutMapping("/orders/{orderId}/edit")
    public String UpdateUserById(@PathVariable("orderId") int orderId, @RequestBody Order order){
        orders.updateById(orderId, order.getCustomerId(), order.getAddress(), order.getCity(), order.getTelephone());
        orders.save(order);
        return "redirect:/orders/{orderId}";
    }

    @DeleteMapping("/orders/{orderId}")
    public void DelUser(@PathVariable("orderId") int orderId){
        orders.delById(orderId);
    }
}
