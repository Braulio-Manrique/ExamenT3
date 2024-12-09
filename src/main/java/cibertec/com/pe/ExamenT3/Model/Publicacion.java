package cibertec.com.pe.ExamenT3.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private LocalDate fechpublicacion;
    @ManyToOne
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor autor;
}
