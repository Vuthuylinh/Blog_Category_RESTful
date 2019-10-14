package linhVu.service.impl;

import linhVu.model.BlogRESTful;
import linhVu.repository.BlogRepository;
import linhVu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<BlogRESTful> findAll() {
        return (List<BlogRESTful>) blogRepository.findAll();
    }

    @Override
    public BlogRESTful findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(BlogRESTful blogRESTful) {
    blogRepository.save(blogRESTful);
    }

    @Override
    public void remove(Long id) {
    blogRepository.delete(id);
    }
}
