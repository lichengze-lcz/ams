package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.SupplierDao;
import cn.lczze.ams.entity.Supplier;
import cn.lczze.ams.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/14 16:03
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao SupplierDao;

    @Override
    public List<Supplier> findAll() {
        return SupplierDao.findAll();
    }

    @Override
    public List<Supplier> findAllOfStatus() {
        return SupplierDao.findAllOfStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param supplier
     * @return
     */
    @Override
    public List<Supplier> search(Supplier supplier) {

        if (supplier.getSupplierStatus() != null){
            List<Supplier> Suppliers = SupplierDao.searchList(supplier);
            return Suppliers;
        }else {
            List<Supplier> Suppliers = SupplierDao.searchNoSta(supplier);
            return Suppliers;
        }

    }


    @Override
    public void createSupplier(Supplier supplier) {
        SupplierDao.creatSupplier(supplier);
    }


    @Override
    public Supplier findById(Long id) {
        Supplier byId = SupplierDao.findById(id);

        return byId;
    }

    @Override
    public void updateSupplierById(Supplier supplier) {

        SupplierDao.updateSupplierById(supplier);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        Supplier byId = SupplierDao.findById(id);
        //停用
        if (byId.getSupplierStatus().equals(1) && byId.getSupplierStatus() != null){
            SupplierDao.changeStu(id,0);
            //启用
        }else if(byId.getSupplierStatus().equals(0) && byId.getSupplierStatus() != null){
            SupplierDao.changeStu(id,1);
        }

    }


}


