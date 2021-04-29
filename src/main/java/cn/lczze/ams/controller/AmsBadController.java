package cn.lczze.ams.controller;

import cn.lczze.ams.Vo.WarehouseVo;
import cn.lczze.ams.entity.AType;
import cn.lczze.ams.entity.AWarehousing;
import cn.lczze.ams.entity.AmsBad;
import cn.lczze.ams.entity.BadWay;
import cn.lczze.ams.service.ATypeService;
import cn.lczze.ams.service.AWarehousingService;
import cn.lczze.ams.service.AmsBadService;
import cn.lczze.ams.service.BadWayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:48
 */
@Controller
public class AmsBadController {

    @Autowired
    private AmsBadService amsBadService;

    @Autowired
    private AWarehousingService aWarehousingService;

    @Autowired
    private BadWayService badWayService;

    @RequestMapping("/aBadList")
    public String findAll(Model model, @RequestParam(defaultValue = "1" ,value = "pageNum" )Integer pageNum){

        PageHelper.startPage(pageNum,6);
        List<AmsBad> amsBads = amsBadService.findAll();
        PageInfo<AmsBad> pageInfo = new PageInfo<>(amsBads);
        model.addAttribute("pageInfo",pageInfo);
        return "amsbad";
    }

//    @Secured("ROLE_admin")
//    @RequestMapping("/adminBad")
//    public String adminFindAll(Model model, @RequestParam(defaultValue = "1" ,value = "pageNum" )Integer pageNum){
//
//        PageHelper.startPage(pageNum,6);
//        List<AmsBad> amsBads = amsBadService.findAll();
//        PageInfo<AmsBad> pageInfo = new PageInfo<>(amsBads);
//        model.addAttribute("pageInfo",pageInfo);
//        return "/amsbad";
//    }

    @RequestMapping("/aBadS")
    public String FindAllS(String amsCode,String amsName,String badWay,String badReason
            ,Model model, @RequestParam(defaultValue = "1" ,value = "pageNum" )Integer pageNum){
        PageHelper.startPage(pageNum,6);

        List<AmsBad> amsBads = amsBadService.findAllS(amsCode,amsName,badWay,badReason);
        PageInfo<AmsBad> pageInfo = new PageInfo<>(amsBads);
        model.addAttribute("pageInfo",pageInfo);
        return "amsbad :: amsBadList";
    }


    @RequestMapping("/admin/cBadStatus/{id}/{status}")
    public String changeBadStatus(@PathVariable Long id,@PathVariable Long status){

        amsBadService.chengeStatusById(id,status);

        return "redirect:/aBadList";
    }


    @RequestMapping("/addABad")
    public String addABad(Model model){

        List<AWarehousing> amsNames = aWarehousingService.findName();
        List<BadWay> badWays = badWayService.findAllByStatus();
        model.addAttribute("amsNames",amsNames);
        model.addAttribute("badWays",badWays);

        return "amsbadAdd";
    }




    @RequestMapping("/addABadList")
    public String addABadList(AmsBad amsBad,Model model){

        amsBadService.saveAmsBad(amsBad);

        return "redirect:/aBadList";
    }

    @RequestMapping("/deleteBad/{id}")
    public String EditBadList(@PathVariable Long id, Model model){

        amsBadService.deleteBad(id);

        return "redirect:/aBadList";
    }
}
