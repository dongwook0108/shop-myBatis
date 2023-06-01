package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.form.common.PageDto;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import dongwook.shoppingpractice.mapper.ProductMapper;
import dongwook.shoppingpractice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.util.StringUtils;

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

    public List<Product> getProductList(PageDto pageDto) {
        int page = pageDto.getPage();
        int size = pageDto.getSize();
        String name = pageDto.getName();

        int count;
        List<Product> productList;
        PaginationVo paginationVo;

        if (StringUtils.hasText(name)) {
            count = getCountByName(name);
            paginationVo = new PaginationVo(count, page, size);
            productList = getListPageByName(paginationVo, name);
        } else {
            count = getCount();
            paginationVo = new PaginationVo(count, page, size);
            productList = getListPage(paginationVo);
        }

        return productList;
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