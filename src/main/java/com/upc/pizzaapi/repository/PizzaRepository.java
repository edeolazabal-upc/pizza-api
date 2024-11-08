package com.upc.pizzaapi.repository;

import com.upc.pizzaapi.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
