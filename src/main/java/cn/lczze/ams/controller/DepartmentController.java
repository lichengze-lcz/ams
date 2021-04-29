package cn.lczze.ams.controller;

import cn.lczze.ams.entity.Department;
import cn.lczze.ams.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:27
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService DepartmentService;

    /**
     * 查出全部品牌
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/departmentList")
    public String findAllDept(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<Department> departments = DepartmentService.findAll();
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        model.addAttribute("pageInfo" + "",pageInfo);
        return "department";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/departmentS")
    public String search(Department department,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        List<Department> departmentBySearch = DepartmentService.search(department);
        PageInfo<Department> pageInfo = new PageInfo<>(departmentBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "department :: departmentList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addDept")
    public String add(Model model){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("department", new Department());
        model.addAttribute("isTitle","部门新增");
        return "departmentAdd";
    }

    /**
     * 增加
     * @param departmentCode
     * @param departmentName
     * @return
     */
    @PostMapping("/addDepartment")
    public String addDepartment(@RequestParam String departmentCode,@RequestParam String departmentName){
        DepartmentService.createDepartment(departmentCode,departmentName);
        return "redirect:/departmentList";
    }

    /**
     * 到编辑页面面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/departmentEdit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Department byId = DepartmentService.findById(id);
        model.addAttribute("department", byId);
        model.addAttribute("isTitle","部门编辑");
        return "departmentAdd";
    }


    /**
     * 编辑分类
     * @param department
     * @param id
     * @return
     */
    @PostMapping("/department/{id}")
    public String editPost(Department department, @PathVariable Long id) {
        DepartmentService.updateDepartmentById(department);
        return "redirect:/departmentList";
    }

    /**
     * 改变状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/departmentStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        DepartmentService.changeStuById(id);
        return "redirect:/departmentList";
    }
}