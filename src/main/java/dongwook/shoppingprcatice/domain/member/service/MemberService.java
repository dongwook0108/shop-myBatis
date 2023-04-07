package dongwook.shoppingprcatice.domain.member.service;

import dongwook.shoppingprcatice.domain.member.form.SignUpForm;
import dongwook.shoppingprcatice.domain.member.mapper.MemberMapper;
import dongwook.shoppingprcatice.domain.member.model.Member;
import dongwook.shoppingprcatice.domain.member.model.UserMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public void save(SignUpForm form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        Member member = new Member(form);
        memberMapper.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberMapper.findByEmail(username);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserMember(member);
    }
}
