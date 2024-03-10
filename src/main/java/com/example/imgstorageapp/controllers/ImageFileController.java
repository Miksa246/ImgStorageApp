package com.example.imgstorageapp.controllers;

import com.example.imgstorageapp.entities.ImageFile;
import com.example.imgstorageapp.repositories.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.imgstorageapp.dto.ImageFileDTO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ImageFileController {
    @Autowired
    private ImageFileRepository imageFileRepository;

    // Tehtävä 1: Täältä navigoidaan UI:hin joka reagoi lähdetettyyn dataan.
    @GetMapping("/")
    public String index() {
        return "uploadForm";
    }

    // Tehtävä 3: Kuvatiedoston tallentaminen kantaan.
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("name") String name,
                                   @RequestParam("owner") String owner, Model model) {
        // Check if the file is empty
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "uploadForm";
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image")) {
            model.addAttribute("message", "Only image files are allowed.");
            return "uploadForm";
        }

        try {
            ImageFile imageFile = new ImageFile();
            imageFile.setOwner(owner);
            imageFile.setName(name);
            imageFile.setData(file.getBytes());
            imageFile.setFileSize(file.getSize());

            // Save the image file to the db
            imageFileRepository.save(imageFile);

            model.addAttribute("message", "File uploaded successfully!");
            return "uploadSuccess";
        } catch (Exception e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
            return "uploadForm";
        }
    }

    // Tehtävä 4: Kuvien haku palvelimelta
    @GetMapping("/images")
    public String listUploadedImages(Model model) {
        List<ImageFileDTO> images = imageFileRepository.findAll().stream()
                .map(imageFile -> new ImageFileDTO(imageFile.getId(), imageFile.getName(), imageFile.getOwner(), imageFile.getFileSize()))
                .collect(Collectors.toList());

        model.addAttribute("images", images);
        return "imageList"; // The name of the Thymeleaf template
    }

    // Tehtävä 5: Kuvan poistaminen
    @GetMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            imageFileRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Image deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting image.");
        }
        return "redirect:/images";
    }
}

