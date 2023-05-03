package dongwook.shoppingpractice.admin.product.form;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductForm {

    private String name;

    private String simpleDescription;

    private String description;

    private Integer price;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updateBy;

    private String createdBy;


}
