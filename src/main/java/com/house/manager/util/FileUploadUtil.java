package com.house.manager.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Create 2020-02-05 0:17
 */
@Configuration
public class FileUploadUtil {

    private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 生成随机唯一文件名
     * @return
     */
    public static String getRandomFileName(){
        String dateString = dateTimeFormatter.format(new Date());
        return UUID.randomUUID().toString().replace("-", "") + dateString;
    }

    private static String filePath;

    @Value("${file.upload.filepath}")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 保存文件、图片
     * @param file
     */
    public static String saveFile(MultipartFile file){

        if(file.isEmpty()){
            throw new RuntimeException("图片为空");
        }

        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = getRandomFileName() + suffixName;
//        String filePath = "D:\\houseManage\\upload\\image\\";
        System.out.println(filePath);
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            file.transferTo(new File(filePath + fileName));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return "/images/" + fileName;
    }

    public static void main(String[] args) {

        System.out.println(new FileUploadUtil().filePath);
    }

}
