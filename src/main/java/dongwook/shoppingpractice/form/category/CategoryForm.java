package dongwook.shoppingpractice.form.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {

    private String name;
    private String categoryCode;
    private Long parentId;

}
