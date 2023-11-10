package com.infy.employee.Controller;

import com.infy.employee.Service.UploadFileService;
import com.infy.employee.Utility.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class uploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file){
//        FileResponse fileResponse = uploadFileService.uploadFile(file);
//        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
//    }
}
