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
                entity.getTitle(),
                entity.getSource(),
                entity.getContent(),
                entity.getUrl()
        );
    }

    private NewsArticle toEntity(NewsArticleDto dto) {
        NewsArticle entity = new NewsArticle();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setSource(dto.getSource());
        entity.setContent(dto.getContent());
        entity.setUrl(dto.getUrl());
        return entity;
    }
}
