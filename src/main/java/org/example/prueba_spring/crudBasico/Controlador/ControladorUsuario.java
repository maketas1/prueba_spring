package org.example.prueba_spring.crudBasico.Controlador;

import jakarta.validation.Valid;
import org.example.prueba_spring.crudBasico.Modelo.Usuario;
import org.example.prueba_spring.crudBasico.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CacheConfig(cacheNames = {"usuarios"})
public class ControladorUsuario {
    @Autowired
    private UsuarioServicio servicio;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        List<Usuario> usuarios = servicio.obtener();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(name = "id") Integer id) {
        try{
            Thread.sleep(3000);
            Usuario prestamo = servicio.obtenerUno(id);
            return new ResponseEntity<>(prestamo,HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario prestamo) {
        servicio.insertar(prestamo);
        return new ResponseEntity<>(prestamo,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody Usuario prestamo) {
        servicio.actualizar(prestamo);
        return new ResponseEntity<>(prestamo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(name = "id") Integer id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
