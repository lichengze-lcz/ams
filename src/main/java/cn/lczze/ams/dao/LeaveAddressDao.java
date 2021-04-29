package cn.lczze.ams.dao;

import cn.lczze.ams.entity.LeaveAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lczze on 2021/3/5 12:32
 */
@Mapper
@Repository
public interface LeaveAddressDao {

    //查询Lsit
   List<LeaveAddress> findAll();

   List<LeaveAddress> findAllOfStatus();

   //模糊查询
   List<LeaveAddress> searchList(LeaveAddress leaveaddress);

   List<LeaveAddress> searchNoSta(LeaveAddress leaveaddress);

   void creatLeaveAddress(LeaveAddress leaveaddress);

   //根据id查类别
   LeaveAddress findById(Long id);

   void updateLeaveAddressById(LeaveAddress leaveaddress);

   //改变状态
   void changeStu(@Param("id") Long id ,@Param("Stu") Integer Stu);
}
