package cn.lczze.ams.dao;

import cn.lczze.ams.entity.AType;
import cn.lczze.ams.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lczze on 2021/3/5 12:32
 */
@Mapper
@Repository
public interface BrandDao {

    //查询Lsit
   List<Brand> findAll();

   List<Brand> findAllOfStatus();

   //模糊查询
   List<Brand> searchList(Brand brand);

   List<Brand> searchNoSta(Brand brand);

   void creatBrand(Brand brand);

   //根据id查类别
   Brand findById(Long id);

   void updateBrandById(Brand brand);

   //改变状态
   void changeStu(@Param("id") Long id ,@Param("Stu") Integer Stu);
}
