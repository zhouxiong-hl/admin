package com.fangchuang.haolinbao.controller;

import com.fangchuang.haolinbao.model.Express.Insert.req.InsertExpressReqDTO;
import com.fangchuang.haolinbao.model.Express.Insert.res.InsertExpressResDTO;
import com.fangchuang.haolinbao.model.Express.Update.req.UpdateExperssReqDTO;
import com.fangchuang.haolinbao.model.Express.Update.res.UpdateExperssResDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.req.UserQuJianReqDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.res.UserQuJianResDTO;
import com.fangchuang.haolinbao.model.SMS.req.SMSReqDTO;
import com.fangchuang.haolinbao.model.SMS.res.SMSResDTO;
import com.fangchuang.haolinbao.service.ExpressService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("/experssController")
@RestController
public class ExperssController {
    @Resource
    private ExpressService experssService;

    /*
    20200806 zhao
    扫描快递编号
     */
    @RequestMapping("/paijian")
    InsertExpressResDTO insertExpressResDTO(@RequestBody InsertExpressReqDTO insertExpressReqDTO){
        return experssService.saomiaoExperssService(insertExpressReqDTO);
    }
      /*
    20200808 zhao
    用户通过取件码取件
     */
      @RequestMapping("/qujian")
      UserQuJianResDTO userQuJianResDTO(@RequestBody UserQuJianReqDTO userQuJianReqDTO){
          return experssService.userqujianService(userQuJianReqDTO);
      }


}
