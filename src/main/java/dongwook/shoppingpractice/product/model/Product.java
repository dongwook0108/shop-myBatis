package dongwook.shoppingpractice.product.model;

import dongwook.shoppingpractice.dto.product.ProductEditForm;
import dongwook.shoppingpractice.dto.product.ProductForm;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Long id;
    private String name;
    private String description;
    private String simpleDescription;
    private BigDecimal price;

    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    private String updateBy;

    private String createdBy;

    public Product(ProductForm form) {
        this.name = form.getName();
        this.description = form.getDescription();
        this.simpleDescription = form.getSimpleDescription();
        this.price = form.getPrice();
        this.createdDate = LocalDateTime.now();
    }

    public void updateProduct(ProductEditForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
        this.simpleDescription = form.getSimpleDescription();
        this.description = form.getDescription();
        this.updatedDate = LocalDateTime.now();
    }
}
