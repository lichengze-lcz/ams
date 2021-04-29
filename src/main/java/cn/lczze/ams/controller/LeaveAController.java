package cn.lczze.ams.controller;

import cn.lczze.ams.entity.LeaveAddress;
import cn.lczze.ams.service.LeaveAddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 19:36
 */
@Controller
public class LeaveAController {

    @Autowired
    private LeaveAddressService LeaveAddressService;

    /**
     * 查出全部
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/leaveList")
    public String findAllLeave(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<LeaveAddress> leaveAddress = LeaveAddressService.findAll();
        PageInfo<LeaveAddress> pageInfo = new PageInfo<>(leaveAddress);
        model.addAttribute("pageInfo" + "",pageInfo);
        return "leaveAddress";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/leaveS")
    public String search(LeaveAddress leaveAddress,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        List<LeaveAddress> leaveAddressBySearch = LeaveAddressService.search(leaveAddress);
        PageInfo<LeaveAddress> pageInfo = new PageInfo<>(leaveAddressBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "leaveAddress :: leaveAddressList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addLeaveA")
    public String add(Model model){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("leaveAddress", new LeaveAddress());
        model.addAttribute("isTitle","存放地点新增");
        return "leaveAddressAdd";
    }

    /**
     * 增加
     * @param
     * @param
     * @return
     */
    @PostMapping("/addLeaveAddress")
    public String addLeaveAddress(LeaveAddress leaveAddress){
        LeaveAddressService.createLeaveAddress(leaveAddress);
        return "redirect:/leaveList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/leaveEdit/{id}")
    public String edit(@PathVariable Long id, Model model){
        LeaveAddress byId = LeaveAddressService.findById(id);
        model.addAttribute("leaveAddress", byId);
        model.addAttribute("isTitle","存放地点编辑");
        return "leaveAddressAdd";
    }


    /**
     * 编辑分类
     * @param LeaveAddress
     * @param id
     * @return
     */
    @PostMapping("/leaveAddress/{id}")
    public String editPost(LeaveAddress LeaveAddress, @PathVariable Long id) {
        LeaveAddressService.updateLeaveAddressById(LeaveAddress);
        return "redirect:/leaveList";
    }

    /**
     * 改变状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/leaveStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){

        System.out.println("==============================================================");
        LeaveAddressService.changeStuById(id);
        return "redirect:/leaveList";
    }
}



