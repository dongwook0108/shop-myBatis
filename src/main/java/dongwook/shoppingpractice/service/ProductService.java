package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import dongwook.shoppingpractice.mapper.ProductMapper;
import dongwook.shoppingpractice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void save(ProductForm form) {
        if (form.isUnderZeroPrice()) {
            throw new IllegalArgumentException("가격은 0원 초과이어야 합니다.");
        }

        if (form.validateRequiredValue()) {
            throw new IllegalArgumentException("제품 설명 부분은 비어있을 수 없습니다.");
        }

        ProductForm productForm = ProductForm.builder()
                .name(form.getName())
                .simpleDescription(form.getSimpleDescription())
                .description(form.getDescription())
                .price(form.getPrice())
                .originalFileName(form.getOriginalFileName())
                .featured(form.isFeatured())
                .categoryId(form.getCategoryId())
                .build();

        productMapper.save(productForm);
    }

    public List<Product> findAllProducts() {
        return productMapper.productList();
    }

    public Product findById(Long productId) {
        return productMapper.findById(productId);
    }

    public void updateProduct(Long productId, ProductEditForm editForm) {
        ProductEditForm productEditForm = ProductEditForm.builder()
                .id(productId)
                .name(editForm.getName())
                .simpleDescription(editForm.getSimpleDescription())
                .description(editForm.getDescription())
                .price(editForm.getPrice())
                .build();

        productMapper.updateProduct(productEditForm);
    }

    public int getCount() {
        return this.productMapper.getCount();
    }

    public List<Product> getListPage(final PaginationVo paginationVo) {
        return productMapper.getListPage(paginationVo);
    }

    public List<Product> getListPageByName(final PaginationVo paginationVo, String name) {
        return productMapper.getListPageByName(paginationVo, name);
    }

    public int getCountByName(String name) {
        return productMapper.getCountByName(name);
    }

    public List<Product> featuredProductList() {
        return productMapper.featuredProductList();
    }
}