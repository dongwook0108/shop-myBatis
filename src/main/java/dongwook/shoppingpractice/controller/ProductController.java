package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.product.model.Product;
import dongwook.shoppingpractice.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "product/products";
    }

    @GetMapping("/product/detail")
    public String productsDetail() {
        return "product/product-detail";
    }
}
