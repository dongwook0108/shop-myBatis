//package dongwook.shoppingpractice.domain.member.mapper;
//
//import dongwook.shoppingpractice.domain.member.form.SignUpForm;
//import dongwook.shoppingpractice.domain.member.model.Member;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//@Slf4j
//@SpringBootTest
//class H2DatabaseTest {
//
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @BeforeAll
//    static void setUp() throws Exception {
//        Class.forName("org.h2.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
//        Statement stmt = conn.createStatement();
//        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MEMBER (ID INT PRIMARY KEY, USERNAME VARCHAR(255), PHONE_NUMBER VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255), ZIPCODE VARCHAR(255), ADDRESS VARCHAR(255), ADDRESS_DETAIL VARCHAR(255))");
//        stmt.executeUpdate("INSERT INTO MEMBER(ID, USERNAME, PHONE_NUMBER, EMAIL, PASSWORD, ZIPCODE, ADDRESS, ADDRESS_DETAIL) VALUES (1, 'rrrwww', '0104433444', 'test13213@naver.com', '123qwe', '111222', 'roseStreet', '96block')");
//        stmt.close();
//        conn.close();
//    }
//
//    @Test
//    @DisplayName("save")
//    void save() {
//        SignUpForm signUpForm = new SignUpForm();
//
//        signUpForm.setUsername("dongwook");
//        signUpForm.setPhoneNumber("0104433444");
//        signUpForm.setEmail("test13213@naver.com");
//        signUpForm.setPassword("123qwe");
//        signUpForm.setPasswordConfirm("123qwe");
//        signUpForm.setZipcode("111222");
//        signUpForm.setAddress("roseStreet");
//        signUpForm.setAddressDetail("96block");
//
//        if (!signUpForm.getPassword().equals(signUpForm.getPasswordConfirm())) {
//            throw new IllegalArgumentException("password and passwordConfirm does not match");
//        }
//
//        Member member = new Member(signUpForm);
//        log.info("member={}", member);
//        memberMapper.save(member);
//    }
//
//}
