package dongwook.shoppingpractice.dto.member;
import lombok.Data;

@Data
public class AdminModifyForm {

    private Long id;

    //    @NotEmpty
//    @Length(min = 10, max = 11, message = "전화번호는 10자리 이상 11자리 이하로 입력해 주세요")
    private String phoneNumber;

    //    @NotEmpty
//    @Length
    private String username;

    //    @NotEmpty
//    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일이 아닙니다.")
    private String email;

    private boolean active;

}
