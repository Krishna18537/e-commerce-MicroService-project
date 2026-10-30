package com.orderservice.orderservice;

import com.orderservice.client.ProductClient;
import com.orderservice.client.UserClient;
import com.orderservice.model.Order;
import com.orderservice.orderrepository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;

    public Order createOrder(Order order) {
        Map<String,Object> product=productClient.getProductById(order.getProductId());
        if((product==null) || (product.isEmpty()))
        {
            throw new RuntimeException("Product Not Found..");
        }

        Map<String,Object> user=userClient.getUserById(order.getUserId());
        if((user==null) || (user.isEmpty()))
        {
            throw new RuntimeException("User Not Found..");
        }

        Number price=(Number) product.get("price");

        double totalamt= price.doubleValue() * order.getQuantity();

        order.setTotalAmt(totalamt);
        order.setStatus("PLACED");

        return orderRepository.save(order);

    }

    public List<Order> getAllOrders() {
        return  orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found.."));
    }

    public Order updateOrder(Integer id, String status) {
        Order order=getOrderById(id);
        order.setStatus(status);

        return orderRepository.save(order);
    }
}
