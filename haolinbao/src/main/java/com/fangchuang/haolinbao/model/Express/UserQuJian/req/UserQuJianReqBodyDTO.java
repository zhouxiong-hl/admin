package com.fangchuang.haolinbao.model.Express.UserQuJian.req;

import com.fangchuang.haolinbao.model.Express.Update.req.UpdateExperssReqBodyDTO;
import com.fangchuang.haolinbao.model.common.req.CommonReqHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuJianReqBodyDTO {

    private String expressSms;

    private String cabinetIdnumber;
}
