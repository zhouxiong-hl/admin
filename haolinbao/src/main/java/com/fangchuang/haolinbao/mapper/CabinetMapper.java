package com.fangchuang.haolinbao.mapper;

import com.fangchuang.haolinbao.entity.CabinetEntity;
import com.fangchuang.haolinbao.entity.ExpressEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CabinetMapper {
    /*
    20200806 zhao
    根据柜子格口大小查询格口
     */
    CabinetEntity selectCabinetByType(Map<String,Object> map);
    /*
    20200808 zhao
    全查快递柜编码
     */
    List<ExpressEntity> selectAll();

}
