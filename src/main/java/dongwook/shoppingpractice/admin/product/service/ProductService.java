package dongwook.shoppingpractice.admin.product.service;

import dongwook.shoppingpractice.admin.product.form.ProductEditForm;
import dongwook.shoppingpractice.admin.product.form.ProductForm;
import dongwook.shoppingpractice.admin.product.mapper.ProductMapper;
import dongwook.shoppingpractice.admin.product.model.Product;
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
}