package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.BadWayDao;
import cn.lczze.ams.entity.BadWay;
import cn.lczze.ams.service.BadWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by lczze on 2021/3/14 9:30
 */
@Service
public class BadWayServiceImpl implements BadWayService {


    @Autowired
    private BadWayDao BadWayDao;

    @Override
    public List<BadWay> findAll() {
        return BadWayDao.findAll();
    }

    @Override
    public List<BadWay> findAllByStatus() {
       return BadWayDao.findAllByStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param badWay
     * @return
     */
    @Override
    public List<BadWay> search(BadWay badWay) {

        if (badWay.getBadWayStatus() != null){
            List<BadWay> badWays = BadWayDao.searchList(badWay);
            return badWays;
        }else {
            List<BadWay> badWays = BadWayDao.searchNoSta(badWay);
            return badWays;
        }
    }


    @Override
    public void createBadWay(String badWayCode, String badWayName) {
        BadWay badWays = new BadWay();
        badWays.setBadWayCode(badWayCode);
        badWays.setBadWayName(badWayName);
        BadWayDao.creatBadWay(badWays);
    }


    @Override
    public BadWay findById(Long id) {
        BadWay byId = BadWayDao.findById(id);
        return byId;
    }

    @Override
    public void updateBadWayById(BadWay badWay) {
        BadWayDao.updateBadWayById(badWay);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        BadWay byId = BadWayDao.findById(id);
        //停用
        if (byId.getBadWayStatus().equals(1) && byId.getBadWayStatus() != null){
            BadWayDao.changeStu(id,0);
            //启用
        }else if(byId.getBadWayStatus().equals(0) && byId.getBadWayStatus() != null){
            BadWayDao.changeStu(id,1);
        }
    }


}
