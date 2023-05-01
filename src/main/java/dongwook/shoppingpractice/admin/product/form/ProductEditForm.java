package dongwook.shoppingpractice.admin.product.form;

import dongwook.shoppingpractice.admin.product.model.Product;
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

    private int stock;

    public ProductEditForm(Product product) {
        this.name = product.getName();
        this.simpleDescription = product.getSimpleDescription();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
