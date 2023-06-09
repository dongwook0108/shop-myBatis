package dongwook.shoppingpractice.controller;

import dongwook.shoppingpractice.form.upload.UploadForm;
import dongwook.shoppingpractice.model.Upload;
import dongwook.shoppingpractice.service.UploadService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UploadController {

    @Value("${file.dir}")
    private String fileDir;

    private final UploadService uploadService;

    @GetMapping("/uploads")
    public String uploadPageHome(Model model) {
        // TODO: 명확한 이름으로 변경 해주세요
        List<Upload> uploadList = uploadService.findAll();
        model.addAttribute("uploadList", uploadList);
        return "upload/upload";
    }

    @GetMapping("/upload")
    public String uploadPage(UploadForm uploadForm, Model model) {
        model.addAttribute("uploadForm", uploadForm);
        return "upload/upload-add";
    }

    @PostMapping("/upload")
    public String upload(MultipartHttpServletRequest multipartHttpServletRequest, UploadForm form) {

        MultipartFile mf = multipartHttpServletRequest.getFile("file");

        String original = mf.getOriginalFilename(); // 업로드하는 파일 name
        fileDir = fileDir + original; // 파일 업로드 경로 + 파일 이름

        try {
            mf.transferTo(new File(fileDir)); // 파일을 위에 지정 경로로 업로드
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        uploadService.save(form);

        return "redirect:/upload";
    }
}
