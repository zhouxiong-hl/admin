package com.fangchuang.haolinbao.service;


import com.fangchuang.haolinbao.model.Courier.SMS.req.CourierSMSReqDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.res.CourierSMSResDTO;
import com.fangchuang.haolinbao.model.Express.Insert.req.InsertExpressReqDTO;
import com.fangchuang.haolinbao.model.Express.Insert.res.InsertExpressResDTO;
import com.fangchuang.haolinbao.model.Express.Update.req.UpdateExperssReqDTO;
import com.fangchuang.haolinbao.model.Express.Update.res.UpdateExperssResDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.req.UserQuJianReqDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.res.UserQuJianResDTO;
import com.fangchuang.haolinbao.model.SMS.req.SMSReqDTO;
import com.fangchuang.haolinbao.model.SMS.res.SMSResDTO;


public interface ExpressService {

    /*
   20200806 zhao
   扫描快递编号
    */

    InsertExpressResDTO saomiaoExperssService(InsertExpressReqDTO insertExpressReqDTO);
     /*
   20200806 zhao
   短信验证
    */
     SMSResDTO smsCheckService(SMSReqDTO smsReqDTO);
       /*
    20200808 zhao
    用户通过取件码取件
     */
    UserQuJianResDTO userqujianService(UserQuJianReqDTO userQuJianReqDTO);



}
