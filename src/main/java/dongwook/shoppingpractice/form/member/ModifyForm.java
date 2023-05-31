package dongwook.shoppingpractice.form.member;

import dongwook.shoppingpractice.model.member.Member;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyForm {

    static final String NOTNULL = "공백일 수 없습니다";
    static final String EMAIL_REGEXP_CHECK_PATTERN = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private Long id;
    private String username;
    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = EMAIL_REGEXP_CHECK_PATTERN, message = "올바른 이메일이 아닙니다.")
    private String email;
    @NotEmpty(message = NOTNULL)
    private String address;
    @NotEmpty(message = NOTNULL)
    private String addressDetail;
    @NotEmpty(message = NOTNULL)
    private String zipcode;


    public ModifyForm(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.phoneNumber = member.getPhoneNumber();
        this.addressDetail = member.getAddressDetail();
        this.zipcode = member.getZipcode();
    }

}