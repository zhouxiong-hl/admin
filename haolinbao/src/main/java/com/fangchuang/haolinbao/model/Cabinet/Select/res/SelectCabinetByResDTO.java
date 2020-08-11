package com.fangchuang.haolinbao.model.Cabinet.Select.res;

import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectCabinetByResDTO {
    private CommonResHeaderDTO header;
    private SelectCabinetByResBodyDTO body;
}
