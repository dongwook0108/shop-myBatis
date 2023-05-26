package dongwook.shoppingpractice.form.member;

import dongwook.shoppingpractice.model.member.Member;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
//@NoArgsConstructor
//@Getter
//@AllArgsConstructor
public class AdminModifyForm {

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

    private String updatedBy;

    private LocalDateTime updatedDate;

    private boolean active;

    public void updateDateAndBy(Member member) {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = member.getUsername();
    }
}
