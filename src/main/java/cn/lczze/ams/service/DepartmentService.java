package cn.lczze.ams.service;

import cn.lczze.ams.entity.Department;
import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:35
 */
public interface DepartmentService {
    List<Department> findAll();

    List<Department> findAllOfStatus();


    List<Department> search(Department department);

    void createDepartment(String departmentCode, String departmentName);

    Department findById(Long id);

    void updateDepartmentById(Department department);

    void changeStuById(Long id);

}
