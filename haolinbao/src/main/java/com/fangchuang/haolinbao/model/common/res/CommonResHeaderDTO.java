package com.fangchuang.haolinbao.model.common.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResHeaderDTO {

    private String transid;

    private String code;

    private String message;
}
