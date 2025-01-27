package org.example.prueba_spring.autowired.modelo;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Ventana {
    private int id = 1;
    private int numero = 2;
}
