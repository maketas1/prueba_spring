package org.example.prueba_spring.crudBasico.Servicio;

import org.example.prueba_spring.crudBasico.Modelo.Ejemplar;
import org.example.prueba_spring.crudBasico.Repositorio.IEjemplarRepositorio;
import org.example.prueba_spring.crudBasico.Repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjemplarServicio extends CRUD<Ejemplar, Integer> implements IEjemplarServicio{

    @Autowired
    private IEjemplarRepositorio repo;

    @Override
    protected IGenericoRepositorio<Ejemplar, Integer> getRepo() {
        return repo;
    }
}
