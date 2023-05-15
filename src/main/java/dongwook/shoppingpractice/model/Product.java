package dongwook.shoppingpractice.model;

import dongwook.shoppingpractice.form.product.ProductEditForm;
import dongwook.shoppingpractice.form.product.ProductForm;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Long id;
    private String name;
    private String description;
    private String simpleDescription;
    private BigDecimal price;

    private String imagePath;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    private String updateBy;

    private String createdBy;

    public Product(ProductForm form) {
        this.name = form.getName();
        this.description = form.getDescription();
        this.simpleDescription = form.getSimpleDescription();
        this.price = form.getPrice();
        this.createdDate = LocalDateTime.now();
        this.imagePath = form.getImagePath();
        this.createdBy = form.getCreatedBy();
    }

    public void updateProduct(ProductEditForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
        this.simpleDescription = form.getSimpleDescription();
        this.description = form.getDescription();
        this.updatedDate = LocalDateTime.now();
    }
}
