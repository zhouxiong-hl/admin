package com.fangchuang.haolinbao.model.Courier.Login.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierLoginReqDTO {
    private CommonReqHeaderDTO header;

    private CourierLoginReqBodyDTO body;
}
