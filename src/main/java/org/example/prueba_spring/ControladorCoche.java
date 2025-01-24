package org.example.prueba_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coches")
public class ControladorCoche {
    @GetMapping("/coche")
    public ResponseEntity<Coche> obtenerCoche() {
        Coche c = new Coche("utilitario", "azul", "gasolina", 120, 100, "ford");
        return ResponseEntity.ok(c);
    }

    @PostMapping("/coche")
    public ResponseEntity<Coche> ejemploPostCoche(@RequestBody Coche c) {
        System.out.println("Por consola: " + c);
        return ResponseEntity.ok(c);
    }
}
