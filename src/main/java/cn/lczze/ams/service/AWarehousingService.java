package cn.lczze.ams.service;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.Brand;

import java.util.List;

/**
 * Created by lczze on 2021/3/16 15:41
 */
public interface AWarehousingService {

    List<WarehouseVo> findAll();

    List<WarehouseVo> findAllOfStatus();

    List<AWarehousing> findName();

    List<WarehouseVo> search(WarehouseVo warehouseVo);

//
    AWarehousing findById(String amsCode);
//
    void updateWareHById(WarehouseVo warehouseVo);
//
    void DeleteById(Long id);

    void createWareH(AWarehousing aWarehousing);

    WarehouseVo findListById(Long id);

    List<WarehouseVo> findOfAdd();


}
