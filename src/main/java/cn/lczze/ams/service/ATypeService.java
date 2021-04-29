package cn.lczze.ams.service;

import cn.lczze.ams.entity.AType;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:35
 */
public interface ATypeService {
    List<AType> findAll();

    List<AType> findAllByStatus();

    List<AType> search(AType aType);

    void createAType(String typeCode, String typeName);

    AType findById(Long id);

    void updateATypeById(AType aType);

    void changeStuById(Long id);

}
