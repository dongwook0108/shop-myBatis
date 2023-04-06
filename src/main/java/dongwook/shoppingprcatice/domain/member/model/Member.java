package dongwook.shoppingprcatice.domain.member.model;

import dongwook.shoppingprcatice.domain.member.form.SignUpForm;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

    private Long id;

    private String username;
    private String phone;
    private String email;
    private String zipcode;
    private String password;
    private String address;
    private String addressDetail;


    public Member(SignUpForm form) {
        this.username = form.getUsername();
        this.phone = form.getPhone();
        this.email = form.getEmail();
        this.zipcode = form.getZipcode();
        this.password = form.getPassword();
        this.address = form.getAddress();
        this.addressDetail = form.getAddressDetail();
    }

}
