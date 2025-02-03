package org.example.prueba_spring.crudBasico.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull(message = "El campo dni no puede ser null")
    @NotBlank(message = "El campo dni no puede estar vacio")
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Size(max = 100)
    @NotNull(message = "El campo nombre no puede ser null")
    @NotBlank(message = "El campo nombre no puede estar vacio")
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "[A-Za-z0-9]{1,100}", message = "El campo nombre debe contener entre 1 y 100 caracteres alfanumericos")
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "El campo email no puede ser null")
    @NotBlank(message = "El campo email no puede estar vacio")
    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "[A-Za-z0-9]{1,100}@gmail.com", message = "El campo email debe contener entre 1 y 100 caracteres alfanumericos y termnar en @gmail.com")
    private String email;

    @Size(max = 255)
    @NotNull(message = "El campo password no puede ser null")
    @NotBlank(message = "El campo password no puede estar vacio")
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "[A-Za-z0-9]{4,12}", message = "El campo password debe contener entre 4 y 12 caracteres alfanumericos")
    private String password;

    @NotNull(message = "El campo tipo no puede ser null")
    @NotBlank(message = "El campo tipo no puede estar vacio")
    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(Normal|Administrador)$", message = "El campo tipo solo tiene como permitido los valores de Normal o Administrador")
    private String tipo;

    @Column(name = "penalizacion_hasta")
    private LocalDate penalizacion_hasta;

}