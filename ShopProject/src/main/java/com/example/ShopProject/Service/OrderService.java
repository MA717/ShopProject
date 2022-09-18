package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Order;
import com.example.ShopProject.Entity.OrderStatus;
import com.example.ShopProject.Repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository ;

    public Order SaveOrder(Order order  )
    {
       return orderRepository.save(order);

    }
    public Order getOrder (UUID uuid )
    {
        return orderRepository.findOrderById(uuid.toString() ).get();
    }

    public Order changeOrderStatus( UUID uuid , OrderStatus status )
    {
        Order order = orderRepository.findById(uuid).get() ;
        order.setOrderStatus(status);
        return  orderRepository.save(order) ;
    }
}
