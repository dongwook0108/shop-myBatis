package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.mapper.MemberMapper;
import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.model.member.UserMember;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
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
        dongwook.shoppingpractice.model.member.Member member = memberMapper.findByEmail(email);
        if (member == null || !member.isActive()) {
            throw new UsernameNotFoundException(email);
        }
        return new UserMember(member);
    }

//    -------------------------------

    public void modifyMember(Member member, ModifyForm modifyForm) {
        Member findMember = memberMapper.findById(modifyForm.getId());
        findMember.updateMember(modifyForm);

        memberMapper.updateMember(findMember);
        login(findMember);
    }

    private void login(Member member) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new UserMember(member),
                member.getPassword(),
                List.of(new SimpleGrantedAuthority(member.getRole())));
        SecurityContextHolder.getContext().setAuthentication(token);
    }

    public boolean checkPassword(Member member, String password) {

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

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
        member.updateMemberByAdmin(form);
        memberMapper.updateMember(member);
    }

    public void deleteMemberFromAdmin(AdminModifyForm form) {
        Member member = memberMapper.findById(form.getId());
        member.deleteMember(form);
        memberMapper.deleteMember(member);
    }


    public ModifyForm updateUsername(Long id, ModifyForm form) {
        Member findMember = memberMapper.findById(id);
        findMember.patchName(form);
        memberMapper.updateName(findMember);

        return form;
    }

    public ModifyForm updatePhoneNumber(Long id, ModifyForm form) {
        Member findMember = memberMapper.findById(id);
        findMember.patchPhone(form);
        memberMapper.updatePhoneNumber(findMember);

        return form;
    }
}
