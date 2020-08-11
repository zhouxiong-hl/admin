package com.fangchuang.haolinbao.model.Express.Insert.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertExpressReqDTO {
    private CommonReqHeaderDTO header;
    private InsertExpressReqBodyDTO body;
}
