package cl.duoc.ms_news_db.repository;

import cl.duoc.ms_news_db.model.entities.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
}
