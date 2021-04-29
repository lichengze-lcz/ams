package cn.lczze.ams.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by lczze on 2021/3/24 9:44
 */

@Data
public class AmsBad {

    private Long id;
    private String amsCode;
    private String amsName;
    private String badWay;
    private Date badDate;
    private String badReason;
    private Long badStatus;
}
