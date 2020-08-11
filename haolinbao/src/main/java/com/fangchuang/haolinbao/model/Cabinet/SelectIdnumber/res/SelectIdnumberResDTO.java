package com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res;

import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectIdnumberResDTO {
    private CommonResHeaderDTO header;

    private SelectIdnumberResBodyDTO body;

}
