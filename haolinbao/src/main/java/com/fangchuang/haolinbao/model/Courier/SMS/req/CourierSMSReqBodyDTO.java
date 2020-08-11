package com.fangchuang.haolinbao.model.Courier.SMS.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierSMSReqBodyDTO {
    private String courierPhone;

    private String courierPassword;
}
