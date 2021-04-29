package cn.lczze.ams.service;

import cn.lczze.ams.entity.LeaveAddress;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:35
 */
public interface LeaveAddressService {
    List<LeaveAddress> findAll();

    List<LeaveAddress> findAllOfStatus();

    List<LeaveAddress> search(LeaveAddress leaveAddress);

    void createLeaveAddress(LeaveAddress leaveAddress);

    LeaveAddress findById(Long id);

    void updateLeaveAddressById(LeaveAddress leaveAddress);

    void changeStuById(Long id);

}
