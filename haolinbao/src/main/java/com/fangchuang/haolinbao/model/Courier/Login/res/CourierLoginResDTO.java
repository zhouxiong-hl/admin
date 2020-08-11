package com.fangchuang.haolinbao.model.Courier.Login.res;

import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierLoginResDTO {

    private CommonResHeaderDTO header;

    private CourierLoginResBodyDTO body;
}
