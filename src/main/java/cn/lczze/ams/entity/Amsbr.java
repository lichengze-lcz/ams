package cn.lczze.ams.entity;

import cn.lczze.ams.Vo.WarehouseVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by lczze on 2021/3/22 10:03
 */
@Data
public class Amsbr {

    private long id;
    private String bNum;
    private String amsCode;
    private String amsName;
    private Integer typeId;
    private Integer departmentId;
    private String bReason;
    private String returnDesc;
    private Integer brStatus;

    private Date bDate;
    private Date rDate;

    private AType typeList;
    private Department deptList;

}
