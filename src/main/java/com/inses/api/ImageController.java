package com.inses.api;

import com.inses.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping
    public ResponseEntity create(@RequestBody MultipartFile[] files) {

        for (MultipartFile file : files) {

            try {

                String fileName = imageService.save(file);

                String imageUrl = imageService.getImageUrl(fileName);

                // do whatever you want with that

            } catch (Exception e) {
                //  throw internal error;
            }
        }

        return ResponseEntity.ok().build();
    }
}
