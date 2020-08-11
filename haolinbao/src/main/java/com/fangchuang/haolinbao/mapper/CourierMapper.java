package com.fangchuang.haolinbao.mapper;

import com.fangchuang.haolinbao.entity.CourierEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourierMapper {
    /*
    20200805 zhao
    快递员终端登录
     */
    List<CourierEntity> courierLogin(Map<String ,Object> map);
     /*
    20200805 zhao
    快递员终端扫描快递单号
     */
     void saomiaoExpress(String expressidnumber);
      /*
     20200811 zhao
     快递员注册
     */
      void insertCourier(Map<String,Object> map);
       /*
     20200811 zhao
     验证快递员code
     */
    CourierEntity yanzhenCourierCode(Map<String,Object> map);

}
