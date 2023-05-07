package dongwook.shoppingpractice.product.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductForm {

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updateBy;

    private String createdBy;


}
