package com.example.imgstorageapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageFileController {

    @GetMapping("/")
    public String index() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("owner") String owner) {
        //  logic to handle file upload
        return "redirect:/success";
    }
}
