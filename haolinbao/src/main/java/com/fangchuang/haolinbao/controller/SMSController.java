package com.fangchuang.haolinbao.controller;


import com.fangchuang.haolinbao.Util.MD5Util;
import com.fangchuang.haolinbao.model.SMS.req.SMSReqDTO;
import com.fangchuang.haolinbao.model.SMS.res.SMSResDTO;
import com.fangchuang.haolinbao.service.ExpressService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//短信验证
@CrossOrigin
@RequestMapping("/SMSController")
@RestController
public  class SMSController {
    @Resource
    private ExpressService expressService;
    @PostMapping("/sms")
    /*
    * 20200810 zhao
    * 发送验证码给用户
    * */
   private   SMSResDTO smsResDTO(@RequestBody SMSReqDTO smsReqDTO) {

        return expressService.smsCheckService(smsReqDTO);
    }


}
