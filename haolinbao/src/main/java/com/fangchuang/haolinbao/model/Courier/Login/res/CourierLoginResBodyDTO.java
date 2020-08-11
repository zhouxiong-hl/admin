package com.fangchuang.haolinbao.model.Courier.Login.res;

import com.fangchuang.haolinbao.entity.CourierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierLoginResBodyDTO {
    List<CourierEntity> list;
}
