package dongwook.shoppingpractice.form.product;

import dongwook.shoppingpractice.common.BaseEntityForm;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductEditForm extends BaseEntityForm {

    private Long id;

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    @Builder
    public ProductEditForm(Long id, String name, String simpleDescription, String description,
            BigDecimal price) {
        this.id = id;
        this.name = name;
        this.simpleDescription = simpleDescription;
        this.description = description;
        this.price = price;
    }
}
