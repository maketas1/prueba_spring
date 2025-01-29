package org.example.prueba_spring.crudBasico.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//Interfaz generica para crud
@NoRepositoryBean
public interface IGenericoRepositorio<T,ID> extends JpaRepository<T,ID> {
}
