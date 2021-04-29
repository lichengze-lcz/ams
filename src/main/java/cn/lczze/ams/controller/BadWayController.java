package cn.lczze.ams.controller;

import cn.lczze.ams.entity.BadWay;
import cn.lczze.ams.service.BadWayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:21
 */
@Controller
public class BadWayController {

    @Autowired
    private BadWayService badWayService;

    /**
     * 查出全部
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/badWayList")
    public String findAllbadWay(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<BadWay> badWays = badWayService.findAll();
        PageInfo<BadWay> pageInfo = new PageInfo<>(badWays);
        model.addAttribute("pageInfo" + "",pageInfo);
        return "badWay";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/badWayS")
    public String search(BadWay badWay,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        List<BadWay> badWayBySearch = badWayService.search(badWay);
        PageInfo<BadWay> pageInfo = new PageInfo<>(badWayBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "badWay :: bWayList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addBWay")
    public String add(Model model, RedirectAttributes attributes){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("badWay", new BadWay());
        model.addAttribute("isTitle","报废方式新增");
        return "badWayAdd";
    }

    /**
     * 增加类别
     * @param badWayCode
     * @param badWayName
     * @return
     */
    @PostMapping("/addBadWay")
    public String addBadWay(@RequestParam String badWayCode,@RequestParam String badWayName){
        badWayService.createBadWay(badWayCode,badWayName);
        return "redirect:/badWayList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/badWayEdit/{id}")
    public String edit(@PathVariable Long id, Model model){
        BadWay byId = badWayService.findById(id);
        model.addAttribute("badWay", byId);
        model.addAttribute("isTitle","报废方式编辑");
        return "badWayAdd";
    }


    /**
     * 编辑修改分类
     * @param badWay
     * @param id
     * @return
     */
    @PostMapping("/badWay/{id}")
    public String editPost(BadWay badWay, @PathVariable Long id) {
        badWayService.updateBadWayById(badWay);
        return "redirect:/badWayList";
    }

    /**
     * 改变类别状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/badWayStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        badWayService.changeStuById(id);
        return "redirect:/badWayList";
    }

}
