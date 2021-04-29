package cn.lczze.ams.entity;

import lombok.Data;

/**
 * Created by lczze on 2021/3/14 9:13
 */
@Data
public class BadWay {

    private Long id;
    private String badWayCode;
    private String badWayName;
    private Integer badWayStatus;
}
