package linhVu.model;

import javax.persistence.*;

@Entity
@Table(name="blogs")
public class BlogRESTful {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String content;
    private String dateCreate;
    private String categoryName;

    public BlogRESTful() {
    }

    public BlogRESTful(Long id,String title, String description, String content, String dateCreate, String categoryName) {
        this.id= id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.categoryName = categoryName;
    }

    public BlogRESTful(String title, String description, String content, String dateCreate, String categoryName) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
