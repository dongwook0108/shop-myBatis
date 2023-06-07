package dongwook.shoppingpractice.service;


import static org.junit.jupiter.api.Assertions.assertThrows;

import dongwook.shoppingpractice.form.product.ProductForm;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProductServiceTest {


    @Autowired
    private ProductService productService;

    @Test
    void 상품저장() {
        //given
        ProductForm form = ProductForm.builder()
                .name("test 상품 이름")
                .price(BigDecimal.valueOf(1000))
                .simpleDescription("test 상품")
                .description("test 상품 소개")
                .originalFileName("shirt.jpg")
                .categoryId(1L)
                .featured(true)
                .build();

        // when
        productService.save(form);

        // then
        log.info("저장된 상품 정보={}", form);
        Assertions.assertThat(form.getName()).isEqualTo("test 상품 이름");
        Assertions.assertThat(form.getDescription()).isEqualTo("test 상품 소개");
    }

    @Test
    void 가격이_0원이_입력될_때() {
        //given
        ProductForm form = ProductForm.builder()
                .name("test 상품 이름")
                .price(BigDecimal.ZERO)
                .simpleDescription("test 상품")
                .description("test 삼품 소개")
                .originalFileName("shirt.jpg")
                .categoryId(1L)
                .featured(true)
                .build();
        //when
//        productService.save(form);
        // 가격은 0원 초과이어야 합니다.

        //then
        assertThrows(IllegalArgumentException.class,
                () -> productService.save(form));
    }

    @Test
    void 상품_설명_글이_둘_중_하라도_비어있을_때() {
        //given
        ProductForm form = ProductForm.builder()
                .name("test 상품 이름")
                .price(BigDecimal.ZERO)
                .simpleDescription(null)
                .description(null)
                .originalFileName("shirt.jpg")
                .categoryId(1L)
                .featured(true)
                .build();

//        productService.save(form);
        //.ProductSaveException: 제품 설명 부분은 비어있을 수 없습니다.

//        then
        assertThrows(IllegalArgumentException.class,
                () -> productService.save(form));
    }
}