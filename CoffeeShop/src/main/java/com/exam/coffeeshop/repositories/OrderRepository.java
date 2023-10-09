package com.exam.coffeeshop.repositories;

import com.exam.coffeeshop.models.entities.Order;
import jakarta.persistence.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o from Order o " +
            "order by o.price desc ")
    List<Order> findAll();
}
