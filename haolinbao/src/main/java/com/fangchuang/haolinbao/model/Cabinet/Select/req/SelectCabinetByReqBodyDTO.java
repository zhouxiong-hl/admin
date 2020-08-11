package com.fangchuang.haolinbao.model.Cabinet.Select.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectCabinetByReqBodyDTO {
    private String cabinetDrawersize;
    private String cabinetIdnumber;
    private int cabinetState;
}
