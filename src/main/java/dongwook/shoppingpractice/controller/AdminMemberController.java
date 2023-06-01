package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.common.PageDto;
import dongwook.shoppingpractice.form.common.PaginationVo;
import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/members")
    public String selectListAndPage(Model model, @ModelAttribute PageDto pageDto) {
        pageDto.setTotalCount(memberService.getCount());

        List<Member> memberList = memberService.getMemberList(pageDto);
        PaginationVo paginationVo = new PaginationVo(pageDto.getTotalCount(), pageDto.getPage(),
                pageDto.getSize());

        model.addAttribute("memberList", memberList);
        model.addAttribute("pageVo", paginationVo);

        return "admin/accounts";
    }

    @PostMapping("/update-member")
    public String editMemberFromAdmin(AdminModifyForm form, RedirectAttributes redirectAttributes) {
        memberService.updateMemberFromAdmin(form.getId(), form);
        redirectAttributes.addFlashAttribute("message", "수정 완료");
        return "redirect:/admin/members";
    }

    @PostMapping("/delete-member")
    public String deleteMemberFromAdmin(AdminModifyForm form) {
        memberService.deleteMemberFromAdmin(form.getId());
        return "redirect:/admin/members";
    }
}