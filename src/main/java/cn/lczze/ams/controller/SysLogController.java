package cn.lczze.ams.controller;

import cn.lczze.ams.entity.Role;
import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.entity.UserInfo;
import cn.lczze.ams.service.ISysLogService;
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
 * Created by lczze on 2021/4/22 9:37
 */

@Controller
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/sysList")
    public String findAllSys(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) throws Exception{
        PageHelper.startPage(pageNum,8);
        List<SysLog> sysLogs =  sysLogService.findAll();
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        return "adSyslog";
    }

    @RequestMapping("/sysPage")
    public String findAllPage(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) throws Exception{
        PageHelper.startPage(pageNum,8);
        List<SysLog> sysLogs =  sysLogService.findAll();
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        return "adSyslog :: sysFra";
    }


    @RequestMapping("/roleList")
    public String findRole(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) throws Exception{
        PageHelper.startPage(pageNum,8);
        List<UserInfo> sysLogs=  sysLogService.findRole();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        return "adRole";
    }


    @RequestMapping("/chRole/{id}")
    public String chRole(@PathVariable Long id,Model model) throws Exception{
        List<Role> roleName = sysLogService.findRANme();
        model.addAttribute("raNme", roleName);

        UserInfo UaNme = sysLogService.findUName(id);
        model.addAttribute("UaNme", UaNme);
        return "adRoleAdd";
    }

    @RequestMapping("/editRole")
    public String updateRole(Long id,Long roleId){

        sysLogService.updateRoleById(id,roleId);
        return "redirect:/roleList";
    }

}
