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

    public List<Category> findAllCategories() {
        return categoryMapper.findAllCategories();
    }

    public List<Category> findAllParentCategories() {
        return categoryMapper.findParentCategories();
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

        // TODO: 방법 맞춰서 바꾸기
        CategoryEditForm categoryEditForm = CategoryEditForm.builder()
                .id(form.getId())
                .name(form.getName())
                .categoryCode(form.getCategoryCode())
                .parentId(form.getParentId())
                .build();

        categoryMapper.update(categoryEditForm);
    }
}
