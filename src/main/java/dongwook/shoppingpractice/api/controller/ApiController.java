package dongwook.shoppingpractice.api.controller;

import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.model.member.Member;
import dongwook.shoppingpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class ApiController {

    private final MemberService memberService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> memberDetail(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Member> editMemberFromAdmin(@PathVariable Long id,
            @RequestBody AdminModifyForm form) {
        Member member = memberService.updateMemberFromAdmin(id, form);

        return (member != null) ?
                ResponseEntity.status(HttpStatus.OK).body(null) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMemberFromAdmin(@PathVariable Long id) {
        Member member = memberService.deleteMemberFromAdmin(id);

        return (member != null) ?
                ResponseEntity.status(HttpStatus.OK).body(null) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
