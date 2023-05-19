package dongwook.shoppingpractice.form.upload;

import lombok.Getter;

@Getter
public class UploadForm {

    private String imagePath;
    private String originalFileName;


    public void setOriginalFileName(String original) {
        this.originalFileName = original;
    }

    public void setImagePath(String uploadPath) {
        this.imagePath = uploadPath;
    }
}
