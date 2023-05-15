package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    @GetMapping("/my-info")
    public String myInfo() {
        return "member/my-info";
    }

    @GetMapping("/my-info-edit")
    public String myInfoEdit(@CurrentMember Member member, Model model) {
        model.addAttribute("member", member);

        return "member/my-info-edit";
    }
}
