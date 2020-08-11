package com.fangchuang.haolinbao.controller;

import com.fangchuang.haolinbao.Util.MD5Util;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class text {
    private static String Url = "http://sms.51yixun.com:8200/sms/sendBatch";

    public static void main(String args[]){

            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(Url);

            //client.getParams().setContentCharset("GBK");
            client.getParams().setContentCharset("UTF-8");
            method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
            int code = (int) (Math.random() * (9999 - 1000 + 1)) + 100000;//产生6位随机数

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String inStr = "LHW-SMS-0RLPG" + "F6324B8F4C7CF9CE" + df.format(new Date());
            MD5Util md5Util = new MD5Util();
            try {
            String s = md5Util.MD5(inStr);
            //System.out.println(smsReqDTO.getBody().getUserPhone());
            NameValuePair[] data = {//提交短信
                    new NameValuePair("appId", "LHW-SMS-0RLPG"),
                    new NameValuePair("timestamp", df.format(new Date())),
                    new NameValuePair("sign", s),
                    new NameValuePair("mobiles", "15634900227"),
                    new NameValuePair("content", code+""),
                    new NameValuePair("schTime", null),
                    new NameValuePair("addserial", null),
                    new NameValuePair("batchId", "2")
            };

            method.setRequestBody(data);
           } catch (Exception e) {
                e.printStackTrace();
            }
            try {

            client.executeMethod(method);
            System.out.println(method.getResponseBodyAsString());
            //System.out.println(method.getResponseBodyAsStream());

            } catch (HttpException e) {
                 //TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
