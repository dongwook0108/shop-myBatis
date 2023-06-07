package dongwook.shoppingpractice.form.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

@Getter
@ToString
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

    @Builder
    public ProductForm(String name, String simpleDescription, String description, BigDecimal price,
            String originalFileName, boolean featured, Long categoryId) {
        this.name = name;
        this.simpleDescription = simpleDescription;
        this.description = description;
        this.price = price;
        this.originalFileName = originalFileName;
        this.featured = featured;
        this.categoryId = categoryId;
    }


    public boolean isUnderZeroPrice() {
        return this.price.compareTo(BigDecimal.ZERO) <= 0;
    }

    public boolean validateRequiredValue() {
        return ObjectUtils.isEmpty(this.simpleDescription) || ObjectUtils.isEmpty(this.description);
    }


}
