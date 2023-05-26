package dongwook.shoppingpractice.form.product;

import dongwook.shoppingpractice.common.BaseEntityForm;
import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.member.Member;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditForm extends BaseEntityForm {

    private Long id;

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public void setSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
