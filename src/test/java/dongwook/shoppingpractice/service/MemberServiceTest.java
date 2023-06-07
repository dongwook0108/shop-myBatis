package dongwook.shoppingpractice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.model.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
class MemberServiceTest {

    private final MemberMapper memberMapper;

    @Autowired
    MemberServiceTest(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Test
    @DisplayName("회원가입")
    void signUp() {
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
        assertThat(member.getUsername()).isEqualTo("kim");
        assertThat(member.getEmail()).isEqualTo("test13213@naver.com");

    }

    @Test
    @DisplayName("회원 가입 시 같은 이메일 검증")
    void signUpWithExistEmail() {
        // given
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setUsername("kim");
        signUpForm.setPhoneNumber("0104433444");
        signUpForm.setEmail("test13213@naver.com");
        signUpForm.setPassword("123qwe");
        signUpForm.setPasswordConfirm("123qwe");
        signUpForm.setZipcode("111222");
        signUpForm.setAddress("roseStreet");
        signUpForm.setAddressDetail("96block");

        // when
        Member member = new Member(signUpForm);
        memberMapper.save(member);

        // then
        assertThrows(DuplicateKeyException.class, () -> {
            Member duplicateMember = new Member(signUpForm);
            memberMapper.save(duplicateMember);
        });


    }

}