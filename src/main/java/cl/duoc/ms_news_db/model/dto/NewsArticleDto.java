
package cl.duoc.ms_news_db.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsArticleDto {
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private String autor;
    private String fechaPublicacion;
    private Boolean esPublicado;
    private String imagenUri;
}
