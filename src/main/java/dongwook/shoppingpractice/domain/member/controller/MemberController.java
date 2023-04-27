package dongwook.shoppingpractice.domain.member.controller;

import dongwook.shoppingpractice.domain.member.form.SignUpForm;
import dongwook.shoppingpractice.domain.member.model.CurrentMember;
import dongwook.shoppingpractice.domain.member.model.Member;
import dongwook.shoppingpractice.domain.member.validator.SignUpValidator;
import dongwook.shoppingpractice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SignUpValidator signUpValidator;


    @InitBinder(value = "signUpForm")
    public void webDataBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpValidator);
    }

    @GetMapping(value = "/sign-up")
    public String signUp(Model model) {
        model.addAttribute(new SignUpForm());
        return "member/sign-up";
    }

    @PostMapping(value = "/sign-up")
    public String signUpProcess(@Valid SignUpForm signUpForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/sign-up";
        }
        memberService.save(signUpForm);
        return "redirect:/login";
    }

    @GetMapping(value = "/check-password")
    public String checkPasswordPage() {
        return "member/check-password";
    }

    @PostMapping(value = "/check-password")
    public String checkPassword(@CurrentMember Member member, String password, Model model) {

        if (memberService.checkPassword(member, password)) {
            return "redirect:/member/my-page";
        }

        model.addAttribute("error", "비밀번호가 틀렸습니다.");
        return "member/check-password";
    }

    @GetMapping(value = "/my-page")
    public String myPage(@CurrentMember Member member, Model model) {
        model.addAttribute("findMember", member);
        return "member/my-page";
    }
}
