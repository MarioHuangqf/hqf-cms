package com.cms.yxf.controller.resource;

import com.cms.yxf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 导入Excel文件
     * @param file
     * @return
     */
    @PostMapping("/importExcel")
    public String importExcel(@RequestParam("file")MultipartFile file) {

        return fileService.importExcel(file);
    }
}
