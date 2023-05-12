package dongwook.shoppingpractice.member.validator;

import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.dto.member.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpValidator implements Validator {

    private final MemberMapper memberMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        SignUpForm signUpForm = (SignUpForm) target;

        if (memberMapper.existsByPhone(signUpForm.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "invalid.phoneNumber", "이미 사용중인 핸드폰 번호입니다.");
        }

        if (memberMapper.existsByEmail(signUpForm.getEmail())) {
            errors.rejectValue("email", "invalid.email", "이미 사용중인 이메일입니다.");
        }

        if (!signUpForm.getPassword().equals(signUpForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "invalid.passwordConfirm", "입력한 비밀번호가 서로 다릅니다.");
        }
    }
}
