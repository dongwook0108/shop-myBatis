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

    @GetMapping
    public String categoryPage(Model model) {
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categoryList", categories);

        return "admin/category";
    }

    @GetMapping("/upload")
    public String categoryAddPage(Model model) {
        List<Category> parentCategories = categoryService.findAllParentCategories();

        model.addAttribute("parentCategory", parentCategories);
//        model.addAttribute(new CategoryForm()); --> 여기부분을 없애줌 기존에는 하나로 쓱 들어왓다가 post 요청까지 해줬는데 지금 뭔가 큰 문제가 생길 거 같음

        return "admin/add-category";
    }

    @PostMapping("/upload")
    public String categoryAdd(CategoryForm categoryForm) {
        categoryService.save(categoryForm);

        return "redirect:/admin/category";
    }

    @GetMapping("/{id}")
    public String category(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);

        List<Category> parentCategory = categoryService.findAllParentCategories();
        model.addAttribute("parentCategory", parentCategory);

        return "admin/edit-category";
    }

    // TODO: 아이디 빠져도 될 것 같습니다.
    @PostMapping("/{id}")
    public String categoryEdit(@PathVariable Long id, CategoryEditForm form) {
        categoryService.updateCategory(form);

        return "redirect:/admin/category/" + id;
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<>

}
