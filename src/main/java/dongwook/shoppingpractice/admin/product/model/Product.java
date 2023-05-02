package dongwook.shoppingpractice.admin.product.model;

import dongwook.shoppingpractice.admin.product.form.ProductForm;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private String simpleDescription;
    private int price;

    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    private String updateBy;

    private String createdBy;

    public Product(ProductForm form) {
        this.name = form.getName();
        this.simpleDescription = form.getSimpleDescription();
        this.description = form.getDescription();
        this.price = form.getPrice();
        this.createdDate = LocalDateTime.now();
    }

    public void updateProductName(String name) {
        this.name = name;
    }

}
