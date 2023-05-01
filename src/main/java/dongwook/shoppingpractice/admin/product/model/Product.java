package dongwook.shoppingpractice.admin.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private Long productId;
    private String name;
    private String description;
    private String simpleDescription;
    private int price;
    private int stock;

    public void updateProductName(String name) {
        this.name = name;
    }

//    private LocalDateTime expireDate;
//    private LocalDateTime registerAt;
}
