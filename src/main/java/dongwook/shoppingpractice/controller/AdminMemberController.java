package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminMemberController {

    private final MemberService memberService;

    @GetMapping
    public String adminHome() {
        return "admin/index";
    }

    // TODO: PageDTO 만들어서 사이즈랑 페이지 값 받기
    @GetMapping("/members")
    public String selectListAndPage(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "email", required = false) String email) {

        List<Member> memberList;
        PaginationVo paginationVo;

        // TODO: 서비스 로직으로 이동
        int count;
        if (StringUtils.hasText(email)) {
            count = memberService.getCountByEmail(email);
            paginationVo = new PaginationVo(count, page, size);
            memberList = memberService.getListPageByEmail(paginationVo, email);
        } else {
            count = memberService.getCount();
            paginationVo = new PaginationVo(count, page, size);
            memberList = memberService.getListPage(paginationVo);
        }

        model.addAttribute("memberList", memberList);
        model.addAttribute("pageVo", paginationVo);

        return "admin/accounts";
    }

    // TODO: PATCH 사용
    @PostMapping("/update-member")
    public String editMemberFromAdmin(AdminModifyForm form, RedirectAttributes redirectAttributes) {
        memberService.updateMemberFromAdmin(form);
        redirectAttributes.addFlashAttribute("message", "수정 완료");
        return "redirect:/admin/members";
    }

    // TODO: DELETE MAPPING
    @PostMapping("/delete-member")
    public String deleteMemberFromAdmin(AdminModifyForm form) {
        memberService.deleteMemberFromAdmin(form);
        return "redirect:/admin/members";
    }
}