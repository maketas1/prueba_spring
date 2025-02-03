package org.example.prueba_spring.crudBasico.Servicio;

import org.example.prueba_spring.crudBasico.Modelo.Prestamo;
import org.example.prueba_spring.crudBasico.Repositorio.IGenericoRepositorio;
import org.example.prueba_spring.crudBasico.Repositorio.IPrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServicio extends CRUD<Prestamo, Integer> implements IPrestamoServicio{
    @Autowired
    private IPrestamoRepositorio repo;

    @Override
    protected IGenericoRepositorio<Prestamo, Integer> getRepo() {
        return repo;
    }
}
