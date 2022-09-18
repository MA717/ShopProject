package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

@Query(value = "select * from tbl_order s where s.order_id = ?1" , nativeQuery = true)
Optional<Order> findOrderById(String uuid);
}
