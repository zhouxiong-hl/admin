package com.fangchuang.haolinbao.model.common.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonReqHeaderDTO {

    private String transid;

    private String code;

    private String message;
}
