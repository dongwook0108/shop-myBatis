package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.form.category.CategoryEditForm;
import dongwook.shoppingpractice.form.category.CategoryForm;
import dongwook.shoppingpractice.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void 카테고리_저장() {
        // given
        CategoryForm category = CategoryForm.builder()
                .categoryCode("shirts")
                .name("long-shirts")
                .parentId(1L)
                .build();

        // when
        categoryService.save(category);

        // then
        log.info("category={}", category);
        Assertions.assertThat(category.getName()).isEqualTo("long-shirts");
        Assertions.assertThat(category.getCategoryCode()).isEqualTo("shirts");
        Assertions.assertThat(category.getParentId()).isEqualTo(1L);
    }

    @Test
    void 카테고리_업데이트() {
        // given
        CategoryEditForm category = CategoryEditForm.builder()
                .categoryCode("shirts")
                .name("long-shirts")
                .parentId(2L)
                .build();

        // when
        categoryService.updateCategory(category);

        // then
        log.info("category={}", category);
        Assertions.assertThat(category.getName()).isEqualTo("long-shirts");
        Assertions.assertThat(category.getCategoryCode()).isEqualTo("shirts");
        Assertions.assertThat(category.getParentId()).isEqualTo(2L);
    }


}