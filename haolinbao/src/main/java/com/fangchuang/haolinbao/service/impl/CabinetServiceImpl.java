package com.fangchuang.haolinbao.service.impl;

import com.fangchuang.haolinbao.entity.CabinetEntity;
import com.fangchuang.haolinbao.entity.ExpressEntity;
import com.fangchuang.haolinbao.mapper.CabinetMapper;
import com.fangchuang.haolinbao.model.Cabinet.Select.req.SelectCabinetByReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.Select.res.SelectCabinetByResBodyDTO;
import com.fangchuang.haolinbao.model.Cabinet.Select.res.SelectCabinetByResDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.req.SelectIdnumberReqDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res.SelectIdnumberResBodyDTO;
import com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res.SelectIdnumberResDTO;
import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import com.fangchuang.haolinbao.service.CabinetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class CabinetServiceImpl  implements CabinetService  {
    @Resource
    private CabinetMapper cabinetMapper;
    /*
   20200806 zhao
   根据柜子格口大小查询格口
    */
    @Override
    public SelectCabinetByResDTO selectCabinetByService(SelectCabinetByReqDTO selectCabinetByReqDTO) {

        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","查询失败");
        SelectCabinetByResDTO selectCabinetByResDTO = new SelectCabinetByResDTO();

        SelectCabinetByResBodyDTO selectCabinetByResBodyDTO = new SelectCabinetByResBodyDTO();
        try{
            Map<String, Object> cabinetMap = new HashMap<>();
            cabinetMap.put("cabinetDrawersize",selectCabinetByReqDTO.getBody().getCabinetDrawersize());
            cabinetMap.put("cabinetIdnumber",selectCabinetByReqDTO.getBody().getCabinetIdnumber());
            cabinetMap.put("cabinetState",selectCabinetByReqDTO.getBody().getCabinetIdnumber());
            CabinetEntity cabinetEntity = cabinetMapper.selectCabinetByType(cabinetMap);

            selectCabinetByResBodyDTO.setCabinetEntity(cabinetEntity);
            header.setCode("200");
            header.setMessage("查询成功");
        }catch(Exception e){
            e.printStackTrace();
        }

        selectCabinetByResDTO.setBody(selectCabinetByResBodyDTO);
        selectCabinetByResDTO.setHeader(header);

        return selectCabinetByResDTO;

    }
       /*
    20200808 zhao
    全查快递柜编码
     */
    @Override
    public SelectIdnumberResDTO selectAllService(SelectIdnumberReqDTO selectIdnumberReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","查询失败");
        SelectIdnumberResDTO selectIdnumberResDTO = new SelectIdnumberResDTO();
        SelectIdnumberResBodyDTO selectIdnumberResBodyDTO = new SelectIdnumberResBodyDTO();

        try{
            List<ExpressEntity> expressEntities = cabinetMapper.selectAll();
            selectIdnumberResBodyDTO.setList(expressEntities);
            header.setCode("200");
            header.setMessage("查询成功");
        }catch(Exception e){
            e.printStackTrace();
        }
        selectIdnumberResDTO.setHeader(header);
        selectIdnumberResDTO.setBody(selectIdnumberResBodyDTO);
        return selectIdnumberResDTO;
    }
}
