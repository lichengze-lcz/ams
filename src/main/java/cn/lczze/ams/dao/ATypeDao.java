package cn.lczze.ams.dao;

import cn.lczze.ams.entity.AType;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lczze on 2021/3/5 12:32
 */
@Mapper
@Repository
public interface ATypeDao {

    //查寻list
   List<AType> findAll();

   //查寻  使用的 list
   List<AType> findAllByStatus();


   //模糊查询
   List<AType> searchList(AType aType);

   //模糊查询不太状态
   List<AType> searchNoSta(AType aType);

   //创建实体
   void creatType(AType aType);

   //根据id查类别
   AType findById(Long id);

   //更新实体
   void updateAtypeById(AType aType);

   //改变实体状态
   void changeStu(@Param("id") Long id ,@Param("Stu") Integer Stu);
}
