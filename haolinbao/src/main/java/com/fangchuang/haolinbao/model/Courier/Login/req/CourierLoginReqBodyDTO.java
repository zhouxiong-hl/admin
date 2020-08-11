package com.fangchuang.haolinbao.model.Courier.Login.req;

import com.fangchuang.haolinbao.entity.CourierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierLoginReqBodyDTO {
    private CourierEntity courierEntity;

}
