package com.fangchuang.haolinbao.model.Courier.Update.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourierReqDTO {
    private CommonReqHeaderDTO header;

    private UpdateCourierReqBodyDTO body;
}
