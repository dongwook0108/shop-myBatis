package dongwook.shoppingpractice.model;

import dongwook.shoppingpractice.form.category.CategoryForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {


    private Long id;

    private String name;

    private String categoryCode;

    private Long parentId;

    public Category(CategoryForm form) {
        this.name = form.getName();
        this.categoryCode = form.getCategoryCode();
        this.parentId = form.getParentId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * createdDate, createdBy, UpdatedDate, updatedBy 묶어서 처리하는 법
     */

}
