package com.fangchuang.haolinbao.service.impl;


import com.fangchuang.haolinbao.Util.MD5Util;
import com.fangchuang.haolinbao.entity.CourierEntity;
import com.fangchuang.haolinbao.mapper.CourierMapper;
import com.fangchuang.haolinbao.model.Courier.Insert.req.InsertCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Insert.res.InsertCourierResDTO;
import com.fangchuang.haolinbao.model.Courier.Login.req.CourierLoginReqDTO;
import com.fangchuang.haolinbao.model.Courier.Login.res.CourierLoginResBodyDTO;
import com.fangchuang.haolinbao.model.Courier.Login.res.CourierLoginResDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.req.CourierSMSReqDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.res.CourierSMSResDTO;
import com.fangchuang.haolinbao.model.Courier.Update.req.UpdateCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Update.res.UpdateCourierResDTO;
import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import com.fangchuang.haolinbao.service.CourierService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CourierServiceImpl implements CourierService {
    @Resource
    private CourierMapper courierMapper;

    /*
   20200805 zhao
   快递员终端登录
    */
    @Override
    public CourierLoginResDTO courierLoginService(CourierLoginReqDTO courierLoginReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("", "400", "登录失败");
        CourierLoginResDTO courierLoginResDTO = new CourierLoginResDTO();
        CourierLoginResBodyDTO courierLoginResBodyDTO = new CourierLoginResBodyDTO();
        Map<String, Object> courierMap = new HashMap<String, Object>();
        courierMap.put("courierPhone",courierLoginReqDTO.getBody().getCourierEntity().getCourierPhone());

        courierMap.put("courierPassword",courierLoginReqDTO.getBody().getCourierEntity().getCourierPassword());
        List<CourierEntity> courierEntities = courierMapper.courierLogin(courierMap);

        try{
            if(courierEntities==null||courierEntities.size()==0){
                header.setMessage("登录失败");
                header.setCode("400");
            }else{
                header.setMessage("登录成功");
                header.setCode("200");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        courierLoginResBodyDTO.setList(courierEntities);
        courierLoginResDTO.setHeader(header);
        courierLoginResDTO.setBody(courierLoginResBodyDTO);
        return courierLoginResDTO;
    }
    /*
   20200805 zhao
   快递员终端扫描快递单号
    */
    @Override
    public UpdateCourierResDTO shaomiaoExpressService(UpdateCourierReqDTO updateCourierReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","扫描快件失败");
        UpdateCourierResDTO updateCourierResDTO = new UpdateCourierResDTO();
        try{
            if(updateCourierReqDTO.getBody().getExpressIdnumber()==""||updateCourierReqDTO.getBody().getExpressIdnumber()==null){
                header.setCode("400");
                header.setMessage("扫描快件失败");
            }else {
                courierMapper.saomiaoExpress(updateCourierReqDTO.getBody().getExpressIdnumber());
                header.setCode("200");
                header.setMessage("扫描快件成功");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        updateCourierResDTO.setHeader(header);
        return updateCourierResDTO;
    }
    /*
    20200811 zhao
    快递员注册
    */
    @Override
    public InsertCourierResDTO insertCourierService(InsertCourierReqDTO insertCourierReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","注册失败");
        InsertCourierResDTO insertCourierResDTO = new InsertCourierResDTO();

        try{

            Map<String,Object> couriermap=new HashMap<String,Object>();
            couriermap.put("courierId", UUID.randomUUID().toString());
            couriermap.put("courierPhone",insertCourierReqDTO.getBody().getCourierEntity().getCourierPhone());
            couriermap.put("courierPassword",insertCourierReqDTO.getBody().getCourierEntity().getCourierPassword());
            courierMapper.insertCourier(couriermap);

        }catch(Exception e){
            e.printStackTrace();
        }
        insertCourierResDTO.setHeader(header);
        return insertCourierResDTO;
    }

    /*
   20200811 zhao
   快递员注册短信验证
   */
    @Override
    public CourierSMSResDTO CourierSMSService(CourierSMSReqDTO courierSMSReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","发送验证码失败");
        CourierSMSResDTO courierSMSResDTO = new CourierSMSResDTO();
        String Url = "http://sms.51yixun.com:8200/sms/sendBatch";

        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(Url);

            client.getParams().setContentCharset("UTF-8");
            method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
            int code = (int) (Math.random() * (9999 - 1000 + 1)) + 100000;//产生6位随机数

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String inStr = "LHW-SMS-0RLPG" + "F6324B8F4C7CF9CE" + df.format(new Date());
            MD5Util md5Util = new MD5Util();

            String s = md5Util.MD5(inStr);
            NameValuePair[] data = {//提交短信
                    new NameValuePair("appId", "LHW-SMS-0RLPG"),
                    new NameValuePair("timestamp", df.format(new Date())),
                    new NameValuePair("sign", s),
                    new NameValuePair("mobiles", courierSMSReqDTO.getBody().getCourierPhone()),
                    new NameValuePair("content", "【方仓智能柜】验证码：" + code + "您正在登录方仓智能柜手机账号（若非本人操作，请删除短信）"),
                    new NameValuePair("schTime", null),
                    new NameValuePair("addserial", null),
                    new NameValuePair("batchId", "2")
            };
            method.setRequestBody(data);

            client.executeMethod(method);
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = reader.readLine()) != null) {
                stringBuffer.append(str);
            }
            String html = stringBuffer.toString();
            System.out.println(html);
            if(html.equals("{\"code\":\"SUCCESS\",\"data\":0}")){
                header.setCode("200");
                header.setMessage("发送验证码成功");
                //将验证码存入数据库

                }else{
                header.setCode("200");
                header.setMessage("发送验证码失败");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        courierSMSResDTO.setHeader(header);
        return courierSMSResDTO;
    }
}
