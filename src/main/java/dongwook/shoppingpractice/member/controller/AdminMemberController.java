package dongwook.shoppingpractice.member.controller;

import dongwook.shoppingpractice.member.form.AdminModifyForm;
import dongwook.shoppingpractice.member.form.userpaging.PaginationVo;
import dongwook.shoppingpractice.member.model.Member;
import dongwook.shoppingpractice.member.service.MemberService;
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

    //        paging -----------------------
    @GetMapping("/members")
    public String selectListAndPage(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "email", required = false) String email) {
        List<Member> memberList;
        PaginationVo paginationVo;
        int count;
        if (StringUtils.hasText(email)) {
            count = memberService.getCountByEmail(email);
            paginationVo = new PaginationVo(count, page, size);
            memberList = memberService.getListPageByEmail(paginationVo, email);
        } else {
            count = memberService.getCount();
            paginationVo = new PaginationVo(count, page, size); // 모든 게시글 개수 구하기.
            memberList = memberService.getListPage(paginationVo);
        }

        model.addAttribute("memberList", memberList);
        model.addAttribute("pageVo", paginationVo);

        return "admin/accounts";
    }

    @PostMapping("/update-member")
    public String editMemberFromAdmin(AdminModifyForm form, RedirectAttributes redirectAttributes) {
        System.out.println("form = " + form);
        memberService.updateMemberFromAdmin(form);
        redirectAttributes.addFlashAttribute("message", "수정 완료");
        return "redirect:/admin/members";
    }

    @PostMapping("/delete-member")
    public String deleteMemberFromAdmin(AdminModifyForm form) {
        memberService.deleteMemberFromAdmin(form);
        return "redirect:/admin/members";
    }
}