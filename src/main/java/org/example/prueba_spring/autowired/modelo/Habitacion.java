package org.example.prueba_spring.autowired.modelo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Habitacion {
    private int id = 1;
    private String nombre = "Dormitorio";

    @Autowired
    private Mueble mueble;

    @Autowired
    private Puerta puerta;

    @Autowired
    private Ventana ventana;
}
