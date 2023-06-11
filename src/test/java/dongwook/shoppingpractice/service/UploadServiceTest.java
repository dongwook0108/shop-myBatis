package dongwook.shoppingpractice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import dongwook.shoppingpractice.form.upload.UploadForm;
import dongwook.shoppingpractice.model.Upload;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UploadServiceTest {

    @Autowired
    UploadService uploadService;

    @Test
    void 업로드_저장() {
        // given
        UploadForm uploadForm = new UploadForm();
        uploadForm.setOriginalFileName("shirts");
        uploadForm.setImagePath("dongwook/file/images");

        // when
//        Upload upload = new Upload(uploadForm);
        uploadService.save(uploadForm);
        log.info("upload={}", uploadForm);

        // then
        assertThat(uploadForm.getOriginalFileName()).isEqualTo("shirts");
        assertThat(uploadForm.getImagePath()).isEqualTo("dongwook/file/images");
    }

}