package com.cms.yxf.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String importExcel(MultipartFile file);
}
