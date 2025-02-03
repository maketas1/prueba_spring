package org.example.prueba_spring.crudBasico.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ejemplar")
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "El campo isbn no puede ser null")
    @NotBlank(message = "El campo isbn no puede estar en blanco")
    @Pattern(regexp = "\\d{3}-\\d-\\d{3}-\\d{5}-\\d", message = "el campo debe ser de la siguiente forma 000-0-000-00000-0")
    private String isbn;

    @ColumnDefault("'Disponible'")
    @Lob
    @Column(name = "estado")
    @Pattern(regexp = "^(Disponible|Prestado|Dañado)$", message = "El campo estado solo tiene como permitido los valores de Disponible, Prestado y Dañado")
    @NotNull(message = "El campo estado no puede ser null")
    @NotBlank(message = "El campo estado no puede estar en blanco")
    private String estado;
}