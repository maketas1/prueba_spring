package org.example.prueba_spring.crudBasico.Servicio;

import org.example.prueba_spring.crudBasico.Modelo.Usuario;
import org.example.prueba_spring.crudBasico.Repositorio.IGenericoRepositorio;
import org.example.prueba_spring.crudBasico.Repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio extends CRUD<Usuario, Integer> implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repo;

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return repo;
    }
}
