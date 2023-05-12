package dongwook.shoppingpractice.domain.member.mapper;

import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.model.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
//@ActiveProfiles(value = "test")
//@SpringBootTest(classes = MemberMapper.class)
class MemberMapperTest {

    private final MemberMapper memberMapper;

    @Autowired
    MemberMapperTest(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Test
    @DisplayName("save")
    void 회원저장(){
        SignUpForm signUpForm = new SignUpForm();

        signUpForm.setUsername("rrrwww");
        signUpForm.setPhoneNumber("0104433444");
        signUpForm.setEmail("test13213@naver.com");
        signUpForm.setPassword("123qwe");
        signUpForm.setPasswordConfirm("123qwe");
        signUpForm.setZipcode("111222");
        signUpForm.setAddress("roseStreet");
        signUpForm.setAddressDetail("96block");

        Member member = new Member(signUpForm);
        memberMapper.save(member);

        log.info("signUpForm={}", signUpForm);
        log.info("member={}", member);
    }
}