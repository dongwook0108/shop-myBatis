package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.common.PageDto;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.Upload;
import dongwook.shoppingpractice.service.CategoryService;
import dongwook.shoppingpractice.service.ProductService;
import dongwook.shoppingpractice.service.UploadService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;
    private final UploadService uploadService;
    private final CategoryService categoryService;

    // TODO: PageDTO 만들어서 사이즈랑 페이지 값 받기
    @GetMapping
    public String selectListAndPage(Model model, @ModelAttribute PageDto pageDto) {

        pageDto.setTotalCount(productService.getCount());

        List<Product> productList = productService.getProductList(pageDto);
        PaginationVo paginationVo = new PaginationVo(pageDto.getTotalCount(), pageDto.getPage(),
                pageDto.getSize());

        model.addAttribute("products", productList);
        model.addAttribute("pageVo", paginationVo);

        return "admin/products";
    }


    @GetMapping("/add")
    public String addProductPage(Model model) {

        List<Upload> fileNameList = uploadService.findAllFileName();
        model.addAttribute("fileNameList", fileNameList);

        List<Category> categoryList = categoryService.findChildCategory();
        model.addAttribute("categoryList", categoryList);
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

    @PostMapping("/{productId}")
    public String productEdit(@PathVariable Long productId, ProductEditForm editForm) {
        productService.updateProduct(productId, editForm);
        return "redirect:/admin/products/{productId}";
    }
}
