package dongwook.shoppingpractice.member.form;

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
public class AdminModifyForm {

    private Long id;
    @NotEmpty
    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일이 아닙니다.")
    private String email;


    public AdminModifyForm(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.phoneNumber = member.getPhoneNumber();
    }
}
