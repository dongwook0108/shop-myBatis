package dongwook.shoppingpractice.dto.member;

import dongwook.shoppingpractice.member.model.Member;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyForm {

    static final String NOTNULL = "공백일 수 없습니다";
    private Long id;
    private String name;

    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일이 아닙니다.")
    private String email;
    @NotEmpty(message = NOTNULL)
    private String address;
    @NotEmpty(message = NOTNULL)
    private String addressDetail;
    @NotEmpty(message = NOTNULL)
    private String zipcode;

    public ModifyForm(Member member) {
        this.id = member.getId();
        this.name = member.getUsername();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.phoneNumber = member.getPhoneNumber();
        this.addressDetail = member.getAddressDetail();
        this.zipcode = member.getZipcode();
    }
}
