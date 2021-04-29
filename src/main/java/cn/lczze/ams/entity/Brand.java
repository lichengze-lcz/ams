package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/12 20:09
 */
@Data
public class Brand {

    private Long id;
    private String brandCode;
    private String brandName;
    private Integer brandStatus;
}
