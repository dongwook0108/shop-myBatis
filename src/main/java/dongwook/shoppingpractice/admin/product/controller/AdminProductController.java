package dongwook.shoppingpractice.admin.product.controller;

import dongwook.shoppingpractice.admin.product.form.ProductEditForm;
import dongwook.shoppingpractice.admin.product.form.ProductForm;
import dongwook.shoppingpractice.admin.product.model.Product;
import dongwook.shoppingpractice.admin.product.service.ProductService;
import dongwook.shoppingpractice.domain.member.form.userpaging.PaginationVo;
import dongwook.shoppingpractice.domain.member.model.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

//    @GetMapping()
//    public String productPage(Model model) {
//        List<Product> productList = productService.productList();
//        model.addAttribute("productList", productList);
//        return "admin/products";
//    }

//    @GetMapping()
//    public String productPage(Model model,
//            @RequestParam(value = "page", defaultValue = "1") int page,
//            @RequestParam(value = "size", defaultValue = "5") int size) {
//
//        PaginationVo paginationVo;
//        int count;
//        List<Product> productList;
//
//
//        count = productService.getCount();
//        paginationVo = new PaginationVo(count, page, size); // 모든 게시글 개수 구하기.
//        productList = productService.getListPage(paginationVo);
//
//        model.addAttribute("products", productList);
//        model.addAttribute("pageVo", paginationVo);
//        return "admin/products";
//    }

    @GetMapping()
    public String selectListAndPage(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "name", required = false) String name) {
        List<Product> products;

        PaginationVo paginationVo;
        int count;
        if (StringUtils.hasText(name)) {
            count = productService.getCountByName(name);
            paginationVo = new PaginationVo(count, page, size);
            products = productService.getListPageByName(paginationVo, name);
        } else {
            count = productService.getCount();
            paginationVo = new PaginationVo(count, page, size); // 모든 게시글 개수 구하기.
            products = productService.getListPage(paginationVo);
        }

        model.addAttribute("products", products);
        model.addAttribute("pageVo", paginationVo);

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
