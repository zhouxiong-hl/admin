package com.fangchuang.haolinbao.model.Courier.SMS.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierSMSReqDTO {
    private CommonReqHeaderDTO header;

    private CourierSMSReqBodyDTO body;
}
