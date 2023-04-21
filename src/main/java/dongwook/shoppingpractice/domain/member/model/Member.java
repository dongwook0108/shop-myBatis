package dongwook.shoppingpractice.domain.member.model;

import dongwook.shoppingpractice.domain.member.form.SignUpForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String zipcode;
    private String password;
    private String address;
    private String addressDetail;

    public Member(SignUpForm form) {
        this.username = form.getUsername();
        this.phoneNumber = form.getPhoneNumber();
        this.email = form.getEmail();
        this.zipcode = form.getZipcode();
        this.password = form.getPassword();
        this.address = form.getAddress();
        this.addressDetail = form.getAddressDetail();
    }

}
