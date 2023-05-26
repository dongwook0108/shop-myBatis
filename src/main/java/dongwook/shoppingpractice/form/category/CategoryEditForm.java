package dongwook.shoppingpractice.form.category;

import lombok.Getter;

@Getter
public class CategoryEditForm {

    private Long id;
    private String name;
    private String categoryCode;
    private Long parentId;

    public void setId(Long id) {
        this.id = id;
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

    public static CategoryEditForm editForm(CategoryEditForm form, Long id) {
        CategoryEditForm editForm = new CategoryEditForm();
        editForm.setId(id);
        editForm.setName(form.getName());
        editForm.setCategoryCode(form.getCategoryCode());
        editForm.setParentId(form.getParentId());
        return editForm;
    }
}
