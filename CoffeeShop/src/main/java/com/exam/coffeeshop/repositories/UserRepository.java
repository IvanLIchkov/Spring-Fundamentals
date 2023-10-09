package com.exam.coffeeshop.repositories;

import com.exam.coffeeshop.models.dtos.ShowAllOrdersDto;
import com.exam.coffeeshop.models.dtos.UserShowDto;
import com.exam.coffeeshop.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String value);

    @Query("select new com.exam.coffeeshop.models.dtos.UserShowDto(u, count(o) as ) from User u " +
            "join Order o on u.id = o.employee.id" +
            " group by u " +
            " order by count(o) desc ")
    List<UserShowDto> findAllOrderByNumOfOrders();
}
