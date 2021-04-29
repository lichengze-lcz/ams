package cn.lczze.ams.dao;

import cn.lczze.ams.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/14 15:53
 */
@Mapper
@Repository
public interface SupplierDao {


    //查询Lsit
    List<Supplier> findAll();

    List<Supplier> findAllOfStatus();



    //模糊查询
    List<Supplier> searchList(Supplier supplier);

    List<Supplier> searchNoSta(Supplier supplier);

    void creatSupplier(Supplier supplier);

    //根据id查类别
    Supplier findById(Long id);

    void updateSupplierById(Supplier supplier);

    //改变状态
    void changeStu(@Param("id") Long id , @Param("Stu") Integer Stu);

}
