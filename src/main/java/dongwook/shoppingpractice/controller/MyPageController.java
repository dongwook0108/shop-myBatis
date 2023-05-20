package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.model.Category;
import dongwook.shoppingpractice.model.member.CurrentMember;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final CategoryService categoryService;

    @GetMapping("/my-info")
    public String myInfo(Model model) {

        List<Category> categoryList = categoryService.findParentCategory();
        model.addAttribute("categoryList", categoryList);

        return "member/my-info";
    }

    @GetMapping("/my-info-edit")
    public String myInfoEdit(@CurrentMember Member member, Model model) {

        model.addAttribute("member", member);

        List<Category> categoryList = categoryService.findParentCategory();
        model.addAttribute("categoryList", categoryList);

        return "member/my-info-edit";
    }
}
