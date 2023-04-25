package dongwook.shoppingpractice.domain.member.mapper;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dongwook.shoppingpractice.domain.member.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class MemberLoginTest {


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .apply(springSecurity())
                .build();

        Member member = new Member(1L, "dongwook", "01012341234", "test@naver.com", "1234",
                passwordEncoder.encode("123qwe"), "rose11", "11st");
        memberMapper.save(member);
        log.info("member={}", member);
    }

    @Test
    @DisplayName("Login 테스트")
    void login_test() throws Exception {
        // given
        String userEmail = "test@naver.com";
        String password = "123qwe";

        // when
        mvc.perform(formLogin().loginProcessingUrl("/login").user(userEmail).password(password))
                .andDo(print())
                // then
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}



