package dongwook.shoppingpractice.domain.member.service;

import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.model.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberServiceTest {
    private final MemberMapper memberMapper;

    @Autowired
    MemberServiceTest(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Test
    void 회원저장(){
        //given
        SignUpForm signUpForm = new SignUpForm();

        signUpForm.setUsername("kim");
        signUpForm.setPhoneNumber("0104433444");
        signUpForm.setEmail("test13213@naver.com");
        signUpForm.setPassword("123qwe");
        signUpForm.setPasswordConfirm("123qwe");
        signUpForm.setZipcode("111222");
        signUpForm.setAddress("roseStreet");
        signUpForm.setAddressDetail("96block");

        //when
        Member member = new Member(signUpForm);
        memberMapper.save(member);

        //then
        log.info("member={}", member);
    }

}