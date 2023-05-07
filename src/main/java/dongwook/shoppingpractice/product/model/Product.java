package dongwook.shoppingpractice.product.model;

import dongwook.shoppingpractice.product.form.ProductEditForm;
import dongwook.shoppingpractice.product.form.ProductForm;
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

    public Product(ProductEditForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.description = form.getDescription();
        this.simpleDescription = form.getSimpleDescription();
        this.price = form.getPrice();
        this.updatedDate = LocalDateTime.now();
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePrice(BigDecimal price) {
        this.price = price;
    }

    public void updateSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

}
