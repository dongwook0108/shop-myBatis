package dongwook.shoppingpractice.domain.main.controller;


import dongwook.shoppingpractice.domain.member.model.CurrentMember;
import dongwook.shoppingpractice.domain.member.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping()
    public String index(@CurrentMember Member member, Model model) {
        if (member != null) {
            model.addAttribute(member);
        }
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "sign-in";
    }

}
