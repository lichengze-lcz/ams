package cn.lczze.ams.dao;

import cn.lczze.ams.entity.Role;
import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/4/19 15:27
 */
@Mapper
@Repository
public interface SysLogDao {

    void save(SysLog sysLog)throws Exception;


    List<SysLog> findAll() throws Exception;


    List<Role> findRName() throws Exception;

    UserInfo findUName(@Param("id") Long id);

    void updateRoleById(@Param("id") Long id,@Param("roleId")  Long roleId);

}
