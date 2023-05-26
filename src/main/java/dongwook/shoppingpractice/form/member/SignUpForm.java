package dongwook.shoppingpractice.form.member;

import dongwook.shoppingpractice.model.member.Member;
import java.time.LocalDateTime;
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
public class SignUpForm {

    static final String NOTNULL = "공백일 수 없습니다";
    static final String EMAIL_REGEXP_CHECK_PATTERN = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    @NotEmpty
    @Length(min = 2, max = 10, message = "username은 2글자 이상 10글자 이하로 입력해 주세요")
    private String username;

    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;

    @NotEmpty
    @Pattern(regexp = EMAIL_REGEXP_CHECK_PATTERN, message = "올바른 이메일이 아닙니다.")
    private String email;

    @NotEmpty(message = NOTNULL)
    private String zipcode;

    @NotEmpty(message = NOTNULL)
    private String password;

    @NotEmpty(message = NOTNULL)
    private String passwordConfirm;

    @NotEmpty(message = NOTNULL)
    private String address;

    @NotEmpty(message = NOTNULL)
    private String addressDetail;

    private LocalDateTime updatedDate;

    private LocalDateTime createdDate;

    private String updatedBy;

    private boolean active;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

}
