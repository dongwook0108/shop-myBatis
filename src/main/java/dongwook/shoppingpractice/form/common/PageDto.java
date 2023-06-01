package dongwook.shoppingpractice.form.common;


import lombok.Data;

@Data
public class PageDto {

    private int page;
    private int size;

    private String email;

    private int totalCount;

    public PageDto() {
        this.page = 1; // 기본 페이지 설정
        this.size = 5; // 기본 사이즈 설정
    }
}

