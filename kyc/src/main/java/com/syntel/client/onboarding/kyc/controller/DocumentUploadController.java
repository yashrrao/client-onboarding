package com.syntel.client.onboarding.kyc.controller;


import com.syntel.client.onboarding.kyc.filestore.AwsFileStore;
import com.syntel.client.onboarding.kyc.filestore.FileBlob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class DocumentUploadController {

    //private AwsFileStore fileStore;
    //private static final Logger LOGGER = LoggerFactory.getLogger(DocumentUploadController.class);


    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Good Morning");
        return "welcome";
    }

    @RequestMapping ("/kyc/home")
    public String showForm() {
        return "welcome";
    }


//    @PostMapping ("/document/upload")
//    public String uploadDocument (@RequestParam("file") MultipartFile multipartFile) {
//
//        if (multipartFile.getSize() > 0) {
//            try {
//                FileBlob blob = new FileBlob("document-"+multipartFile.getName(),
//                        multipartFile.getInputStream(),
//                        multipartFile.getContentType());
//                fileStore.put(blob);
//            } catch (IOException ioe) {
//                LOGGER.error("Error uploading file, ", ioe);
//                return "FAILED";
//            }
//        }
//
//        return "SUCCESS";
//    }

//    @RequestMapping ("error")
//    public String showError() {
//        return "welcome";
//    }


}
