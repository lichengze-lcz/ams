package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.BrandDao;
import cn.lczze.ams.entity.Brand;
import cn.lczze.ams.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:36
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public List<Brand> findAll() {
           return brandDao.findAll();
    }

    @Override
    public List<Brand> findAllOfStaus() {
        return brandDao.findAllOfStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param brand
     * @return
     */
    @Override
    public List<Brand> search(Brand brand) {

        if (brand.getBrandStatus() != null){
            List<Brand> brands = brandDao.searchList(brand);
            return brands;
        }else {
            List<Brand> brands = brandDao.searchNoSta(brand);
            return brands;
        }

    }


    @Override
    public void createBrand(String brandCode, String brandName) {
        Brand brand = new Brand();
        brand.setBrandCode(brandCode);
        brand.setBrandName(brandName);
        brandDao.creatBrand(brand);
    }


    @Override
    public Brand findById(Long id) {
        Brand byId = brandDao.findById(id);

        return byId;
    }

    @Override
    public void updateBrandById(Brand brand) {

        brandDao.updateBrandById(brand);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        Brand byId = brandDao.findById(id);
        //停用
        if (byId.getBrandStatus().equals(1) && byId.getBrandStatus() != null){
            brandDao.changeStu(id,0);
        //启用
        }else if(byId.getBrandStatus().equals(0) && byId.getBrandStatus() != null){
            brandDao.changeStu(id,1);
        }

    }


}
