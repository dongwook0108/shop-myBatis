package dongwook.shoppingprcatice.domain.member.mapper;

import dongwook.shoppingprcatice.domain.member.model.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    //save
    @Insert(value = "INSERT INTO MEMBER(username, phone, email, zipcode, password, address, addressDetail) " +
            "VALUES(#{member.username}, #{member.phoneNumber},#{member.email},#{member.zipcode},#{member.password},#{member.address},#{member.addressDetail})")
    void save(@Param(value = "member") Member member);


    @Select(value = "SELECT EXISTS (SELECT 1 FROM MEMBER WHERE phone = #{phoneNumber})")
    boolean existsByPhone(@Param(value = "phoneNumber") String phoneNumber);

    @Select(value = "SELECT EXISTS (SELECT 1 FROM MEMBER WHERE email = #{email})")
    boolean existsByEmail(@Param(value = "email") String email);

    @Results(id = "MemberMap", value = {
            @Result(property = "id", column = "member_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "zipcode", column = "zipcode"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "addressDetail", column = "addressDetail"),
    })
    @Select(value = "SELECT * FROM MEMBER WHERE email = #{username}")
    Member findByEmail(@Param(value = "username") String username);
}
