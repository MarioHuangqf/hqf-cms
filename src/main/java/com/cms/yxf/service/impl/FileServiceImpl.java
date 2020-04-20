package com.cms.yxf.service.impl;

import com.cms.yxf.exception.APIException;
import com.cms.yxf.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService{

    @Value("${outPutFilePath}")
    private String filePath;

    /**
     * 导入Excel文件
     * @param file
     * @return
     */
    @Override
    public String importExcel(MultipartFile file) {
        // 验证文件
        if (null == file || file.isEmpty()) {
            throw new APIException("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        if (!checkFileSuffix(fileName)) {
            throw new APIException("仅支持.xlsx文件");
        }

        // 存储文件
        String fileId = saveFile(file);
        if (StringUtils.isEmpty(fileId)) {
            throw new APIException("保存文件失败");
        }

        // 保存数记录到数据库

        // 生产一条导入消息


        return null;
    }

    /**
     * 校验文件格式
     * @param fileName
     * @return
     */
    private boolean checkFileSuffix(String fileName) {
        if (StringUtils.isEmpty(fileName) || fileName.lastIndexOf(".") <= 0) {
            return false;
        }

        int lastPointIndex = fileName.lastIndexOf(".");
        String suffix = fileName.substring(lastPointIndex, fileName.length()).toLowerCase();
        if (".xlsx".equals(suffix)) {
            return true;
        }

        return false;
    }

    /**
     * 保存文件
     * @param file
     * @return
     */
    private String saveFile(MultipartFile file) {

        // 按日期创建目录
        String path = filePath + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File filePath = new File(path + "/" + file.getOriginalFilename());
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        //写出文件
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new APIException(e.getMessage());
        }

        return filePath.toString();
    }
}
