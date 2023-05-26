package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.CategoryService;
import dongwook.shoppingpractice.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String index(@CurrentMember Member member, Model model) {
        if (member != null) {
            model.addAttribute(member);
        }

        List<Product> featuredProductList = productService.featuredProductList();
        List<Category> categoryList = categoryService.findAllParentCategories();
        model.addAttribute("featuredProductList", featuredProductList);
        model.addAttribute("categoryList", categoryList);

        return "index";
    }

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception,
            Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "sign-in";
    }

}