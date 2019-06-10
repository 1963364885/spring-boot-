package com.controller;


import com.pojo.file;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/aop")
public class FileController {
    @RequestMapping(value = "/fileUpload",method= RequestMethod.POST)
    @ResponseBody
    public void fileUpload(MultipartFile file) {
        String  fileName = file.getOriginalFilename();
        String path = "F:/upload";//保存路径
        File dest = new File(path + "/" + fileName);
        try {
            //保存文件
            file.transferTo(dest);
            System.out.println("文件上传成功");
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }

}


