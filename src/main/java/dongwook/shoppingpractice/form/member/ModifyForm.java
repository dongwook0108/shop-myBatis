package dongwook.shoppingpractice.form.member;

import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public static ModifyForm modify(ModifyForm form, Long id) {
        ModifyForm modifyForm = new ModifyForm();
        modifyForm.setId(id);
        modifyForm.setUsername(form.getUsername());
        modifyForm.setPhoneNumber(form.getPhoneNumber());
        modifyForm.setEmail(form.getEmail());
        modifyForm.setAddress(form.getAddress());
        modifyForm.setAddressDetail(form.getAddressDetail());
        modifyForm.setZipcode(form.getZipcode());
        return modifyForm;
    }
}
