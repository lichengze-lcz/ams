package cn.lczze.ams.service.Impl;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.dao.AWarehousingDao;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.Brand;
import cn.lczze.ams.service.AWarehousingService;
import cn.lczze.ams.until.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lczze on 2021/3/16 15:41
 */

@Service
public class AWarehousingServiceImpl implements AWarehousingService {

    @Autowired
    private AWarehousingDao warehousingDao;

    @Override
    public List<WarehouseVo> findAll() {
        List<WarehouseVo> aHouseList = warehousingDao.getAHouseList();
        return aHouseList;
    }

    @Override
    public List<WarehouseVo> findAllOfStatus() {
        return warehousingDao.findAllOfStatus();
    }

    @Override
    public List<AWarehousing> findName() {
        return warehousingDao.getWName();
    }


    /**
     * 分页  模糊组合查询
     * @param
     * @return
     */
    @Override
    public List<WarehouseVo> search(WarehouseVo warehouseVo) {

            List<WarehouseVo> warehouseVos = warehousingDao.searchList(warehouseVo);

            return warehouseVos;
    }

    @Override
    public AWarehousing findById(String amsCode) {
        return warehousingDao.findAllById(amsCode);
    }

    @Override
    public void updateWareHById(WarehouseVo warehouseVo) {
        warehousingDao.updateWareHById(warehouseVo);
    }



    @Override
    public void DeleteById(Long id) {

            warehousingDao.DeleteById(id);

    }

    @Override
    public void createWareH(AWarehousing aWarehousing) {
        aWarehousing.setAmsCode(DateUtils.getNewToday("ZC"));
        aWarehousing.setWarehousingDate(new Date());
        warehousingDao.creatWareH(aWarehousing);
    }

    @Override
    public WarehouseVo findListById(Long id) {
        WarehouseVo listById = warehousingDao.findListById(id);

        return listById;
    }


    @Override
    public List<WarehouseVo> findOfAdd() {
        List<WarehouseVo> all = warehousingDao.findOfList();
        return all;
    }


}


