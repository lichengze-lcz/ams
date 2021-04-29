package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.LeaveAddressDao;
import cn.lczze.ams.entity.LeaveAddress;
import cn.lczze.ams.service.LeaveAddressService;
import cn.lczze.ams.service.LeaveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:36
 */
@Service
public class LeaveAddressImpl implements LeaveAddressService {

    @Autowired
    private LeaveAddressDao leaveAddressDao;

    @Override
    public List<LeaveAddress> findAll() {
           return leaveAddressDao.findAll();
    }

    @Override
    public List<LeaveAddress> findAllOfStatus() {
        return leaveAddressDao.findAllOfStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param
     * @return
     */
    @Override
    public List<LeaveAddress> search(LeaveAddress leaveAddress) {

        if (leaveAddress.getLeaveStatus() != null){
            List<LeaveAddress> LeaveAdd = leaveAddressDao.searchList(leaveAddress);
            return LeaveAdd;
        }else {
            List<LeaveAddress> LeaveAddresss = leaveAddressDao.searchNoSta(leaveAddress);
            return LeaveAddresss;
        }

    }


    @Override
    public void createLeaveAddress(LeaveAddress leaveAddress) {


        leaveAddressDao.creatLeaveAddress(leaveAddress);
    }


    @Override
    public LeaveAddress findById(Long id) {
        LeaveAddress byId = leaveAddressDao.findById(id);

        return byId;
    }

    @Override
    public void updateLeaveAddressById(LeaveAddress LeaveAddress) {

        leaveAddressDao.updateLeaveAddressById(LeaveAddress);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        LeaveAddress byId = leaveAddressDao.findById(id);
        //停用
        if (byId.getLeaveStatus().equals(1) && byId.getLeaveStatus() != null){
            leaveAddressDao.changeStu(id,0);
        //启用
        }else if(byId.getLeaveStatus().equals(0) && byId.getLeaveStatus() != null){
            leaveAddressDao.changeStu(id,1);
        }

    }


}
