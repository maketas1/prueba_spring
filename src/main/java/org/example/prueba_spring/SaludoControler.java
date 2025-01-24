package org.example.prueba_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoControler {
    @GetMapping("/saludo")
    public String saludoBasico() {
        return "Hola, que hay?";
    }
}
