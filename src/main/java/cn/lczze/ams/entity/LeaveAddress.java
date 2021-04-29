package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/14 21:30
 */
@Data
public class LeaveAddress {

    private Long id;
    private String leaveName;
    private String leaveType;
    private String leaveExplain;
    private Integer leaveStatus;
}
