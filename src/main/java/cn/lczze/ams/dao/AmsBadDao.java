package cn.lczze.ams.dao;

import cn.lczze.ams.entity.AmsBad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/24 9:48
 */
@Mapper
@Repository
public interface AmsBadDao {

    List<AmsBad> findAll();

    List<AmsBad> findAllByS(@Param("amsCode")String amsCode,@Param("amsName")String amsName,@Param("badWay")String badWay,@Param("badReason")String badReason);

    void CreateAmsBad(AmsBad amsBad);

    void deleteBad(Long id);

    void chengeStatusById(@Param("id") Long id, @Param("status") Long status);

    AmsBad findNameById(Long id);
}
