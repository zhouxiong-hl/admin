package com.fangchuang.haolinbao.model.Express.Update.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExperssReqDTO {
    private CommonReqHeaderDTO header;

    private UpdateExperssReqBodyDTO body;
}
