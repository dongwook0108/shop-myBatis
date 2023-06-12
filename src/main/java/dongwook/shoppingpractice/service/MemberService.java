package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.common.security.SecurityUtils;
import dongwook.shoppingpractice.form.common.PageDto;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.mapper.MemberMapper;
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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public void save(SignUpForm form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
//        form.setPassword(SecurityUtils.encryptPassword(form.getPassword()));
        Member member = new Member(form);
        memberMapper.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberMapper.findByEmail(email);
        if (ObjectUtils.isEmpty(member) || !member.isActive()) {
            throw new UsernameNotFoundException(email);
        }
        return new UserMember(member);
    }


    public void modifyMember(ModifyForm modifyForm) {
        Member member = memberMapper.findById(modifyForm.getId());
        member.updateMember(modifyForm);
        memberMapper.updateMember(member);
        login(member);
    }

    public void login(Member member) {
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
        return memberMapper.findById(memberId);
    }

    public List<Member> getMemberList(PageDto pageDTO) {

        int page = pageDTO.getPage();
        int size = pageDTO.getSize();
        String email = pageDTO.getEmail();

        int count;
        List<Member> memberList;
        PaginationVo paginationVo;

        if (StringUtils.hasText(email)) {
            count = getCountByEmail(email);
            paginationVo = new PaginationVo(count, page, size);
            memberList = getListPageByEmail(paginationVo, email);
        } else {
            count = getCount();
            paginationVo = new PaginationVo(count, page, size);
            memberList = getListPage(paginationVo);
        }

        return memberList;
    }

    public int getCount() {
        return this.memberMapper.getCount();
    }

    public List<Member> getListPage(PaginationVo paginationVo) {
        return memberMapper.getListPage(paginationVo);
    }

    public List<Member> getListPageByEmail(PaginationVo paginationVo, String email) {
        return memberMapper.getListPageByEmail(paginationVo, email);
    }

    public int getCountByEmail(String email) {
        return memberMapper.getCountByEmail(email);
    }

    public Member updateMemberFromAdmin(Long id, AdminModifyForm form) {
        Member member = memberMapper.findById(id);
        member.updateMemberByAdmin(form);
        memberMapper.updateMember(member);
        return member;
    }

    public Member deleteMemberFromAdmin(Long id) {
        Member member = memberMapper.findById(id);
        member.deleteMember();
        memberMapper.deleteMember(member);
        return member;
    }
}
