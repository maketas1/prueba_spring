package org.example.prueba_spring.autowired.modelo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Puerta {
    private int id = 1;

    @Autowired
    private Picaporte picaporte;

    @Autowired
    private Marco marco;
}
