package org.example.prueba_spring.crudBasico.Servicio;

import org.example.prueba_spring.crudBasico.Modelo.Libro;
import org.example.prueba_spring.crudBasico.Repositorio.IGenericoRepositorio;
import org.example.prueba_spring.crudBasico.Repositorio.ILibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio extends CRUD<Libro, String> implements ILibroServicio{
    @Autowired
    private ILibroRepositorio repo;

    @Override
    protected IGenericoRepositorio<Libro, String> getRepo() {
        return repo;
    }
}
