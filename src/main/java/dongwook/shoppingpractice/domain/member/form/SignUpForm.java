package dongwook.shoppingpractice.domain.member.form;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SignUpForm {

    static final String NOTNULL = "공백일 수 없습니다";

    @NotEmpty
    @Length(min = 2, max = 10, message = "username은 2글자 이상 10글자 이하로 입력해 주세요" )
    private String username;
    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일이 아닙니다.")
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

    private String createdBt;

}
