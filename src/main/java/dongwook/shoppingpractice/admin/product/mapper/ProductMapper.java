package dongwook.shoppingpractice.admin.product.mapper;

import dongwook.shoppingpractice.admin.product.form.ProductForm;
import dongwook.shoppingpractice.admin.product.model.Product;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

    // 쿼리만 ->
    @Insert(value =
            "INSERT INTO PRODUCT(name, description, simple_description, price, updated_date, created_date) "
                    +
                    "VALUES(#{product.name}, #{product.description}, #{product.simpleDescription},#{product.price}, #{product.updatedDate}, #{product.createdDate})")
    void save(@Param(value = "product") ProductForm product);
    //  ->


    @Select(value = "SELECT * FROM PRODUCT")
    List<Product> productList();

    @Select(value = "SELECT * FROM PRODUCT where product_id = #{productId}")
    Product findById(@Param(value = "productId") Long productId);

    @Update(value = "UPDATE PRODUCT SET name=#{product.name}, description=#{product.description}, simpleDescription=#{product.simpleDescription}, stock=#{product.stock} , price=#{product.price} WHERE product_id = #{productId} ")
    void updateProduct(@Param(value = "product") Product product);
}
