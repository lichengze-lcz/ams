package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.AWarehousingDao;
import cn.lczze.ams.dao.AmsBadDao;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.AmsBad;
import cn.lczze.ams.service.AWarehousingService;
import cn.lczze.ams.service.AmsBadService;
import cn.lczze.ams.until.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lczze on 2021/3/24 9:47
 */

@Service
public class AmsBadServiceImpl implements AmsBadService {


    @Autowired
    private AmsBadDao amsBadDao;

    @Autowired
    private AWarehousingDao aWarehousingDao;

    @Override
    public List<AmsBad> findAll() {
        return amsBadDao.findAll();
    }

    @Override
    public List<AmsBad> findAllS(String amsCode,String amsName,String badWay,String badReason) {
        return amsBadDao.findAllByS(amsCode,amsName,badWay,badReason);
    }

    @Override
    public void saveAmsBad(AmsBad amsBad) {
        AWarehousing ams = aWarehousingDao.findCodeByName(amsBad.getAmsName());
        amsBad.setAmsCode(ams.getAmsCode());
        amsBad.setBadDate(new Date());
        //报废待审批
        aWarehousingDao.updateAmsStatus("3",ams.getId());
        amsBadDao.CreateAmsBad(amsBad);
    }
    @Override
    public void deleteBad(Long id) {
        amsBadDao.deleteBad(id);
    }

    /**
     *
     * @param id
     * @param status
     */
    @Override
    public void chengeStatusById(Long id, Long status) {
        //报废表改变 资产状态
        amsBadDao.chengeStatusById(id,status);
        //通过id  查询bad表所有
        AmsBad nameById = amsBadDao.findNameById(id);
        //两个表的 资产名字相同  查询 入库表的该资产的id
        AWarehousing ams = aWarehousingDao.findCodeByName(nameById.getAmsName());
        //拒绝报废
        if (status != null && status == 2){

            aWarehousingDao.updateAmsStatus("1",ams.getId());
        }
        //报废
        if (status != null && status == 1){
            aWarehousingDao.updateAmsStatus("4",ams.getId());
        }

    }
}
