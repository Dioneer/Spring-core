package Pegas.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class ImageService {
    @Value("${app.image.bucket}")
    private String bucket;

    @SneakyThrows
    public void upload(String imagePath, InputStream content){
        Path fullImagePath = Path.of(bucket, imagePath);

        try(content){
            Files.createDirectories(fullImagePath.getParent());
            Files.write(fullImagePath, content.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
