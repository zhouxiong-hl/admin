package com.fangchuang.haolinbao.mapper;

import com.fangchuang.haolinbao.entity.ExpressEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ExpressMapper {
    /*
    20200806 zhao
    扫描快递编号
     */
    void saomiaoExpress(Map<String,Object> map);
     /*
    20200808 zhao
    将短信验证码存入数据库
     */
     void updateSMS(Map<String,Object> map);
      /*
    20200808 zhao
    用户通过取件码取件
     */
      ExpressEntity SelectExpressSmsCode(Map<String,Object> map);
    /*  20200808 zhao
    用户成功取件后修改endtime并5分钟后删除
    */
    void updateExpress(Map<String,Object> map);
    void deleteRxpress(Map<String,Object> map);



}
