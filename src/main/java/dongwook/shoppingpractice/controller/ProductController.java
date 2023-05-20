package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.service.CategoryService;
import dongwook.shoppingpractice.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/product")
    public String products(Model model) {
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);

        List<Category> categoryList = categoryService.findParentCategory();
        model.addAttribute("categoryList", categoryList);
        return "product/products";
    }

    @GetMapping("/product/{id}")
    public String productsDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/product-detail";
    }

    @PostMapping("/product/{id}")
    public String order(@PathVariable Long id) {
        return null;
    }
}
