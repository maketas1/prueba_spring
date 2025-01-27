package org.example.prueba_spring.autowired.controlador;

import org.example.prueba_spring.Coche;
import org.example.prueba_spring.autowired.modelo.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class ControladorCasa {

    @Autowired
    private Casa casa;

    @GetMapping
    public ResponseEntity<Casa> obtenerCoche() {
        return ResponseEntity.ok(casa);
    }
}
