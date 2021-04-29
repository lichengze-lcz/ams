package cn.lczze.ams.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by lczze on 2021/3/3 14:55
 */
@Data
public class UserInfo {

    private Long id;
    private String nickName;
    private String username;
    private String passward;
    private String sign;
    private String roleId;
    private String avatar;
    private String sex;
    private String email;
    private Long phoneNum;
    private Date createTime;

    private Role roleList;
}
