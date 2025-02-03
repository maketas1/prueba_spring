package org.example.prueba_spring.crudBasico.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    @NotBlank(message = "el campo isbn no puede estar en blanco")
    @Pattern(regexp = "\\d{3}-\\d-\\d{3}-\\d{5}-\\d", message = "el campo debe ser de la siguiente forma 000-0-000-00000-0")
    private String isbn;

    @Size(max = 200)
    @NotNull(message = "el campo titulo no puede ser null")
    @Column(name = "titulo", nullable = false, length = 200)
    @NotBlank(message = "el campo titulo no puede estar en blanco")
    @Pattern(regexp = "[a-zA-Z\s]{1,200}", message = "el campo titulo debe tener entre 1 y 200 caracteres")
    private String titulo;

    @Size(max = 100)
    @NotNull(message = "el campo autor no puede ser null")
    @Column(name = "autor", nullable = false, length = 100)
    @NotBlank(message = "el campo autor no puede estar en blanco")
    @Pattern(regexp = "[a-zA-Z\s]{1,100}", message = "el campo autor debe tener entre 1 y 100 caracteres")
    private String autor;

}