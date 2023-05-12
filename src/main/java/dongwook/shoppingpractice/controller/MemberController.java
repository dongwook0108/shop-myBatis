package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.member.model.CurrentMember;
import dongwook.shoppingpractice.member.model.Member;
import dongwook.shoppingpractice.service.MemberService;
import dongwook.shoppingpractice.member.validator.ModifyValidator;
import dongwook.shoppingpractice.member.validator.SignUpValidator;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SignUpValidator signUpValidator;
    private final ModifyValidator modifyValidator;

    @InitBinder(value = "signUpForm")
    public void webDataBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpValidator);
    }

    @InitBinder(value = "modifyForm")
    public void webDataBinder2(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(modifyValidator);
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
    public String checkPasswordForm() {
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
    public String modifyMemberInfoForm(@CurrentMember Member member, Model model) {
        model.addAttribute("message", "수정 완료");
        model.addAttribute("findMember", member);
        return "member/my-page";
    }

    //---------------------------------------------회원 정보 수정 폼-------------------------------------------------------------
    @GetMapping(value = "/my-page/edit")
    public String modifyMemberInfoForm1(@CurrentMember Member member, Model model) {
        model.addAttribute(member);
        model.addAttribute(new ModifyForm(member));
        return "member/my-page-edit";
    }

    @PostMapping(value = "/my-page/edit")
    public String modifyMemberInfo1(@CurrentMember Member member, @Valid ModifyForm modifyForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/my-page-edit";
        }
        memberService.modifyMember(member, modifyForm);
        return "redirect:/member/my-page";
    }


}
