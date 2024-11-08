package com.upc.pizzaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaResponseDTO {
    Long id;
    String nombre;
    Double precio;
}
