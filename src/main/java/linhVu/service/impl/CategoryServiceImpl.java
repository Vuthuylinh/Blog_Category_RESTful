package linhVu.service.impl;

import linhVu.model.BlogRESTful;
import linhVu.model.CategoryRESTful;
import linhVu.repository.CategoryRepository;
import linhVu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryRESTful> findAll() {
        return (List<CategoryRESTful>) categoryRepository.findAll();
    }

    @Override
    public CategoryRESTful findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(CategoryRESTful categoryRESTful) {
    categoryRepository.save(categoryRESTful);
    }

    @Override
    public void remove(Long id) {
    categoryRepository.delete(id);
    }


}
