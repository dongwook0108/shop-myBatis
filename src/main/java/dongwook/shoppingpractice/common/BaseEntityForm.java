package dongwook.shoppingpractice.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntityForm {
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;


    public void modifyCreateData(String loginId) {
        this.createdBy = loginId;
        this.createdDate = LocalDateTime.now();
//        modifyUpdateData(loginId);
    }

    public void modifyUpdateData(String loginId) {
        this.updatedBy = loginId;
        this.updatedDate = LocalDateTime.now();
    }


}
