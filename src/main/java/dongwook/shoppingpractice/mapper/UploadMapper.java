package dongwook.shoppingpractice.mapper;

import dongwook.shoppingpractice.model.Product;
import dongwook.shoppingpractice.model.Upload;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UploadMapper {

    @Results(id = "UploadFileMap", value = {
            @Result(property = "id", column = "upload_id"),
            @Result(property = "imagePath", column = "image_path"),
            @Result(property = "originalFileName", column = "original_file_name"),
    })
    @Select("SELECT * FROM UPLOADFILE")
    List<Upload> findAll();

    @ResultMap(value = "UploadFileMap")
    @Insert(value = "INSERT INTO UPLOADFILE(image_path, original_file_name) values(#{upload.imagePath},#{upload.originalFileName})")
    void save(@Param(value = "upload") Upload upload);

    @ResultMap(value = "UploadFileMap")
    @Select(value = "SELECT original_file_name FROM uploadFile")
    List<Upload> findAllFileName();
}
