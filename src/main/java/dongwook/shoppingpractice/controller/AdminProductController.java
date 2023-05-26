package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.Upload;
import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.CategoryService;
import dongwook.shoppingpractice.service.ProductService;
import dongwook.shoppingpractice.service.UploadService;
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
    private final UploadService uploadService;

    private final CategoryService categoryService;

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

        List<Upload> fileNameList = uploadService.findAllFileName();
        model.addAttribute("fileNameList", fileNameList);

        List<Category> categoryList = categoryService.findChildCategory();
        model.addAttribute("categoryList", categoryList);
        return "admin/add-product";
    }

    @PostMapping("/add")
    public String addProduct(@CurrentMember Member member, ProductForm form) {

        form.setNameAndDate(member);
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
//        model.addAttribute(new ProductEditForm(product));
        return "admin/edit-product";
    }

    @PostMapping("/{productId}/edit")
    public String productEdit(@PathVariable Long productId, @CurrentMember Member member,
            ProductEditForm editForm) {

//        Product product = productService.findById(productId);
//        System.out.println("product = " + product);
        editForm.setUpdatedDateAndBy(member);
        productService.updateProduct(productId, editForm);
        System.out.println("editForm = " + editForm);

        return "redirect:/admin/products/{productId}";
    }
}
