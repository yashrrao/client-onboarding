package com.syntel.client.onboarding.kyc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentUploadController {


    @PostMapping ("/{fileid}/file")
    public String uploadDocument (@PathVariable long fileId, @RequestParam("file") MultipartFile multipartFile) {

        return true;
    }


}
