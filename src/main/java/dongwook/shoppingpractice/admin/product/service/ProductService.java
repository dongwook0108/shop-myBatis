package dongwook.shoppingpractice.admin.product.service;

import dongwook.shoppingpractice.admin.product.form.ProductEditForm;
import dongwook.shoppingpractice.admin.product.form.ProductForm;
import dongwook.shoppingpractice.admin.product.mapper.ProductMapper;
import dongwook.shoppingpractice.admin.product.model.Product;
import dongwook.shoppingpractice.domain.member.form.userpaging.PaginationVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void save(ProductForm form) {
        Product product = new Product(form);
        productMapper.save(product);
    }

    public List<Product> productList() {
        return productMapper.productList();
    }

    public Product findById(Long productId) {
        return productMapper.findById(productId);
    }


    public void updateProduct(Product product, ProductEditForm editForm) {
//        Product product = new Product(editForm);
        product.updateName(editForm.getName());
        product.updatePrice(editForm.getPrice());
        product.updateSimpleDescription(editForm.getSimpleDescription());
        product.updateDescription(editForm.getDescription());

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