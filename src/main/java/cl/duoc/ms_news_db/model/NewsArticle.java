package cl.duoc.ms_news_db.model;

import jakarta.persistence.*;

@Entity
@Table(name = "news")
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String source;
    @Column(length = 2000)
    private String content;
    private String url;

    public NewsArticle() {}

    public NewsArticle(Long id, String title, String source, String content, String url) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.content = content;
        this.url = url;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
