package dongwook.shoppingpractice.service;

import static org.junit.jupiter.api.Assertions.*;

import dongwook.shoppingpractice.form.category.CategoryForm;
import dongwook.shoppingpractice.mapper.CategoryMapper;
import dongwook.shoppingpractice.model.Category;
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
        categoryMapper.save(category);

        // then
        log.info("category={}", category);
        Assertions.assertThat(category.getName()).isEqualTo("long-shirts");
        Assertions.assertThat(category.getCategoryCode()).isEqualTo("shirts");
        Assertions.assertThat(category.getParentId()).isEqualTo(1L);
    }


}