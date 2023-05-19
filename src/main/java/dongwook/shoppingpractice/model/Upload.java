package dongwook.shoppingpractice.model;

import dongwook.shoppingpractice.form.upload.UploadForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Upload {

    private Long id;

    private String imagePath;

    private String originalFileName;


    public Upload(UploadForm form) {
        this.imagePath = form.getImagePath();
        this.originalFileName = form.getOriginalFileName();
    }
}
