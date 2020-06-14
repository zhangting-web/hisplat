package com.mh.hisplat.controller;

import com.mh.hisplat.entry.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private Response response;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd");
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public Response upload(MultipartFile file , HttpServletRequest request) throws IOException {
        //设计上传文件的地址
        String s = simpleDateFormat.format(new Date());
        String path = request.getServletContext().getRealPath("/uploads")+s;
        log.warn("文件保存路径："+path);
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //上传文件的名称+类型
        String oldName = file.getOriginalFilename();
        String name = UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(f,name));
        path = "/uploads"+s+"/"+name;
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        //返回上传文件保存的地址

        Map resultMap = new HashMap();
        resultMap.put("path",path);
        resultMap.put("url",url);
        return response.success("上传成功",resultMap);
    }
}
