package com.upc.pizzaapi.service;

import com.upc.pizzaapi.repository.PizzaRepository;
import com.upc.pizzaapi.dto.PizzaRequestDTO;
import com.upc.pizzaapi.dto.PizzaResponseDTO;
import com.upc.pizzaapi.model.Pizza;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    final PizzaRepository pizzaRepository;
    ModelMapper modelMapper = new ModelMapper();

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    public List<PizzaResponseDTO> getPizzas() {
        return pizzaRepository.findAll().stream()
                .map(pizza -> modelMapper.map(pizza, PizzaResponseDTO.class))
                .collect(Collectors.toList());
    }

    public PizzaResponseDTO getPizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza no encontrada"));
        return modelMapper.map(pizza, PizzaResponseDTO.class);
    }

    public PizzaResponseDTO addPizza(PizzaRequestDTO pizzaRequestDTO) {
        Pizza pizza = modelMapper.map(pizzaRequestDTO, Pizza.class);
        pizza = pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaResponseDTO.class);
    }

    public PizzaResponseDTO updatePizza(Long id, PizzaRequestDTO pizzaRequestDTO) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza no encontrada"));
        pizza.setNombre(pizzaRequestDTO.getNombre());
        pizza.setPrecio(pizzaRequestDTO.getPrecio());
        pizza = pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaResponseDTO.class);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
