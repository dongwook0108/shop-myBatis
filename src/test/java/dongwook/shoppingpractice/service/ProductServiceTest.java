package dongwook.shoppingpractice.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProductServiceTest {


    @Autowired
    private ProductService productService;

//    @Test
//    @DisplayName("가격이 0원이 입력될 때")
//    void save1() {
//        //given
//        ProductForm form = new ProductForm();
//        form.setName("test상품");
//        form.setPrice(BigDecimal.valueOf(0));
//        form.setSimpleDescription("test상품이요");
//        form.setDescription("test상품이요111");
//        form.setCreatedDate(LocalDateTime.now());
//
//        //then
//
//        //productService.save(form); (ProductSaveException: 가격은 0원 초과이어야 합니다.)
//        Assertions.assertThrows(ProductSaveException.class, () -> productService.save(form));
//
//    }
//
//    @Test
//    @DisplayName("상품 설명 글이 둘 중 하라도 비어있을 때")
//    void save2() {
//        //given
//        ProductForm form = new ProductForm();
//        form.setName("test상품");
//        form.setPrice(BigDecimal.valueOf(1000));
//        form.setSimpleDescription(null);
//        form.setDescription("test상품이요111");
//        form.setCreatedDate(LocalDateTime.now());
//
////        productService.save(form); /.ProductSaveException: 제품 설명 부분은 비어있을 수 없습니다.
//        //then
//        Assertions.assertThrows(ProductSaveException.class, () -> productService.save(form));
//    }
}