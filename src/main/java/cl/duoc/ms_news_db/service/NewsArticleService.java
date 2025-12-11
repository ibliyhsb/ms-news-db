package cl.duoc.ms_news_db.service;

import cl.duoc.ms_news_db.model.entities.NewsArticle;
import cl.duoc.ms_news_db.model.dto.NewsArticleDto;
import cl.duoc.ms_news_db.repository.NewsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsArticleService {
    @Autowired
    private NewsArticleRepository newsArticleRepository;

    public List<NewsArticleDto> getAll() {
        return newsArticleRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<NewsArticleDto> getById(Long id) {
        return newsArticleRepository.findById(id).map(this::toDto);
    }

    public NewsArticleDto save(NewsArticleDto dto) {
        NewsArticle entity = toEntity(dto);
        NewsArticle saved = newsArticleRepository.save(entity);
        return toDto(saved);
    }

    public void delete(Long id) {
        newsArticleRepository.deleteById(id);
    }

    private NewsArticleDto toDto(NewsArticle entity) {
        return new NewsArticleDto(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescripcion(),
                entity.getContenido(),
                entity.getAutor(),
                entity.getFechaPublicacion(),
                entity.getEsPublicado(),
                entity.getImagenUri()
        );
    }

    private NewsArticle toEntity(NewsArticleDto dto) {
        NewsArticle entity = new NewsArticle();
        entity.setId(dto.getId());
        entity.setTitulo(dto.getTitulo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setContenido(dto.getContenido());
        entity.setAutor(dto.getAutor());
        entity.setFechaPublicacion(dto.getFechaPublicacion());
        entity.setEsPublicado(dto.getEsPublicado());
        entity.setImagenUri(dto.getImagenUri());
        return entity;
    }
}
