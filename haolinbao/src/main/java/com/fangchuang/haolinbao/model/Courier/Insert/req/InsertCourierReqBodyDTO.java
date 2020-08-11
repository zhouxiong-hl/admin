package com.fangchuang.haolinbao.model.Courier.Insert.req;

import com.fangchuang.haolinbao.entity.CourierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCourierReqBodyDTO {
    private CourierEntity courierEntity;
}
