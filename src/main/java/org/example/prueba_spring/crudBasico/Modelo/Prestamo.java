package org.example.prueba_spring.crudBasico.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "El campo usuario no puede ser null")
    @Column(name = "usuario_id", nullable = false)
    private Integer usuario_id;

    @NotNull(message = "El campo ejemplar no puede ser null")
    @Column(name = "ejemplar_id", nullable = false)
    private Integer ejemplar_id;

    @NotNull(message = "El campo fechaInicio no puede ser null")
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

}