package com.situ.springboot.controller;

import com.situ.springboot.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    //MultipartFile file封装了所有图片上传信息
    @RequestMapping("/uploadImage")
    @ResponseBody
    public Result uploadImage(MultipartFile file) {
        //f7a9f3e6805a4e81b5d27245c6c30070
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // a.png
        String filename = file.getOriginalFilename();
        // .png
        String extension = filename.substring(filename.lastIndexOf("."));
        // f7a9f3e6805a4e81b5d27245c6c30070.png
        String newFilename = uuid + extension;
        String filePath = "D:\\myPicture\\" + newFilename;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.ok("上传成功", newFilename);
    }
}