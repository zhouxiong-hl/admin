package com.fangchuang.haolinbao.model.SMS.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SMSReqBodyDTO {
    private String userPhone;

    private String cabinetAddress;

    private String courierPhone;

    private String expressIdnumber;
}
