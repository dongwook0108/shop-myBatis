package dongwook.shoppingpractice.admin.product.controller;

import dongwook.shoppingpractice.admin.product.form.ProductEditForm;
import dongwook.shoppingpractice.admin.product.form.ProductForm;
import dongwook.shoppingpractice.admin.product.model.Product;
import dongwook.shoppingpractice.admin.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

    @GetMapping()
    public String productPage(Model model) {
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "admin/products";
    }

    @GetMapping("/add")
    public String addProductPage(Model model) {
        model.addAttribute(new ProductForm());
        return "admin/add-product";
    }

    @PostMapping("/add")
    public String addProduct(ProductForm form) {
        productService.save(form);
        return "redirect:/admin/products";
    }

    @GetMapping("/{productId}")
    public String product(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "admin/edit-products";
    }


    @GetMapping("/{productId}/edit")
    public String productEditPage(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute(product);
        model.addAttribute(new ProductEditForm());
        return "admin/edit-product";
    }

    @PostMapping("/{productId}/edit")
    public String productEdit(@PathVariable Long productId, ProductEditForm editForm) {

        Product product = productService.findById(productId);
        System.out.println("product = " + product);

        productService.updateProduct(product, editForm);
        System.out.println("editForm = " + editForm);

        return "redirect:/admin/products/{productId}";
    }
}
