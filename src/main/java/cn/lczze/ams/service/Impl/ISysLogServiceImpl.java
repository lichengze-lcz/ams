package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.SysLogDao;
import cn.lczze.ams.dao.UserInfoDao;
import cn.lczze.ams.entity.Role;
import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.entity.UserInfo;
import cn.lczze.ams.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//AOP日志 业务层接口
@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Autowired
    private UserInfoDao userDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public List<UserInfo> findRole() {
        return userDao.findRole();
    }

    @Override
    public List<Role> findRANme()  throws Exception{
        return sysLogDao.findRName();
    }

    @Override
    public UserInfo findUName(Long id) {
        return sysLogDao.findUName(id);
    }

    @Override
    public void updateRoleById(Long id, Long roleId) {
        if (id != null && roleId != null){
            sysLogDao.updateRoleById(id,roleId);
        }
    }

}
