package cibertec.com.pe.ExamenT3.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");

    @PostMapping("/upload-multiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debes subir exactamente 3 archivos.");
        }

        for (MultipartFile file : files) {
            String fileExtension = getFileExtension(file.getOriginalFilename());
            if (!ALLOWED_EXTENSIONS.contains(fileExtension)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Extensión no permitida para el archivo: " + file.getOriginalFilename());
            }
        }

        return ResponseEntity.ok("Los archivos han sido subidos con éxito.");
    }

    private String getFileExtension(String filename) {
        if (filename != null && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        }
        return "";
    }
}
