package com.lizhi.controller.check;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.lizhi.domain.check.Check;
import com.lizhi.service.check.CheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckController {
    Logger logger = Logger.getLogger(CheckController.class);

    @Autowired
    CheckService checkService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }


    @RequestMapping(value = "/getCheckById/{id}", produces = {"text/html;charset=utf-8"})  //返回的是json对象
//    @RequestMapping(value = "/getCheckById/{id}",produces = {"application/json;charset=utf-8"}) //返回的是json字符串
    @ResponseBody
    public String getCheckById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        logger.info("请求id==>" + id);
        Check check = checkService.getCheckById(id);
        System.out.println(check);
        Map map = new HashMap();
        map.put("msg", "success");
        map.put("body", check);
        map.put("code", "200");
        logger.info("返回数据：" + JSON.toJSONString(map));
        return JSON.toJSONString(map); //中文会乱码，可以produces = {"text/html;charset=utf-8
    }

    @RequestMapping("transactionTest")
    @ResponseBody
    public int transactionTest(){
        List list = new ArrayList<Check>();
        Check check = new Check();
        check.setName("周瑜");
        list.add(check);
        check.setName("凤雏");
        list.add(check);
        check.setName("黄忠");
        list.add(check);
        return checkService.insertChecks(list);
    }
    @RequestMapping("htmlTest")
    public ModelAndView htmlTest(){
        logger.info("htmlTest===>");
        return new ModelAndView("check/check.html");
    }
}
