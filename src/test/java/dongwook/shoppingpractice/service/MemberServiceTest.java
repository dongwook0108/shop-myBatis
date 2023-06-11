package dongwook.shoppingpractice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.model.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
@Slf4j
class MemberServiceTest {

    @Autowired
    MemberMapper memberMapper;
    @Autowired
    MemberService memberService;

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

    @Test
    @DisplayName("일반 USER 회원가입후 로그인 성공")
    void success_login() {
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
        memberService.login(member);

        // then
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(authentication);
        assertTrue(authentication.isAuthenticated());
        assertEquals("test13213@naver.com", authentication.getName());
        assertTrue(authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("USER")));
    }

    @Test
    @DisplayName("관리자 ADMIN 회원가입후 로그인 성공")
    void success_Admin_login() {
        // given
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setUsername("kim");
        signUpForm.setPhoneNumber("0104433444");
        signUpForm.setEmail("test13213@dongwook.com");
        signUpForm.setPassword("123qwe");
        signUpForm.setPasswordConfirm("123qwe");
        signUpForm.setZipcode("111222");
        signUpForm.setAddress("roseStreet");
        signUpForm.setAddressDetail("96block");

        // when
        Member member = new Member(signUpForm);
        memberService.login(member);
//        log.info("member={}", member.getRole());

        // then
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(authentication);
        assertTrue(authentication.isAuthenticated());
        assertEquals("test13213@dongwook.com", authentication.getName());
        assertTrue(authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ADMIN")));
    }

}