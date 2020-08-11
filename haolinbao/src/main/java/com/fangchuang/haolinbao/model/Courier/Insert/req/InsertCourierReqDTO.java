package com.fangchuang.haolinbao.model.Courier.Insert.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCourierReqDTO {
    private CommonReqHeaderDTO header;

    private InsertCourierReqBodyDTO body;
}
