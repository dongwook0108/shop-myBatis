package dongwook.shoppingpractice.model.member;

import dongwook.shoppingpractice.common.BaseEntityForm;
import dongwook.shoppingpractice.form.member.AdminModifyForm;
import dongwook.shoppingpractice.form.member.ModifyForm;
import dongwook.shoppingpractice.form.member.SignUpForm;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Member extends BaseEntityForm {

    private Long id;
    private String role;
    private String username;
    private String phoneNumber;
    private String email;
    private String zipcode;
    private String password;
    private String address;
    private String addressDetail;

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
        this.active = true;
        form.modifyCreateData(form.getEmail());
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
        form.modifyUpdateData(form.getUpdatedBy());
    }

    public void deleteMember() {
        this.active = false;
    }

    public void patchName(ModifyForm form) {
        if (ObjectUtils.isEmpty(form.getUsername())) {

            this.username = form.getUsername();
        }
    }

    public void patchPhone(ModifyForm form) {
        if (ObjectUtils.isEmpty(form.getPhoneNumber())) {
            this.phoneNumber = form.getPhoneNumber();
        }

    }
}
