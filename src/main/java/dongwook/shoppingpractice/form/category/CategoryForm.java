package dongwook.shoppingpractice.form.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {

    private String name;
    private String categoryCode;
    private Long parentId;


    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    //    public CategoryForm(CategoryForm categoryForm) {
//    }

//    public static CategoryForm categoryForm(CategoryForm form) {
//        form.setName(form.getName());
//        form.setCategoryCode(form.categoryCode);
//        form.setParentId(form.getParentId());
//        return form;
//    }
}
