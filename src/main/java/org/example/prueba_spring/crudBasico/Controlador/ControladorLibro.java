package org.example.prueba_spring.crudBasico.Controlador;

import jakarta.validation.Valid;
import org.example.prueba_spring.crudBasico.Modelo.Libro;
import org.example.prueba_spring.crudBasico.Servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class ControladorLibro {
    @Autowired
    private LibroServicio servicio;

    @GetMapping
    public ResponseEntity<List<Libro>> getLibros() {
        List<Libro> libros = servicio.obtener();

        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> getLibroById(@PathVariable(name = "isbn") String isbn) {
        Libro libro = servicio.obtenerUno(isbn);
        return new ResponseEntity<>(libro,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Libro> addLibro(@Valid @RequestBody Libro libro) {
        servicio.insertar(libro);
        return new ResponseEntity<>(libro,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Libro> updateLibro(@Valid @RequestBody Libro libro) {
        servicio.actualizar(libro);
        return new ResponseEntity<>(libro,HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLibro(@PathVariable(name = "isbn") String isbn) {
        servicio.eliminar(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
