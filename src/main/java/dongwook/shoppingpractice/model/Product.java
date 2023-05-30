package dongwook.shoppingpractice.model;

import dongwook.shoppingpractice.common.BaseEntityForm;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseEntityForm {

    private Long id;
    private String name;
    private String description;
    private String simpleDescription;
    private BigDecimal price;

    private String originalFileName;
    private String imagePath;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    private String updatedBy;
    private String createdBy;

    private boolean featured;

    private Long categoryId;

    // builder 패턴말고 생성자로 통으로 주입 받는 방법도 좋은 거 같은데 알아보기 무슨 차이가 있는건지
//    public Product(ProductForm form) {
//        this.name = form.getName();
//        this.description = form.getDescription();
//        this.simpleDescription = form.getSimpleDescription();
//        this.price = form.getPrice();
//        this.originalFileName = form.getOriginalFileName();
//        this.featured = form.isFeatured();
//        this.categoryId = form.getCategoryId();
//        modifyCreateData(form.getCreatedBy());
//    }

//    public void updateProduct(ProductEditForm form) {
//        this.name = form.getName();
//        this.price = form.getPrice();
//        this.simpleDescription = form.getSimpleDescription();
//        this.description = form.getDescription();
//        modifyUpdateData(form.getUpdatedBy());
//    }
}
