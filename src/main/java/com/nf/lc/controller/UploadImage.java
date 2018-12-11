package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class UploadImage {

    /**
     * 上传头像
     * @return
     */
    @RequestMapping(value = "/upload/headerPortrait",method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result uploadHeaderPortrait(@RequestPart("file") MultipartFile multipartFile , HttpServletRequest req){
        String src = "";
        if(!multipartFile.isEmpty()){  //不能为空
            String contentType = multipartFile.getContentType();
            //效验为图片
            if(!contentType.contains("image/")){
                return Result.error("不是图片类型的文件，上传失败！");
            }

            //文件大小验证
            if(multipartFile.getSize() > 1024 * 1024 * 1024 * 5){
                return Result.error("文件太大，上传失败！");
            }

            //路径
            String savePath = req.getServletContext().getRealPath("");
            savePath = savePath +"images\\head_portrait\\";
            File file = new File(savePath);
            if(!file.exists()){
                file.mkdirs();
            }

            //图片名：upload_原名字_日期.后缀名
            String fileName = multipartFile.getOriginalFilename();
            String lastName = fileName.substring(fileName.lastIndexOf(".") , fileName.length());
            String newFileName = String.valueOf(UUID.randomUUID());
            String path = savePath+ newFileName + lastName;
            src = "/images/head_portrait/"+newFileName+lastName;

            try {
                multipartFile.transferTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
                return Result.error("上传失败！请重试！");
            }

        }else{
            return Result.error("未接收到文件信息，上传失败！");
        }
        return Result.success("上传成功！",src,0);
    }

}
