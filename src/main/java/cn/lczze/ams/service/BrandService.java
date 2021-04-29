package cn.lczze.ams.service;

import cn.lczze.ams.entity.Brand;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:35
 */
public interface BrandService {
    List<Brand> findAll();

    List<Brand> findAllOfStaus();

    List<Brand> search(Brand brand);

    void createBrand(String brandCode, String brandName);

    Brand findById(Long id);

    void updateBrandById(Brand brand);

    void changeStuById(Long id);

}
