package dongwook.shoppingprcatice.domain.member.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class SignUpForm {

    @NotEmpty
    @Length(min = 2, max = 10, message = "username은 2글자 이상 10글자 이하로 입력해 주세요" )
    private String username;
    @NotEmpty
    @Length(min = 10, max = 10, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요" )
    private String phone;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일이 아닙니다.")
    private String email;
    @NotEmpty(message = "공백일 수 없습니다")
    private String zipcode;
    @NotEmpty(message = "공백일 수 없습니다")
    private String password;
    @NotEmpty(message = "공백일 수 없습니다")
    private String passwordConfirm;
    @NotEmpty(message = "공백일 수 없습니다")
    private String address;
    @NotEmpty(message = "공백일 수 없습니다")
    private String addressDetail;

}
