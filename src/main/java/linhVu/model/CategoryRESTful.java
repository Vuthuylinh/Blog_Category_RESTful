package linhVu.model;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class CategoryRESTful {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public CategoryRESTful() {
    }

    public CategoryRESTful(String name) {
        this.name = name;
    }

    public CategoryRESTful(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
