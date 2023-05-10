package dongwook.shoppingpractice.member.model;

import dongwook.shoppingpractice.member.form.AdminModifyForm;
import dongwook.shoppingpractice.member.form.SignUpForm;
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

    }

    public void updatePhone(String phone) {
        this.phoneNumber = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void updateMember(AdminModifyForm form) {
        this.username = form.getUsername();
        this.phoneNumber = form.getPhoneNumber();
        this.email = form.getEmail();
    }
}
