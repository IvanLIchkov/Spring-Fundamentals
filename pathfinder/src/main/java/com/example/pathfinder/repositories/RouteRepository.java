package com.example.pathfinder.repositories;

import com.example.pathfinder.models.entities.Route;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r from Route r Order by size(r.comments) limit 1")
    Route findMostCommented();
}
