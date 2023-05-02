package dongwook.shoppingpractice.domain.member.mapper;

import dongwook.shoppingpractice.domain.member.form.userpaging.PaginationVo;
import dongwook.shoppingpractice.domain.member.model.Member;
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
public interface MemberMapper {

    @Insert(value =
            "INSERT INTO MEMBER(username, role, phoneNumber, email, zipcode, password, address, addressDetail) "
                    +
                    "VALUES(#{member.username}, #{member.role},  #{member.phoneNumber},#{member.email},#{member.zipcode},#{member.password},#{member.address},#{member.addressDetail})")
    void save(@Param(value = "member") Member member);

    @Select(value = "SELECT EXISTS (SELECT 1 FROM MEMBER WHERE phoneNumber = #{phoneNumber})")
    boolean existsByPhone(@Param(value = "phoneNumber") String phoneNumber);

    @Select(value = "SELECT EXISTS (SELECT 1 FROM MEMBER WHERE email = #{email})")
    boolean existsByEmail(@Param(value = "email") String email);

    @Results(id = "MemberMap", value = {
            @Result(property = "id", column = "member_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
            @Result(property = "email", column = "email"),
            @Result(property = "zipcode", column = "zipcode"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "addressDetail", column = "addressDetail"),
            @Result(property = "role", column = "role")
    })
    @Select(value = "SELECT * FROM MEMBER WHERE email = #{email}")
    Member findByEmail(@Param(value = "email") String email);

    @ResultMap(value = "MemberMap")
    @Select(value = "SELECT * FROM MEMBER WHERE member_id = #{memberId}")
    Member findById(@Param(value = "memberId") Long memberId);

    @Update(value = "UPDATE MEMBER SET phoneNumber=#{member.phoneNumber}, email=#{member.email}, zipcode=#{member.zipcode}, address=#{member.address}, addressDetail=#{member.addressDetail} WHERE member_id = #{member.id} ")
    void updateMember(@Param(value = "member") Member member);

//    --------------------------페이징 -------------------------

    @Select(value = "SELECT count(*) as listCnt from member")
    int getCount();

    @Select(value = "SELECT count(*) as listCnt from member where email=#{email}")
    int getCountByEmail(@Param(value = "email") String email);

    @Select(value = "SELECT * FROM member ORDER BY member_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Member> getListPage(@Param(value = "page") PaginationVo paginationVo);


    @Select(value = "SELECT * FROM member where email like concat('%',#{email},'%') ORDER BY member_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Member> getListPageByEmail(@Param(value = "page") PaginationVo paginationVo,
            @Param(value = "email") String email);

}
