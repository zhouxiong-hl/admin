package com.fangchuang.haolinbao.service;

import com.fangchuang.haolinbao.model.Cabinet.Select.req.SelectCabinetByReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.Select.res.SelectCabinetByResDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.req.SelectIdnumberReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res.SelectIdnumberResDTO;

import javax.servlet.http.HttpSession;

public interface CabinetService {
    /*
    20200806 zhao
    根据柜子格口大小查询格口
     */
    SelectCabinetByResDTO selectCabinetByService(SelectCabinetByReqDTO selectCabinetByReqDTO);
      /*
    20200808 zhao
    全查快递柜编码
     */
    SelectIdnumberResDTO selectAllService(SelectIdnumberReqDTO selectIdnumberReqDTO);
}
