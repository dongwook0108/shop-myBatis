package dongwook.shoppingpractice.admin.product.form;

import lombok.Data;

@Data
public class ProductForm {

    private String productId;

    private String name;

    private String simpleDescription;

    private String description;

    private int price;

    private int stock;

//    private LocalDateTime expireDate;

//    private LocalDateTime registerAt;


}
