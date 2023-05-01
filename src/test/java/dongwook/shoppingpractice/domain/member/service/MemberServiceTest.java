package dongwook.shoppingpractice.domain.member.service;

import dongwook.shoppingpractice.domain.member.form.EditForm;
import dongwook.shoppingpractice.domain.member.form.SignUpForm;
import dongwook.shoppingpractice.domain.member.mapper.MemberMapper;
import dongwook.shoppingpractice.domain.member.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void 회원수정() {
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

        Member member = new Member(signUpForm);
        memberMapper.save(member);
        log.info("member={}", member);
        //when

        EditForm editForm = new EditForm();
        editForm.setEmail("test1111@gmail.com");
        editForm.setPhoneNumber("01012121212");
        editForm.setZipcode("66666");
        editForm.setAddress("southern");
        editForm.setAddressDetail("108st");

        member.updatePhoneNumber(editForm.getPhoneNumber());
        member.updateEmail(editForm.getEmail());
        member.updateZipcode(editForm.getZipcode());
        member.updateAddress(editForm.getAddress());
        member.updateAddressDetail(editForm.getAddressDetail());

        log.info("new member={}", member);

    }

}