package dongwook.shoppingpractice.validator;

import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.model.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ModifyValidator implements Validator {

    private final MemberMapper memberMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ModifyForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ModifyForm modifyForm = (ModifyForm) target;
        System.out.println("modifyForm = " + modifyForm);

        Member member = memberMapper.findById(modifyForm.getId());

        if (!member.getEmail().equals(modifyForm.getEmail())) {
            if (memberMapper.existsByEmail(modifyForm.getEmail())) {
                errors.rejectValue("email", "invalid.email", "이미 사용중인 이메일 입니다.");
            }
        }

        if (!member.getPhoneNumber().equals(modifyForm.getPhoneNumber())) {
            if (memberMapper.existsByPhone(modifyForm.getPhoneNumber())) {
                errors.rejectValue("phoneNumber", "invalid.phoneNumber", "이미 사용중인 전화번호입니다.");
            }
        }
    }
}












