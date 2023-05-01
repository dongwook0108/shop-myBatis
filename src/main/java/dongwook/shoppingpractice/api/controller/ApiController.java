package dongwook.shoppingpractice.api.controller;

import dongwook.shoppingpractice.domain.member.model.Member;
import dongwook.shoppingpractice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ApiController {

    private final MemberService memberService;


    @ResponseBody
    @GetMapping(value = "/member-detail")
    public ResponseEntity<Member> memberDetail(@RequestParam(value = "id") Long id) {
        Member member = memberService.findById(id);
        return ResponseEntity.ok(member);
    }


}
