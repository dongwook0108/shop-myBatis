package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.category.CategoryEditForm;
import dongwook.shoppingpractice.form.category.CategoryForm;
import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public String categoryPage(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "admin/category";
    }

    @GetMapping("/upload")
    public String categoryAddPage(Model model) {
        List<Category> parentCategory = categoryService.findParentCategory();

        model.addAttribute("parentCategory", parentCategory);
        model.addAttribute(new CategoryForm());

        return "admin/add-category";
    }

    @PostMapping("/upload")
    public String categoryAdd(CategoryForm form) {
        Category category = new Category(form);

        form.setName(category.getName());
        form.setCategoryCode(category.getCategoryCode());
        form.setParentId(category.getParentId());

        categoryService.save(form);

        return "redirect:/admin/category";
    }

    @GetMapping("/{id}")
    public String category(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);

        List<Category> parentCategory = categoryService.findParentCategory();
        model.addAttribute("parentCategory", parentCategory);
        return "admin/edit-category";
    }

    @PostMapping("/{id}")
    public String categoryEdit(@PathVariable Long id, CategoryEditForm form) {

        CategoryEditForm categoryEditForm = CategoryEditForm.editForm(form, id);
        categoryService.updateCategory(categoryEditForm);

        return "redirect:/admin/category/" + id;
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<>

}
