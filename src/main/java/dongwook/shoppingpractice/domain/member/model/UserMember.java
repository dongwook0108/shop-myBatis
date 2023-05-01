package dongwook.shoppingpractice.domain.member.model;

import java.util.List;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class UserMember extends User {

    private final Member member;

    public UserMember(Member member) {
        super(member.getEmail(), member.getPassword(),
                List.of(new SimpleGrantedAuthority(member.getRole())));
        this.member = member;
    }
}
