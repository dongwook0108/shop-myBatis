package dongwook.shoppingpractice.form.member;

import dongwook.shoppingpractice.common.BaseEntityForm;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class AdminModifyForm extends BaseEntityForm {

    static final String EMAIL_REGEXP_CHECK_PATTERN = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    private Long id;

    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;

    @NotEmpty
    @Length
    private String username;

    @NotEmpty
    @Pattern(regexp = EMAIL_REGEXP_CHECK_PATTERN, message = "올바른 이메일이 아닙니다.")
    private String email;

    @Builder
    public AdminModifyForm(Long id, String phoneNumber, String username, String email) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
    }
}
