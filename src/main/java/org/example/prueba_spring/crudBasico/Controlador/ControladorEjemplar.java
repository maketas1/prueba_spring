package org.example.prueba_spring.crudBasico.Controlador;

import jakarta.validation.Valid;
import org.example.prueba_spring.crudBasico.Modelo.Ejemplar;
import org.example.prueba_spring.crudBasico.Servicio.EjemplarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejemplar")
@CacheConfig(cacheNames = {"ejemplar"})
public class ControladorEjemplar {
    @Autowired
    private EjemplarServicio servicio;

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getEjemplar() {
        List<Ejemplar> ejemplar = servicio.obtener();

        return new ResponseEntity<>(ejemplar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Ejemplar> getEjemplarById(@PathVariable(name = "id") Integer id) {
        try{
            Thread.sleep(3000);
            Ejemplar ejemplar = servicio.obtenerUno(id);
            return new ResponseEntity<>(ejemplar,HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<Ejemplar> addEjemplar(@Valid @RequestBody Ejemplar ejemplar) {
        servicio.insertar(ejemplar);
        return new ResponseEntity<>(ejemplar,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Ejemplar> updateEjemplar(@Valid @RequestBody Ejemplar ejemplar) {
        servicio.actualizar(ejemplar);
        return new ResponseEntity<>(ejemplar,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjemplar(@PathVariable(name = "id") Integer id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
