package com.hzit.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/goods")
public class UploadImageController {
    /**
     * 文件上传数据中心
     */
    @Value("${oss.endpoint}")
    private String endPoint;
    /**
     * oss账号
     */
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    /**
     * oss密码
     */
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;


    /**
     * 上传会员头像文件
     * @return
     */
    @PostMapping("/uploadAvatar")
    public ServerResponse<String> uploadImage(@RequestParam("avatar") MultipartFile avatar){
       // myImages.getInputStream();//获取到输入流
        if(avatar== null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        String fileName = null;
        try {
            OSSClient client = new OSSClient("http://"+endPoint,
                    accessKeyId,
                    accessKeySecret);
            // 上传文件
            fileName = UUID.randomUUID().toString()+ avatar.getOriginalFilename();
            PutObjectResult result = client.putObject("hitao-images",fileName,avatar.getInputStream());
            //System.out.println(result.getETag());
            //System.out.println(result.getResponse()); // 获取响应结果
            //  "https://你的BucketName.你的Endpoint/自定义路径/" + fileName;
            String url = "https://bucketName.endPoint/fileName";
            url =url.replace("bucketName","hitao-images");
            url =url.replace("endPoint",endPoint);
            url = url.replace("fileName",fileName);
            return ServerResponse.createBySuccess("图片上传成功!",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("文件上传失败！");
        }
    }
    
    @PostMapping("/uploadIconImages")
    public ServerResponse<String> uploadIconImages(@RequestParam("iconImages") MultipartFile iconImages){
       // myImages.getInputStream();//获取到输入流
        if(iconImages== null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        String fileName = null;
        try {
            OSSClient client = new OSSClient("http://"+endPoint,
                    accessKeyId,
                    accessKeySecret);
            // 上传文件
            fileName = UUID.randomUUID().toString()+ iconImages.getOriginalFilename();
            PutObjectResult result = client.putObject("hitao-images",fileName,iconImages.getInputStream());
            System.out.println(result.getETag());
            System.out.println(result.getResponse()); // 获取响应结果
            //  "https://你的BucketName.你的Endpoint/自定义路径/" + fileName;
            String url = "https://bucketName.endPoint/fileName";
            url =url.replace("bucketName","hitao-images");
            url =url.replace("endPoint",endPoint);
            url = url.replace("fileName",fileName);
            return ServerResponse.createBySuccess("图片上传成功!",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("文件上传失败！");
        }
    }
}
