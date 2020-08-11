package com.fangchuang.haolinbao.service;


import com.fangchuang.haolinbao.model.Courier.Insert.req.InsertCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Insert.res.InsertCourierResDTO;
import com.fangchuang.haolinbao.model.Courier.Login.req.CourierLoginReqDTO;
import com.fangchuang.haolinbao.model.Courier.Login.res.CourierLoginResDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.req.CourierSMSReqDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.res.CourierSMSResDTO;
import com.fangchuang.haolinbao.model.Courier.Update.req.UpdateCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Update.res.UpdateCourierResDTO;


public interface CourierService {

     /*
    20200805 zhao
    快递员终端登录
     */
    CourierLoginResDTO courierLoginService(CourierLoginReqDTO courierLoginReqDTO);
     /*
    20200805 zhao
    快递员终端扫描快递单号
     */
    UpdateCourierResDTO shaomiaoExpressService(UpdateCourierReqDTO updateCourierReqDTO);
     /*
     20200811 zhao
     快递员注册
     */
    InsertCourierResDTO insertCourierService(InsertCourierReqDTO insertCourierReqDTO);
    /*
    20200811 zhao
    快递员注册短信验证
    */
    CourierSMSResDTO CourierSMSService(CourierSMSReqDTO courierSMSReqDTO);
     /*
    20200811 zhao
    将验证码存入数据库
    */



}
