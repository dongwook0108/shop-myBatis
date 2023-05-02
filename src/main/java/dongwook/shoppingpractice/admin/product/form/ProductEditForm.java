package dongwook.shoppingpractice.admin.product.form;

import dongwook.shoppingpractice.admin.product.model.Product;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditForm {

    private String name;

    private String simpleDescription;

    private String description;

    private int price;

    private LocalDateTime updatedDate;

    private LocalDateTime createdDate;


    public ProductEditForm(Product product) {
        this.name = product.getName();
        this.simpleDescription = product.getSimpleDescription();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.updatedDate = product.getUpdatedDate();
        this.createdDate = product.getCreatedDate();

    }
}
