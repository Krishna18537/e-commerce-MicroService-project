package com.orderservice.ordercontroller;

import com.orderservice.model.Order;
import com.orderservice.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public Order createOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id)
    {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/status")
    public Order updateOrder(@PathVariable Integer id,@RequestParam String status)
    {
        return orderService.updateOrder(id,status);
    }
}
