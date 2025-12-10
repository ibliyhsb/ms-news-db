package cl.duoc.ms_news_db.controller;

import cl.duoc.ms_news_db.model.NewsArticle;
import cl.duoc.ms_news_db.service.NewsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsArticleController {
    @Autowired
    private NewsArticleService newsArticleService;

    @GetMapping
    public List<NewsArticle> getAll() {
        return newsArticleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsArticle> getById(@PathVariable Long id) {
        return newsArticleService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NewsArticle create(@RequestBody NewsArticle article) {
        return newsArticleService.save(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsArticle> update(@PathVariable Long id, @RequestBody NewsArticle article) {
        return newsArticleService.getById(id)
                .map(existing -> {
                    article.setId(id);
                    return ResponseEntity.ok(newsArticleService.save(article));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (newsArticleService.getById(id).isPresent()) {
            newsArticleService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
