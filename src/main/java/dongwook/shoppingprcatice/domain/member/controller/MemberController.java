package dongwook.shoppingprcatice.domain.member.controller;

import dongwook.shoppingprcatice.domain.member.form.SignUpForm;
import dongwook.shoppingprcatice.domain.member.service.MemberService;
import dongwook.shoppingprcatice.domain.member.validator.SignUpValidator;
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

}
