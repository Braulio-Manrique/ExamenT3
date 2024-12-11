package cibertec.com.pe.ExamenT3.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class SingleFileUploadController {

    @PostMapping("/upload-single")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        long maxFileSize = 25 * 1024 * 1024;

        if (file.getSize() > maxFileSize) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El archivo excede el tamaño máximo permitido de 25MB.");
        }

        return ResponseEntity.ok("Archivo subido con éxito.");
    }
}
