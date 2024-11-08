package com.upc.pizzaapi.controller;

import com.upc.pizzaapi.service.PizzaService;
import com.upc.pizzaapi.dto.PizzaRequestDTO;
import com.upc.pizzaapi.dto.PizzaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // (origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    @GetMapping
    public ResponseEntity<List<PizzaResponseDTO>> getAllPizzas() {
        return ResponseEntity.ok(this.pizzaService.getPizzas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PizzaResponseDTO> getPizza(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.pizzaService.getPizza(id));
    }
    @PostMapping
    public ResponseEntity<PizzaResponseDTO> addPizza(@RequestBody PizzaRequestDTO pizzaRequestDTO) {
        return new ResponseEntity<>(this.pizzaService.addPizza(pizzaRequestDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PizzaResponseDTO> updatePizza(@PathVariable("id") Long id, @RequestBody PizzaRequestDTO pizzaRequestDTO) {
        return ResponseEntity.ok(this.pizzaService.updatePizza(id, pizzaRequestDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable("id") Long id) {
        this.pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }

}
