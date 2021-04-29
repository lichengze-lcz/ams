package cn.lczze.ams.dao;

import cn.lczze.ams.entity.Amsbr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lczze on 2021/3/22 10:19
 */

@Mapper
@Repository
public interface AmsBrDao {

    List<Amsbr> findAll();

    List<Amsbr> findBySearch(@Param("amsCode") String amsCode,@Param("amsName")String amsName,@Param("typeName")String typeName,@Param("departmentName")String departmentName);

    Amsbr findAllById(Long id);

    void CreateAmsBr(Amsbr amsbr);

    void createRDesc(@Param("rDesc") String returnDesc, @Param("date") Date date,@Param("id")Integer id);

    void updateAmsBrStatus(@Param("status")String status ,@Param("amsId")Integer amsId);

}
