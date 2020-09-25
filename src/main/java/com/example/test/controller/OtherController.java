package com.example.test.controller;
import com.example.test.bean.Manages;
import com.example.test.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OtherController {

    @Autowired
    ManageService manageService;

    @RequestMapping(value = "/uploadimg1", produces = {"text/html;charset=UTF-8;"})
    @ResponseBody
    public String uploadimg1(@Param("path")String path, @RequestParam("file") CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {
        // 获取当前项目的路径
        String serverPath = request.getSession().getServletContext().getRealPath("/");
        try {
            // 格式化日期月日小时分钟秒
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
            Date d = new Date();
            String s = sdf.format(d);
            // 这个路径是新的文件
            String path1 = serverPath +"/img/"+path+ s + ".png";
            File newFile1 = new File(path1);
            // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile1);

            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, Object> map2 = new HashMap<String, Object>();
            map.put("code", 0);//0表示成功，1失败
            map.put("msg", "上传成功");//提示消息
            map.put("data", map2);
            map2.put("src", path1);//图片url
            map2.put("title", s + ".png");//图片名称，这个会显示在输入框里
            String result = new JSONObject(map).toString();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"code\",\"1\"}";
    }

    //上传解疑图片
    @RequestMapping("/update_solving_doubts")
    public String update_solving_doubts(Manages manages){
        try {
            manageService.updateImgPath(manages);
            return "1";
        }
        catch(Exception e){
               e.printStackTrace();
               return "0";
            }
    }

}