package dongwook.shoppingpractice.form.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
//@NoArgsConstructor -> 이게 있으면 객체를 못만들어주는데 이유 찾아보기
public class CategoryForm {

    private Long id;
    private String name;
    private String categoryCode;
    private Long parentId;

    @Builder
    public CategoryForm(Long id, String name, String categoryCode, Long parentId) {
        this.id = id;
        this.name = name;
        this.categoryCode = categoryCode;
        this.parentId = parentId;
    }


}
