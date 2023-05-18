package dongwook.shoppingpractice.form.product;

import dongwook.shoppingpractice.model.member.Member;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductForm {

    private String name;

    private String simpleDescription;

    private String description;

    private BigDecimal price;

    private String originalFileName;

    private String imagePath;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updateBy;

    private String createdBy;

    public void setNameAndDate(Member member) {
        this.createdBy = member.getUsername();
    }


}
