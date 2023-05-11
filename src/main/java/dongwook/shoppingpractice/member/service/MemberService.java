package dongwook.shoppingpractice.member.service;

import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.member.form.AdminModifyForm;
import dongwook.shoppingpractice.member.form.ModifyForm;
import dongwook.shoppingpractice.member.form.SignUpForm;
import dongwook.shoppingpractice.member.form.userpaging.PaginationVo;
import dongwook.shoppingpractice.member.model.Member;
import dongwook.shoppingpractice.member.model.UserMember;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberMapper.findByEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserMember(member);
    }

//    -------------------------------

    public void modifyMember(Member member, ModifyForm modifyForm) {
        if (!member.getPhoneNumber().equals(modifyForm.getPhoneNumber())) {
            member.updatePhone(modifyForm.getPhoneNumber());
        }

        if (!member.getEmail().equals(modifyForm.getEmail())) {
            member.updateEmail(modifyForm.getEmail());
        }
        if (!member.getZipcode().equals(modifyForm.getZipcode())) {
            member.updateZipcode(modifyForm.getZipcode());
        }

        memberMapper.updateMember(member);
        login(member);
    }

    private void login(Member member) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new UserMember(member),
                member.getPassword(),
                List.of(new SimpleGrantedAuthority(member.getRole())));
        SecurityContextHolder.getContext().setAuthentication(token);
    }

    public boolean checkPassword(Member member, String password) {
        return passwordEncoder.matches(password, member.getPassword());
    }

    public Member findById(Long memberId) {
        Member findMember = memberMapper.findById(memberId);
        System.out.println(findMember.getEmail());
        return findMember;
    }


    //-----------------paging---------------
    // 페이징을 위한 전체 데이터 개수 파악
    public int getCount() {
        return this.memberMapper.getCount();
    }


    // 페이징을 위한 getListPage 메소드 추가
    public List<Member> getListPage(final PaginationVo paginationVo) {
        return memberMapper.getListPage(paginationVo);
    }

    public List<Member> getListPageByEmail(final PaginationVo paginationVo, String email) {
        return memberMapper.getListPageByEmail(paginationVo, email);
    }

    public int getCountByEmail(String email) {
        return memberMapper.getCountByEmail(email);
    }

    public void updateMemberFromAdmin(AdminModifyForm form) {
        Member member = memberMapper.findById(form.getId());
        member.updateMember(form);
        memberMapper.updateMember(member);
    }

    public void deleteMemberFromAdmin(AdminModifyForm form) {
        Member member = memberMapper.findById(form.getId());
        member.deleteMember(form);
        memberMapper.deleteMember(member);
    }

}
