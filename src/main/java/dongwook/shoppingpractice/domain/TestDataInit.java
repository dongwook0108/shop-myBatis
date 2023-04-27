package dongwook.shoppingpractice.domain;

import dongwook.shoppingpractice.domain.member.mapper.MemberMapper;
import dongwook.shoppingpractice.domain.member.model.Member;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dataInit() {
        Member member = new Member(1L, "dongwook", "01012341234", "test11@naver.com", "1234",
                passwordEncoder.encode("123qwe"), "rose11", "11st");
        memberMapper.save(member);
    }

}
