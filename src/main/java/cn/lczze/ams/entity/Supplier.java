package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/14 15:44
 */
@Data
public class Supplier {

    private Long id;
    private String supplierName;
    private String supplierType;
    private String liaisonMan;
    private String liaisonNum;
    private String address;
    private Integer supplierStatus;
}
