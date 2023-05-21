package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.form.category.CategoryEditForm;
import dongwook.shoppingpractice.form.category.CategoryForm;
import dongwook.shoppingpractice.mapper.CategoryMapper;
import dongwook.shoppingpractice.model.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public List<Category> findParentCategory() {
        return categoryMapper.findParentCategory();
    }

    public void save(CategoryForm form) {
        Category category = new Category(form);
        categoryMapper.save(category);
    }

    public List<Category> findChildCategory() {
        return categoryMapper.findChildCategory();
    }

    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }

    public void updateCategory(CategoryEditForm form) {
        categoryMapper.update(form);
    }
}
