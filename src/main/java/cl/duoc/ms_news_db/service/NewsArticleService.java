package cl.duoc.ms_news_db.service;

import cl.duoc.ms_news_db.model.NewsArticle;
import cl.duoc.ms_news_db.repository.NewsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsArticleService {
    @Autowired
    private NewsArticleRepository newsArticleRepository;

    public List<NewsArticle> getAll() {
        return newsArticleRepository.findAll();
    }

    public Optional<NewsArticle> getById(Long id) {
        return newsArticleRepository.findById(id);
    }

    public NewsArticle save(NewsArticle article) {
        return newsArticleRepository.save(article);
    }

    public void delete(Long id) {
        newsArticleRepository.deleteById(id);
    }
}
