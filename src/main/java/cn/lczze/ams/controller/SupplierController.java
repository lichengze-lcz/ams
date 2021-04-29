package cn.lczze.ams.controller;

import cn.lczze.ams.entity.Supplier;
import cn.lczze.ams.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:30
 */
@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 查出全部
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/supplierList")
    public String findAllSupplier(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<Supplier> supplier = supplierService.findAll();
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplier);
        model.addAttribute("pageInfo" + "",pageInfo);
        return "supplier";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/supplierS")
    public String search(Supplier supplier,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        System.out.println(supplier);
        List<Supplier> supplierBySearch = supplierService.search(supplier);
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "supplier :: supplierList";
    }
    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addSupper")
    public String add(Model model){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("isTitle","供应商新增");
        return "supplierAdd";
    }

    /**
     * 增加
     * @param
     * @param
     * @return
     */
    @PostMapping("/addSupplier")
    public String addSupplier(Supplier supplier){
        supplierService.createSupplier(supplier);
        return "redirect:/supplierList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/supplierEdit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Supplier byId = supplierService.findById(id);
        model.addAttribute("supplier", byId);
        model.addAttribute("isTitle","供应商编辑");
        return "supplierAdd";
    }


    /**
     * 编辑分类
     * @param supplier
     * @param id
     * @return
     */
    @PostMapping("/supplier/{id}")
    public String editPost(Supplier supplier, @PathVariable Long id) {
        supplierService.updateSupplierById(supplier);
        return "redirect:/supplierList";
    }

    /**
     * 改变状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/supplierStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        supplierService.changeStuById(id);
        return "redirect:/supplierList";
    }
}

