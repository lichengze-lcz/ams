package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.ATypeDao;
import cn.lczze.ams.entity.AType;
import cn.lczze.ams.service.ATypeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:36
 */

@Service
public class ATypeServiceImpl implements ATypeService {

    @Autowired
    private ATypeDao aTypeDao;

    @Override
    public List<AType> findAll() {
           return aTypeDao.findAll();
    }

    @Override
    public List<AType> findAllByStatus() {
        return aTypeDao.findAllByStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param aType
     * @return
     */
    @Override
    public List<AType> search(AType aType) {

        if (aType.getTypeStatus() != null){
            List<AType> aTypes = aTypeDao.searchList(aType);
            return aTypes;
        }else {
            List<AType> aTypes = aTypeDao.searchNoSta(aType);
            return aTypes;
        }

    }


    @Override
    public void createAType(String typeCode, String typeName) {
        AType aType = new AType();
        aType.setTypeCode(typeCode);
        aType.setTypeName(typeName);
        aTypeDao.creatType(aType);
    }


    @Override
    public AType findById(Long id) {
        AType byId = aTypeDao.findById(id);

        return byId;
    }

    @Override
    public void updateATypeById(AType aType) {

        aTypeDao.updateAtypeById(aType);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        AType byId = aTypeDao.findById(id);
        //停用类别
        if (byId.getTypeStatus().equals(1) && byId.getTypeStatus() != null){
            aTypeDao.changeStu(id,0);
        //启用类别
        }else if(byId.getTypeStatus().equals(0) && byId.getTypeStatus() != null){
            aTypeDao.changeStu(id,1);
        }

    }


}
