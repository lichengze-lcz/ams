package cn.lczze.ams.dao;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/16 15:23
 */
@Mapper
@Repository
public interface AWarehousingDao {
     List<WarehouseVo> getAHouseList();

     List<WarehouseVo>findAllOfStatus();

     List<AWarehousing> getWName();

     List<WarehouseVo> searchList(WarehouseVo warehouseVo);


     //根据id查类别
     AWarehousing findAllById(@Param("amsCode") String amsCode);

     //改变实体状态
     void DeleteById(@Param("id") Long id);


     void creatWareH(AWarehousing aWarehousing);

     List<WarehouseVo> findOfList();

     WarehouseVo findListById(@Param("wid")Long wid);

     void updateWareHById(WarehouseVo warehouseVo);

     void updateAmsStatus(@Param("status")String status ,@Param("amsId")Integer amsId);

     AWarehousing findCodeByName(@Param("amsName") String amsName);
}
