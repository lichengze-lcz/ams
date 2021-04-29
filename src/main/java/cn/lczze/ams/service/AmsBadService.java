package cn.lczze.ams.service;

import cn.lczze.ams.entity.AmsBad;

import java.util.List;

/**
 * Created by lczze on 2021/3/24 9:47
 */
public interface AmsBadService {

    List<AmsBad> findAll();

    List<AmsBad> findAllS(String amsCode,String amsName,String badWay,String badReason);

    void saveAmsBad(AmsBad amsBad);

    void deleteBad(Long id);

    void chengeStatusById(Long id, Long status);
}
