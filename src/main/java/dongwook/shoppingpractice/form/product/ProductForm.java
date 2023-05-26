package dongwook.shoppingpractice.form.product;

import dongwook.shoppingpractice.model.member.Member;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    private String originalFileName;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updateBy;

    private String createdBy;

    private boolean featured;

    private Long categoryId;

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

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public boolean isUnderZeroPrice() {
        return this.price.compareTo(BigDecimal.ZERO) <= 0;
    }

    public boolean validateRequiredValue() {
        return ObjectUtils.isEmpty(this.simpleDescription) || ObjectUtils.isEmpty(this.description);
    }

}
