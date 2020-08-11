package com.fangchuang.haolinbao.model.Express.UserQuJian.req;

import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuJianReqDTO {
    private CommonReqHeaderDTO header;

    private UserQuJianReqBodyDTO body;
}
