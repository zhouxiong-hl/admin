package com.fangchuang.haolinbao.model.Express.Insert.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertExpressReqBodyDTO {
    private String expressIdnumber;
    private String expressType;
    private String expressCourier;
    private String expressCabinetnumber;
    private String cabinetDrawersize;
    private String cabinetState;
    private String userPhone;

}
