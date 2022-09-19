package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Order;
import com.example.ShopProject.Entity.OrderStatus;
import com.example.ShopProject.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class OrderController  {
    OrderService orderService;


    // customer only
    @PostMapping("/order/checkout")
    Order saveOrder(@RequestBody Order order){
       return orderService.SaveOrder(order);
    }


    // get order details ,  Employee could get this route
    @GetMapping("/order/{id}")
    Order getOrder(@PathVariable("id")UUID uuid)
    {
        return orderService.getOrder(uuid);
    }


    // only the Employee can change the Status of the Order
    // to be done by Authentication
    @PutMapping( "/order/{id}/status")
    Order changeOrderStatus(@PathVariable("id")UUID uuid, @RequestBody OrderStatus status )
    {
        return orderService.changeOrderStatus(uuid , status) ;

    }

}
