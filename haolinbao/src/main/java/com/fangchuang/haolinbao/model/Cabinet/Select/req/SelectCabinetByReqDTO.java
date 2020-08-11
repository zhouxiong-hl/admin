package com.fangchuang.haolinbao.model.Cabinet.Select.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectCabinetByReqDTO {
    private CommonReqHeaderDTO header;
    private SelectCabinetByReqBodyDTO body;
}
