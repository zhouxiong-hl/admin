package com.fangchuang.haolinbao.model.Cabinet.SelectIdnumber.res;

import com.fangchuang.haolinbao.entity.ExpressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectIdnumberResBodyDTO {

    List<ExpressEntity> list;
}
