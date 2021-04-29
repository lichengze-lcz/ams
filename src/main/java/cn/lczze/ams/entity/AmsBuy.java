package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/23 9:47
 */

@Data
public class AmsBuy {

    private Long id;
    private String amsName;
    private Long typeId;
    private Long supplierId;
    private Long brandId;
    private String buyReason;
    private Double budget;
    private Long resultStatus;

    private AType typeList;
    private Brand brandList;
    private Supplier supplierList;
}
