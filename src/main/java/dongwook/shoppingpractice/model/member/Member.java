package dongwook.shoppingpractice.model.member;

import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Member {

    private Long id;
    private String role;
    private String username;
    private String phoneNumber;
    private String email;
    private String zipcode;
    private String password;
    private String address;
    private String addressDetail;

    private LocalDateTime updatedDate;

    private LocalDateTime createdDate;

    private String updatedBy;

    private String createdBt;

    private boolean active;


    public Member(SignUpForm form) {
        if (form.getEmail().contains("@dongwook.com")) {
            this.role = MemberRole.ADMIN.name();
        } else {
            this.role = MemberRole.USER.name();
        }
        this.username = form.getUsername();
        this.phoneNumber = form.getPhoneNumber();
        this.email = form.getEmail();
        this.zipcode = form.getZipcode();
        this.password = form.getPassword();
        this.address = form.getAddress();
        this.addressDetail = form.getAddressDetail();
        this.createdDate = LocalDateTime.now();
        this.active = true;
    }

    public void updateMember(ModifyForm form) {
        this.username = form.getUsername();
        this.email = form.getEmail();
        this.phoneNumber = form.getPhoneNumber();
        this.zipcode = form.getZipcode();
        this.address = form.getAddress();
        this.addressDetail = form.getAddressDetail();
    }


    public void updateMemberByAdmin(AdminModifyForm form) {
        this.username = form.getUsername();
        this.phoneNumber = form.getPhoneNumber();
        this.email = form.getEmail();
    }

    public void deleteMember(AdminModifyForm form) {
        this.active = false;
    }

    public void patchName(ModifyForm form) {

        if (form.getId() != this.id) {
            throw new IllegalArgumentException("이름 수정 실패");
        }

        if (form.getUsername() != null) {
            this.username = form.getUsername();
        }

    }

    public void patchPhone(ModifyForm form) {

        if (form.getId() != this.id) {
            throw new IllegalArgumentException("전화번호 수정 실패");
        }

        if (form.getPhoneNumber() != null) {
            this.phoneNumber = form.getPhoneNumber();
        }

    }
}
