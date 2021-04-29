package cn.lczze.ams.service;


import cn.lczze.ams.entity.Role;
import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.entity.UserInfo;

import java.util.List;

//AOP日志 业务层
public interface ISysLogService {


    void save(SysLog sysLog) throws Exception;


    List<SysLog> findAll() throws Exception;

    List<UserInfo>  findRole();

    List<Role> findRANme() throws Exception;

    UserInfo findUName(Long id);

    void updateRoleById(Long id, Long roleId);
}
