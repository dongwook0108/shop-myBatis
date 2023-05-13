package dongwook.shoppingpractice.api.controller;

import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

//    private final MemberService memberService;
//
//    @PatchMapping("/api/members/{id}")
//    public ResponseEntity<Member> updateMember(@PathVariable Long id,
//            @RequestBody ModifyForm form
//    ) {
//        memberService.update(id, form);
//
//
//        Member member = memberService.findById(id);
//        memberService.modifyMember(member, form);
//        return ResponseEntity.status(HttpStatus.OK).body(member);
//    }

}
