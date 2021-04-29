package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/14 10:57
 */
@Data
public class Department {

    private Long id;
    private String departmentCode;
    private String departmentName;
    private Integer departmentStatus;
}
