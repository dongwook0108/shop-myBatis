package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.common.aop.annotation.Trace;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.MemberService;
import dongwook.shoppingpractice.validator.ModifyValidator;
import dongwook.shoppingpractice.validator.SignUpValidator;
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

    @Trace
    @GetMapping(value = "/sign-up")
    public String signUpPage(Model model) {
        model.addAttribute(new SignUpForm());
        return "member/sign-up";
    }

    @Trace
    @PostMapping(value = "/sign-up")
    public String signUpProcess(@Valid SignUpForm signUpForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/sign-up";
        }

        memberService.save(signUpForm);
        return "redirect:/login";
    }

    @Trace
    @GetMapping(value = "/check-password")
    public String checkPasswordPage() {
        return "member/check-password";
    }

    @Trace
    @PostMapping(value = "/check-password")
    public String checkPasswordProcess(@CurrentMember Member member,
            String password, Model model) {

        if (memberService.checkPassword(member, password)) {
            return "redirect:/member/my-page";
        }

        model.addAttribute("error", "비밀번호가 틀렸습니다.");
        return "member/check-password";
    }

    @Trace
    @GetMapping(value = "/my-page")
    public String getModifyMemberFormPage(@CurrentMember Member member, Model model) {
        model.addAttribute("message", "수정 완료");
        model.addAttribute("findMember", member);
        return "member/my-page";
    }

    //---------------------------------------------회원 정보 수정 폼-------------------------------------------------------------
    @Trace
    @GetMapping(value = "/my-page/edit")
    public String modifyMemberFormPage(@CurrentMember Member member, Model model) {
        model.addAttribute(member);
        model.addAttribute(new ModifyForm(member));
        return "member/my-page-edit";
    }

    @Trace
    @PostMapping(value = "/my-page/edit")
    public String modifyMemberProcess(@Valid ModifyForm form,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/my-page-edit";
        }

        memberService.modifyMember(form);
        return "redirect:/member/my-page";
    }


}
