package cn.lczze.ams.dao;


import cn.lczze.ams.entity.BadWay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/14 9:09
 */
@Mapper
@Repository
public interface BadWayDao {

    //查寻list
    List<BadWay> findAll();

    List<BadWay> findAllByStatus();

    //模糊查询
    List<BadWay> searchList(BadWay badWay);

    //模糊查询不太状态
    List<BadWay> searchNoSta(BadWay badWay);

    //创建实体
    void creatBadWay(BadWay badWay);

    //根据id查类别
    BadWay findById(Long id);

    //更新实体
    void updateBadWayById(BadWay badWay);

    //改变实体状态
    void changeStu(@Param("id") Long id , @Param("Stu") Integer Stu);
}
