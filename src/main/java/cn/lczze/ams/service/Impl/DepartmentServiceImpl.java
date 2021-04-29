package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.DepartmentDao;
import cn.lczze.ams.entity.Department;
import cn.lczze.ams.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:36
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
           return departmentDao.findAll();
    }

    @Override
    public List<Department> findAllOfStatus() {
        return departmentDao.findAllOfStatus();
    }

    /**
     * 分页  模糊组合查询
     * @param department
     * @return
     */
    @Override
    public List<Department> search(Department department) {

        if (department.getDepartmentStatus() != null){
            List<Department> Departments = departmentDao.searchList(department);
            return Departments;
        }else {
            List<Department> Departments = departmentDao.searchNoSta(department);
            return Departments;
        }

    }


    @Override
    public void createDepartment(String departmentCode, String departmentName) {
        Department departments = new Department();
        departments.setDepartmentCode(departmentCode);
        departments.setDepartmentName(departmentName);
        departmentDao.creatDepartment(departments);
    }


    @Override
    public Department findById(Long id) {
        Department byId = departmentDao.findById(id);
        return byId;
    }

    @Override
    public void updateDepartmentById(Department department) {

        departmentDao.updateDepartmentById(department);
    }

    @Override
    public void changeStuById(Long id) {
        //根据id查出自身状态
        Department byId = departmentDao.findById(id);
        //停用类别
        if (byId.getDepartmentStatus().equals(1) && byId.getDepartmentStatus() != null){
            departmentDao.changeStu(id,0);
        //启用类别
        }else if(byId.getDepartmentStatus().equals(0) && byId.getDepartmentStatus() != null){
            departmentDao.changeStu(id,1);
        }

    }


}
