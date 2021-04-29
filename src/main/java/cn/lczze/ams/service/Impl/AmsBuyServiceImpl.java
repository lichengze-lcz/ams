package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.AmsBuyDao;
import cn.lczze.ams.entity.AmsBuy;
import cn.lczze.ams.service.AmsBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/23 9:54
 */
@Service
public class AmsBuyServiceImpl implements AmsBuyService {


    @Autowired
    private AmsBuyDao amsBuyDao;


    @Override
    public List<AmsBuy> findAll() {

      return   amsBuyDao.findAll();

    }

    @Override
    public List<AmsBuy> findAllByS(String amsName, String typeName,String supplierName,String branName,String buyReason) {


        return   amsBuyDao.findAllByS(amsName,typeName,supplierName,branName,buyReason);
    }

    @Override
    public void saveAmsBuy(AmsBuy amsBuy) {
        amsBuyDao.createAmsBuy(amsBuy);
    }

    @Override
    public void deleteById(long id) {
        amsBuyDao.deleteById(id);
    }

    @Override
    public void chengeStatusById(Long id,Long status) {
        amsBuyDao.chengeStatusById(id,status);
    }
}
