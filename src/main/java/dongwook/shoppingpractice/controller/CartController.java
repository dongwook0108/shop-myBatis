package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CategoryService categoryService;

    @GetMapping("/cart")
    public String cartInfo(Model model) {

        List<Category> categoryList = categoryService.findParentCategory();
        model.addAttribute("categoryList", categoryList);

        return "cart/cart";
    }
}
