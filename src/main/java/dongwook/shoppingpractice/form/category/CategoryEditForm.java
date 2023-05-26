package dongwook.shoppingpractice.form.category;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CategoryEditForm {

    private Long id;
    private String name;
    private String categoryCode;
    private Long parentId;

    @Builder
    public CategoryEditForm(Long id, String name, String categoryCode, Long parentId) {
        this.id = id;
        this.name = name;
        this.categoryCode = categoryCode;
        this.parentId = parentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
