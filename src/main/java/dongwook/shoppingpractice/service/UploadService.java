package dongwook.shoppingpractice.service;

import dongwook.shoppingpractice.form.upload.UploadForm;
import dongwook.shoppingpractice.mapper.UploadMapper;
import dongwook.shoppingpractice.model.Upload;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final UploadMapper uploadMapper;

    public List<Upload> findAll() {
        return uploadMapper.findAll();
    }

    public void save(UploadForm form) {
        Upload upload = new Upload(form);
        uploadMapper.save(upload);
    }

    public List<Upload> findAllFileName() {
        return uploadMapper.findAllFileName();
    }
}
