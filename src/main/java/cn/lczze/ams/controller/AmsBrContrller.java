package cn.lczze.ams.controller;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.Amsbr;
import cn.lczze.ams.entity.Department;
import cn.lczze.ams.service.AWarehousingService;
import cn.lczze.ams.service.AmsBrService;
import cn.lczze.ams.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:42
 */
@Controller
public class AmsBrContrller {

    @Autowired
    private AmsBrService amsBrService;

    @Autowired
    private AWarehousingService aWarehousingService;

    @Autowired
    private DepartmentService departmentService;



    @RequestMapping("/aBrList")
    public String amsBrowerRe(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<Amsbr> alls = amsBrService.findAll();
        PageInfo<Amsbr> pageInfo = new PageInfo<>(alls);
        model.addAttribute("pageInfo" ,pageInfo);
     
        return "amsbr";
    }

    @RequestMapping("/amsBrS")
    public String search(String amsCode,String amsName,String typeName,String departmentName,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum, 8);
        List<Amsbr> AmsBrSearch = amsBrService.findBySearch(amsCode,amsName,typeName,departmentName);
        PageInfo<Amsbr> pageInfo = new PageInfo<>(AmsBrSearch);
        model.addAttribute("pageInfo", pageInfo);
        return "amsbr :: amsbrList";
    }


    @RequestMapping("/addBr")
    public String addAmsBr(Model model){

        List<WarehouseVo> warehouseVoList = aWarehousingService.findAllOfStatus();
        List<Department> departments = departmentService.findAllOfStatus();

        model.addAttribute("warehouseVos",warehouseVoList);
        model.addAttribute("departments",departments);
        model.addAttribute("isTitle","资产借还新增");
        return "amsbrAdd";
    }

    @RequestMapping("/addAmsBrList")
    public String addAmsBrList(Amsbr amsbr){
        amsBrService.saveAmsBr(amsbr);
        return "redirect:/aBrList";
    }


    @RequestMapping("/editBr/{id}")
    public String editAmsBr(Model model, @PathVariable Long id){

        //根据id查出该资产编码及其他信息
        Amsbr amsbrs = amsBrService.findAllById(id);
        AWarehousing warehousingList = aWarehousingService.findById(amsbrs.getAmsCode());
        model.addAttribute("AmsDate",amsbrs);
        model.addAttribute("AmsBrs",warehousingList);
        return "amsbrEdit";
    }

    /**
     * 归还借还
     * @param returnDesc
     * @param id
     * @param amsId
     * @return
     */
    @RequestMapping("/returnAms")
    public String editToAmsBr(@RequestParam String returnDesc, @RequestParam Integer id,@RequestParam Integer amsId){
        amsBrService.updateRDesc(returnDesc,id,amsId);
        return "redirect:/aBrList";
    }


    /**
     * 查看借还信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/scanBr/{id}")
    public String scanAmsBr(Model model, @PathVariable Long id){
        //根据id查出该资产编码及其他信息
        Amsbr amsbrs = amsBrService.findAllById(id);
        AWarehousing warehousingList = aWarehousingService.findById(amsbrs.getAmsCode());
        model.addAttribute("AmsDate",amsbrs);
        model.addAttribute("AmsBrs",warehousingList);
        return "amsbrScan";
    }


}
