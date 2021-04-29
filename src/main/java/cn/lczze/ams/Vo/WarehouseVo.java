package cn.lczze.ams.Vo;

import cn.lczze.ams.entity.AType;
import cn.lczze.ams.entity.Brand;
import cn.lczze.ams.entity.LeaveAddress;
import cn.lczze.ams.entity.Supplier;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lczze on 2021/3/16 15:29
 */
@Data
public class WarehouseVo {

    private Integer id;
    private String amsCode;
    private String amsName;


    private Date warehousingDate;
    private String amsStatus;

    private String typeName;
    private String supplierName;
    private String brandName;
    private String leaveName;


    private AType type;
    private Integer typeId;
    private Integer supplierId;
    private Integer brandId;
    private Integer leaveId;


}
