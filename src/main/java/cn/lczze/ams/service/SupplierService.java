package cn.lczze.ams.service;

import cn.lczze.ams.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/14 16:03
 */
@Service
public interface SupplierService {

    List<Supplier> findAll();

    List<Supplier> findAllOfStatus();

    List<Supplier> search(Supplier supplier);

    void createSupplier(Supplier supplier);

    Supplier findById(Long id);

    void updateSupplierById(Supplier supplier);

    void changeStuById(Long id);
}
