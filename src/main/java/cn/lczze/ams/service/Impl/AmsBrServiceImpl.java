package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.AWarehousingDao;
import cn.lczze.ams.dao.AmsBrDao;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.Amsbr;
import cn.lczze.ams.service.AmsBrService;
import cn.lczze.ams.until.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lczze on 2021/3/22 10:17
 */
@Service
public class AmsBrServiceImpl implements AmsBrService {

    @Autowired
    private AmsBrDao amsBrDao;

    @Autowired
    private AWarehousingDao aWarehousingDao;


    @Override
    public List<Amsbr> findAll() {

        List<Amsbr> brDaoAll = amsBrDao.findAll();
        String n;



        return brDaoAll;
    }

    @Override
    public List<Amsbr> findBySearch(String amsCode,String amsName,String typeName,String departmentName) {


        return  amsBrDao.findBySearch(amsCode,amsName,typeName,departmentName);
    }

    @Override
    public Amsbr findAllById(Long id) {
        return amsBrDao.findAllById(id);
    }

    /**
     * 添加资产借还
     * @param amsbr
     */
    @Override
    public void saveAmsBr(Amsbr amsbr) {

        AWarehousing ams = aWarehousingDao.findCodeByName(amsbr.getAmsName());

        amsbr.setBNum(DateUtils.getNewToday("JY"));
        amsbr.setBDate(new Date());
        amsbr.setTypeId(ams.getTypeId());
        amsbr.setAmsCode(ams.getAmsCode());
        amsBrDao.CreateAmsBr(amsbr);
        aWarehousingDao.updateAmsStatus("2",ams.getId());
    }

    @Override
    public void updateRDesc(String returnDesc,Integer id,Integer AmsId) {

        amsBrDao.createRDesc(returnDesc,new Date(),id);
        aWarehousingDao.updateAmsStatus("1",AmsId);
        amsBrDao.updateAmsBrStatus("1",id);
    }
}
