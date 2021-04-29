package cn.lczze.ams.controller;

import cn.lczze.ams.entity.*;
import cn.lczze.ams.service.ATypeService;
import cn.lczze.ams.service.AmsBuyService;
import cn.lczze.ams.service.BrandService;
import cn.lczze.ams.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:46
 */
@Controller
public class AmsBuyController {

    @Autowired
    private AmsBuyService amsBuyService;

    @Autowired
    private ATypeService aTypeService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private BrandService brandService;

    @RequestMapping("/aBuyList")
    public String AbuyList(Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,6);
        List<AmsBuy> amsBuys = amsBuyService.findAll();
        System.out.println(amsBuys);
        PageInfo<AmsBuy> pageInfo = new PageInfo<>(amsBuys);
        model.addAttribute("pageInfo" ,pageInfo);

        return "amsbuy";
    }
//    @RequestMapping("/adminBuy")
//    public String adminAbuyList(Model model,
//                           @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//
//        PageHelper.startPage(pageNum,6);
//        List<AmsBuy> amsBuys = amsBuyService.findAll();
//        System.out.println(amsBuys);
//        PageInfo<AmsBuy> pageInfo = new PageInfo<>(amsBuys);
//        model.addAttribute("pageInfo" ,pageInfo);
//
//        return "/amsbuy";
//    }


    @RequestMapping("/admin/cBuyStatus/{id}/{status}")
    public String changeBuyStatus(@PathVariable Long id,@PathVariable Long status){

        amsBuyService.chengeStatusById(id,status);

        return "redirect:/aBuyList";
    }



    @RequestMapping("/aBuyS")
    public String AbuySeach(String amsName, String typeName,String supplierName,String brandName,String buyReason
//            ,Long resultStatus,Long budget
                       ,Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {


        PageHelper.startPage(pageNum,6);
        List<AmsBuy> amsBuys = amsBuyService.findAllByS(amsName,typeName,supplierName,brandName,buyReason);
        System.out.println(amsBuys);
        PageInfo<AmsBuy> pageInfo = new PageInfo<>(amsBuys);
        model.addAttribute("pageInfo" ,pageInfo);

        return "amsbuy :: AmsBuyList";
    }


    @RequestMapping("/addAmsB")
    public String addAmsB(Model model){

        List<AType> types = aTypeService.findAllByStatus();
        List<Supplier> suppliers = supplierService.findAllOfStatus();
        List<Brand> brands = brandService.findAllOfStaus();

        model.addAttribute("types",types);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("brands",brands);

        return "amsbuyAdd";

    }

    @RequestMapping("/addAmsBuy")
    public String addAmsBuy(AmsBuy amsBuy){
        amsBuyService.saveAmsBuy(amsBuy);
        return "redirect:aBuyList";
    }

    @RequestMapping("/deleBuy/{id}")
    public String deleteAmsBuy(@PathVariable long id ){

        amsBuyService.deleteById(id);
        return "redirect:/aBuyList";
    }



}
