package dongwook.shoppingpractice.mapper;

import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.model.Product;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

    @Insert(value =
            "INSERT INTO PRODUCT(name, description, simple_description, price, original_file_name, created_date, created_by) "
                    +
                    "VALUES(#{product.name}, #{product.description}, #{product.simpleDescription},#{product.price}, #{product.originalFileName},#{product.createdDate}, #{product.createdBy})")
    void save(@Param(value = "product") Product product);


    @Results(id = "ProductMap", value = {
            @Result(property = "id", column = "product_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "simpleDescription", column = "simple_description"),
            @Result(property = "price", column = "price"),
            @Result(property = "originalFileName", column = "original_file_name"),
            @Result(property = "updatedDate", column = "updated_date"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "updatedBy", column = "updated_by"),
            @Result(property = "createdBy", column = "created_by")
    })
    @Select(value = "SELECT * FROM PRODUCT")
    List<Product> productList();

    @ResultMap(value = "ProductMap")
    @Select(value = "SELECT * FROM PRODUCT where product_id = #{productId}")
    Product findById(@Param(value = "productId") Long productId);

    @Update(value = "UPDATE PRODUCT SET name=#{product.name}, description=#{product.description}, simple_description=#{product.simpleDescription}, price=#{product.price}, updated_date=#{product.updatedDate} WHERE product_id = #{product.id} ")
    void updateProduct(@Param(value = "product") Product product);

//    paging

    @Select(value = "SELECT count(*) as listCnt from product")
    int getCount();

    @Select(value = "SELECT count(*) as listCnt from product where name=#{name}")
    int getCountByName(@Param(value = "name") String name);

    @ResultMap(value = "ProductMap")
    @Select(value = "SELECT * FROM product ORDER BY product_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Product> getListPage(@Param(value = "page") PaginationVo paginationVo);


    @Select(value = "SELECT * FROM product where email like concat('%',#{name},'%') ORDER BY product_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Product> getListPageByName(@Param(value = "page") PaginationVo paginationVo,
            @Param(value = "name") String name);

}
