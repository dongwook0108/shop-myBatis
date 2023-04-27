package dongwook.shoppingpractice.domain.member.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    public static final String EMAIL_REGEXP_CHECK_PATTERN = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    public static final String NOT_EMPTY = "공백일 수 없습니다.";

    @NotEmpty
    @Length(min = 2, max = 10, message = "username은 2글자 이상 10글자 이하로 입력해 주세요")
    private String username;
    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = EMAIL_REGEXP_CHECK_PATTERN, message = "올바른 이메일이 아닙니다.")
    private String email;
    @NotEmpty(message = NOT_EMPTY)
    private String zipcode;
    @NotEmpty(message = NOT_EMPTY)
    private String password;
    @NotEmpty(message = NOT_EMPTY)
    private String passwordConfirm;
    @NotEmpty(message = NOT_EMPTY)
    private String address;
    @NotEmpty(message = NOT_EMPTY)
    private String addressDetail;

}
