package com.fangchuang.haolinbao.controller;

import com.fangchuang.haolinbao.model.Courier.Insert.req.InsertCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Insert.res.InsertCourierResDTO;
import com.fangchuang.haolinbao.model.Courier.Login.req.CourierLoginReqDTO;
import com.fangchuang.haolinbao.model.Courier.Login.res.CourierLoginResDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.req.CourierSMSReqDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.res.CourierSMSResDTO;
import com.fangchuang.haolinbao.model.Courier.Update.req.UpdateCourierReqDTO;
import com.fangchuang.haolinbao.model.Courier.Update.res.UpdateCourierResDTO;
import com.fangchuang.haolinbao.service.CourierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("/courierController")
@RestController
public class CourierController {
    @Resource
    private CourierService courierService;
      /*
   20200805 zhao
   快递员终端登录
    */
      @RequestMapping("/courierLogin")
    private CourierLoginResDTO courierLoginResDTO(@RequestBody CourierLoginReqDTO courierLoginReqDTO){
          return courierService.courierLoginService(courierLoginReqDTO);
      }
       /*
   20200805 zhao
   快递员终端扫描快递单号
    */
       @RequestMapping("/saomiaoExpress")
       private UpdateCourierResDTO updateCourierResDTO(@RequestBody UpdateCourierReqDTO updateCourierReqDTO){
           return courierService.shaomiaoExpressService(updateCourierReqDTO);
       }
        /*
     20200811 zhao
     快递员注册
     */
        @RequestMapping("/zhuceCourier")
        private InsertCourierResDTO insertCourierResDTO(@RequestBody InsertCourierReqDTO insertCourierReqDTO){
            return courierService.insertCourierService(insertCourierReqDTO);
        }
        /*
     20200811 zhao
     快递员发送验证码
     */
        private CourierSMSResDTO courierSMSResDTO(@RequestBody CourierSMSReqDTO courierSMSReqDTO){
            return courierService.CourierSMSService(courierSMSReqDTO);
        }
}
