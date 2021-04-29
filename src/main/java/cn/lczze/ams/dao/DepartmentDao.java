package cn.lczze.ams.dao;

import cn.lczze.ams.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lczze on 2021/3/5 12:32
 */
@Mapper
@Repository
public interface DepartmentDao {

    //查询Lsit
   List<Department> findAll();

   List<Department> findAllOfStatus();


   //模糊查询
   List<Department> searchList(Department department);

   List<Department> searchNoSta(Department drand);

   void creatDepartment(Department drand);

   //根据id查类别
   Department findById(Long id);

   void updateDepartmentById(Department drand);

   //改变状态
   void changeStu(@Param("id") Long id ,@Param("Stu") Integer Stu);
}
