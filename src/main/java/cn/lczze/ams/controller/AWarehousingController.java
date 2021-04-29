package cn.lczze.ams.controller;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.entity.*;
import cn.lczze.ams.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:38
 */
@Controller
public class AWarehousingController {

    @Autowired
    private AWarehousingService aWarehousingService;

    @Autowired
    private ATypeService aTypeService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private LeaveAddressService leaveAddressService;

    @RequestMapping("/wareHList")
    public String findAllWare(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,6);
        List<WarehouseVo> warehouseVoList = aWarehousingService.findAll();
        PageInfo<WarehouseVo> pageInfo = new PageInfo<>(warehouseVoList);
        System.out.println(pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "aWareHousing";
    }


    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/wareHS")
    public String search(WarehouseVo warehouseVo,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 6);
        List<WarehouseVo> warehouseVoList = aWarehousingService.search(warehouseVo);
        PageInfo<WarehouseVo> pageInfo = new PageInfo<>(warehouseVoList);
        model.addAttribute("pageInfo", pageInfo);
        return "aWareHousing :: wareHList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addWareH")
    public String add(Model model){

        List<AType> types = aTypeService.findAllByStatus();

        List<Supplier> suppliers = supplierService.findAllOfStatus();

        List<Brand> brands = brandService.findAllOfStaus();

        List<LeaveAddress> leaveAddresses = leaveAddressService.findAllOfStatus();

        model.addAttribute("types",types);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("brands",brands);
        model.addAttribute("leaveAddresses",leaveAddresses);
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("aWares",new AWarehousing());
        model.addAttribute("isTitle","资产入库新增");
        return "aWareHousingAdd";
    }

    /**
     * 增加
     * @param
     * @param
     * @return
     */
    @RequestMapping("/addWareHouse")
    public String addBrand(AWarehousing aWarehousing){

        System.out.println(aWarehousing);
        aWarehousingService.createWareH(aWarehousing);

        return "redirect:/wareHList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/wareHEdit/{id}")
    public String edit(@PathVariable Long id, Model model){

        List<AType> types = aTypeService.findAllByStatus();

        List<Supplier> suppliers = supplierService.findAllOfStatus();

        List<Brand> brands = brandService.findAllOfStaus();

        List<LeaveAddress> leaveAddresses = leaveAddressService.findAllOfStatus();


        model.addAttribute("types",types);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("brands",brands);
        model.addAttribute("leaveAddresses",leaveAddresses);
        WarehouseVo listById = aWarehousingService.findListById(id);

        System.out.println(listById+"===================================");
        model.addAttribute("aWares", listById);
        model.addAttribute("isTitle","资产入库编辑");
        return "aWareHousingAdd";
    }


    /**
     * 编辑
     * @param
     * @param id
     * @return
     */
    @PostMapping("/wareHE/{id}")
    public String editPost(WarehouseVo warehouseVo, @PathVariable Long id) {
        aWarehousingService.updateWareHById(warehouseVo);
        return "redirect:/wareHList";
    }

    /**
     * 改变状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/wareHDelete/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        aWarehousingService.DeleteById(id);
        return "redirect:/wareHList";
    }
}

