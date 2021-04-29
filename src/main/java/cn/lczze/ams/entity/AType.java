package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/5 12:34    资产类别实体类
 */
@Data
public class AType {

    private Long id;
    private String typeCode;
    private String typeName;
    private Integer typeStatus;

    public AType() {
    }

    public AType(Long id, String typeCode, String typeName, Integer typeStatus) {
        this.id = id;
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.typeStatus = typeStatus;
    }
}
