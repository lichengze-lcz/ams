package cn.lczze.ams.service;

import cn.lczze.ams.entity.AmsBuy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/23 9:54
 */

public interface AmsBuyService {


    List<AmsBuy> findAll();

    List<AmsBuy> findAllByS(String amsName, String typeName,String supplierName,String branName,String buyReason);

    void saveAmsBuy(AmsBuy amsBuy);

    void deleteById(@Param("id") long id);

    void chengeStatusById(Long id,Long status);
}
