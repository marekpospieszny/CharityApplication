package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void add(Category category);

    Category get(Long id);

    void delete(Long id);

    void update(Category category);

}
