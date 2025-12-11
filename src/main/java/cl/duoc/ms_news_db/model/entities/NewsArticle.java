package cl.duoc.ms_news_db.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    @Column(length = 2000)
    private String contenido;
    private String autor;
    private String fechaPublicacion;
    private Boolean esPublicado;
    private String imagenUri;
}
