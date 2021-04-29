package cn.lczze.ams.service;

import cn.lczze.ams.entity.Amsbr;

import java.util.List;

/**
 * Created by lczze on 2021/3/22 10:16
 */
public interface AmsBrService {

    List<Amsbr> findAll();

    List<Amsbr> findBySearch(String amsCode,String amsName,String typeName,String departmentName);

    Amsbr findAllById(Long id);

    void saveAmsBr(Amsbr amsbr);

    void updateRDesc(String returnDesc,Integer id,Integer amsId);
}
