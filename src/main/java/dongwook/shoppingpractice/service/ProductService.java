package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.common.exception.ProductSaveException;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import dongwook.shoppingpractice.mapper.ProductMapper;
import dongwook.shoppingpractice.model.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void save(ProductForm form) {
        Product product = new Product(form);

        if (form.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductSaveException("가격은 0원 초과이어야 합니다.");
        }

        if (form.getSimpleDescription() == null || form.getDescription() == null) {
            throw new ProductSaveException("제품 설명 부분은 비어있을 수 없습니다.");
        }
        productMapper.save(product);
    }

    public List<Product> productList() {
        return productMapper.productList();
    }

    public Product findById(Long productId) {
        return productMapper.findById(productId);
    }


    public void updateProduct(Long productId, ProductEditForm editForm) {
        Product product = productMapper.findById(productId);
        product.updateProduct(editForm);
        productMapper.updateProduct(product);
    }

    //-----------------paging---------------
    // 페이징을 위한 전체 데이터 개수 파악
    public int getCount() {
        return this.productMapper.getCount();
    }


    // 페이징을 위한 getListPage 메소드 추가
    public List<Product> getListPage(final PaginationVo paginationVo) {
        return productMapper.getListPage(paginationVo);
    }

    public List<Product> getListPageByName(final PaginationVo paginationVo, String name) {
        return productMapper.getListPageByName(paginationVo, name);
    }

    public int getCountByName(String name) {
        return productMapper.getCountByName(name);
    }

}