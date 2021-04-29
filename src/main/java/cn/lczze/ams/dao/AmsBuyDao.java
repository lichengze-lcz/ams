package cn.lczze.ams.dao;

import cn.lczze.ams.entity.AmsBuy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/23 9:55
 */
@Repository
@Mapper
public interface AmsBuyDao {

     List<AmsBuy> findAll();

    List<AmsBuy> findAllByS(@Param("amsName")String amsName,@Param("typeName")String typeName,@Param("supplierName")String supplierName,@Param("branName")String branName,@Param("buyReason")String buyReason);

    void createAmsBuy(AmsBuy amsBuy);

    void deleteById(long id);

    void chengeStatusById(@Param("id") Long id,@Param("status") Long status);

}
