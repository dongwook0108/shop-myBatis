package dongwook.shoppingpractice.form.product;

import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.member.Member;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditForm {

    private Long id;

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    private LocalDateTime updatedDate;

    private String updatedBy;

//    public ProductEditForm(Product product) {
//        this.id = product.getId();
//        this.name = product.getName();
//        this.simpleDescription = product.getSimpleDescription();
//        this.description = product.getDescription();
//        this.price = product.getPrice();
//        this.updatedDate = LocalDateTime.now();
//    }


    public void setUpdatedDateAndBy(Member member) {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = member.getUsername();
    }

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
