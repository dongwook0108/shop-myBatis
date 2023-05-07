package dongwook.shoppingpractice.product.form;

import dongwook.shoppingpractice.product.model.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditForm {

    private Long id;

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    private LocalDateTime updatedDate;

    public ProductEditForm(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.simpleDescription = product.getSimpleDescription();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.updatedDate = LocalDateTime.now();
    }

}
