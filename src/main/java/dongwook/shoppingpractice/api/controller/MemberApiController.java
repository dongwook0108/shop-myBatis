package dongwook.shoppingpractice.api.controller;

import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberApiController {

    private final MemberService memberService;

    @PatchMapping("/my-info-edit/{id}")
    public ResponseEntity<ModifyForm> editName(@PathVariable Long id,
            @RequestBody ModifyForm form) {

        ModifyForm modifyForm = memberService.updateUsername(id, form);

        return ResponseEntity.status(HttpStatus.OK).body(modifyForm);
    }

    @PatchMapping("/member-phone/{id}")
    public ResponseEntity<ModifyForm> editPhone(@PathVariable Long id,
            @RequestBody ModifyForm form) {

        ModifyForm modifyForm = memberService.updatePhoneNumber(id, form);

        return ResponseEntity.status(HttpStatus.OK).body(modifyForm);
    }
}
