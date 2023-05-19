package dongwook.shoppingpractice.main.controller;

import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping
    public String index(@CurrentMember Member member, Model model) {
        if (member != null) {
            model.addAttribute(member);
        }
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception,
            Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "sign-in";
    }

}