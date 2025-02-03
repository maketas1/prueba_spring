package org.example.prueba_spring.crudBasico.Controlador;

import jakarta.validation.Valid;
import org.example.prueba_spring.crudBasico.Modelo.Prestamo;
import org.example.prueba_spring.crudBasico.Servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@CacheConfig(cacheNames = {"prestamos"})
public class ControladorPrestamo {
    @Autowired
    private PrestamoServicio servicio;

    @GetMapping
    public ResponseEntity<List<Prestamo>> getPrestamos() {
        List<Prestamo> prestamos = servicio.obtener();

        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable(name = "id") Integer id) {
        try{
            Thread.sleep(3000);
            Prestamo prestamo = servicio.obtenerUno(id);
            return new ResponseEntity<>(prestamo,HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<Prestamo> addPrestamo(@Valid @RequestBody Prestamo prestamo) {
        servicio.insertar(prestamo);
        return new ResponseEntity<>(prestamo,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updatePrestamo(@Valid @RequestBody Prestamo prestamo) {
        servicio.actualizar(prestamo);
        return new ResponseEntity<>(prestamo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable(name = "id") Integer id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
