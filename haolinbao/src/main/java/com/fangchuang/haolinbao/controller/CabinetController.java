package com.fangchuang.haolinbao.controller;

import com.fangchuang.haolinbao.model.Cabinet.Select.req.SelectCabinetByReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.Select.res.SelectCabinetByResDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.req.SelectIdnumberReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res.SelectIdnumberResDTO;
import com.fangchuang.haolinbao.model.Courier.Login.req.CourierLoginReqDTO;
import com.fangchuang.haolinbao.model.Courier.Login.res.CourierLoginResDTO;
import com.fangchuang.haolinbao.service.CabinetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("/CabinetController")
@RestController
public class CabinetController {
    @Resource
    private CabinetService cabinetService;
     /*
   20200806 zhao
   根据柜子格口大小查询格口
    */
     @RequestMapping("/selectCabinetBy")
     SelectCabinetByResDTO selectCabinetByResDTO(@RequestBody SelectCabinetByReqDTO selectCabinetByReqDTO){
         return cabinetService.selectCabinetByService(selectCabinetByReqDTO);
     }
         /*
    20200808 zhao
    全查快递柜编码
     */
    @RequestMapping("/selectCabinetAll")
    SelectIdnumberResDTO selectIdnumberResDTO(@RequestBody SelectIdnumberReqDTO selectIdnumberReqDTO){
        return cabinetService.selectAllService(selectIdnumberReqDTO);
    }
}
