package dongwook.shoppingpractice.mapper;

import dongwook.shoppingpractice.model.Category;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {

    @Results(id = "CategoryMap", value = {
            @Result(property = "id", column = "category_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "parentId", column = "parent_id")
    })
    @Select(value = "SELECT * FROM category")
    List<Category> findAll();


    @Insert(value = "INSERT INTO category(name,category_code,parent_id) VALUES(#{category.name},#{category.categoryCode},#{category.parentId})")
    void save(@Param(value = "category") Category category);


    @ResultMap(value = "CategoryMap")
    @Select(value = "SELECT * FROM category where parent_id is NULL")
    List<Category> findParentCategory();


    @ResultMap(value = "CategoryMap")
    @Select(value = "SELECT * FROM category where parent_id is not NULL")
    List<Category> findChildCategory();

}
