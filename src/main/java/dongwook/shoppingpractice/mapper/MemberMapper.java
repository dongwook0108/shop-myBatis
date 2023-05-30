package dongwook.shoppingpractice.mapper;

import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.model.member.Member;
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

    @ResultMap(value = "MemberMap")
    @Insert(value =
            "INSERT INTO member(username, role, phone_number, email, zipcode, password, address,"
                    + " address_detail, active, created_date, created_by)"
                    + " VALUES(#{member.username}, #{member.role},  #{member.phoneNumber},"
                    + " #{member.email}, #{member.zipcode}, #{member.password}, #{member.address},"
                    + " #{member.addressDetail}, #{member.active}, #{member.createdDate}, #{member.createdBy})")
    void save(@Param(value = "member") Member member);

    @Select(value = "SELECT EXISTS (SELECT 1 FROM member WHERE phone_number = #{phoneNumber})")
    boolean existsByPhone(@Param(value = "phoneNumber") String phoneNumber);

    @Select(value = "SELECT EXISTS (SELECT 1 FROM member WHERE email = #{email})")
    boolean existsByEmail(@Param(value = "email") String email);

    @Results(id = "MemberMap", value = {
            @Result(property = "id", column = "member_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email", column = "email"),
            @Result(property = "zipcode", column = "zipcode"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "addressDetail", column = "address_detail"),
            @Result(property = "role", column = "role"),
            @Result(property = "active", column = "active"),
            @Result(property = "updatedDate", column = "updated_date"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "updatedBy", column = "updated_by")
    })
    @Select(value = "SELECT * FROM member WHERE email = #{email}")
    Member findByEmail(@Param(value = "email") String email);

    @ResultMap(value = "MemberMap")
    @Select(value = "SELECT * FROM member WHERE member_id = #{memberId}")
    Member findById(@Param(value = "memberId") Long memberId);

    @ResultMap(value = "MemberMap")
    @Update(value =
            "UPDATE member SET username=#{member.username}, phone_number=#{member.phoneNumber},"
                    + " email=#{member.email}, zipcode=#{member.zipcode}, address=#{member.address},"
                    + " address_detail=#{member.addressDetail}, updated_date=#{member.updatedDate},"
                    + " updated_by=#{member.updatedBy} WHERE member_id = #{member.id}")
    void updateMember(@Param(value = "member") Member member);

    //    --------------------------페이징 -------------------------
    @Select(value = "SELECT count(*) as listCnt from member where active = true")
    int getCount();

    @Select(value = "SELECT count(*) as listCnt from member where email=#{email} and active = true")
    int getCountByEmail(@Param(value = "email") String email);

    @Select(value = "SELECT * FROM member WHERE active = true "
            + "ORDER BY member_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Member> getListPage(@Param(value = "page") PaginationVo paginationVo);


    @Select(value = "SELECT * FROM member where email like concat('%',#{email},'%')"
            + " ORDER BY member_id DESC LIMIT #{page.rowCount} OFFSET #{page.offset}")
    List<Member> getListPageByEmail(@Param(value = "page") PaginationVo paginationVo,
            @Param(value = "email") String email);

    @Update(value = "UPDATE member SET active=#{member.active} WHERE member_id=#{member.id}")
    void deleteMember(@Param(value = "member") Member member);

    @Update(value = "UPDATE member SET username=#{member.username} WHERE member_id=#{member.id}")
    void updateName(@Param(value = "member") Member member);

    @Update(value = "UPDATE member SET phone_number=#{member.phoneNumber} WHERE member_id=#{member.id}")
    void updatePhoneNumber(@Param(value = "member") Member member);
}
