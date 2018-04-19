package com.connext.test.mongo.webapi;

import com.connext.test.mongo.entity.Grade;
import com.connext.test.mongo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/api/mongo")
public class GradeApi {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/findAll")
    public List<Grade> findAll(){
        return gradeService.findAll();
    }

    @PostMapping
    public Grade addGrade(@RequestBody Grade grade){
        return gradeService.addGrade(grade);
    }

    @GetMapping("/test")
    public String test(@RequestParam String data){
        return data;
    }

    public static void main(String[] args) throws Exception {

        // 将application/x-www-form-urlencoded字符串转换成普通字符串
        // 其中的字符串直接从上图所示窗口复制过来,chrome 默认用 UTF-8 字符集进行编码，所以也应该用对应的字符集解码
//        System.out.println("采用UTF-8字符集进行解码:");
//        String keyWord = URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "UTF-8");
//        System.out.println(keyWord);
//        System.out.println("\n 采用GBK字符集进行解码:");
//        System.out.println(URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "GBK"));

        // 将普通字符串转换成application/x-www-form-urlencoded字符串
        System.out.println("\n 采用utf-8字符集:");
        String urlStr = URLEncoder.encode("天津大学", "utf-8");
        System.out.println(urlStr);
        String test=URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6","UTF-8");
        System.out.println(test);
//        System.out.println("\n 采用GBK字符集:");
//        String urlStr2 = URLEncoder.encode("天津大学", "GBK");
//        System.out.println(urlStr2);
    }
}
