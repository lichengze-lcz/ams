package cn.lczze.ams.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by lczze on 2021/3/16 9:19
 */
@Data
public class AWarehousing {

    private Integer id;
    private String amsCode;
    private String amsName;

    private Integer typeId;
    private AType typeList;

    private Integer supplierId;
    private Supplier supplierList;

    private Integer brandId;
    private Brand brandList;

    private Date warehousingDate;

    private Integer leaveId;
    private LeaveAddress leaveAddressList;

    private String amsStatus;



}
