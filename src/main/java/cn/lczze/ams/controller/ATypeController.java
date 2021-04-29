package cn.lczze.ams.controller;
import cn.lczze.ams.entity.AType;
import cn.lczze.ams.service.ATypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by lczze on 2021/3/5 12:31
 */

@Controller
public class ATypeController {

    @Autowired
    private ATypeService aTypeService;

    /**
     * 查出全部
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/aTypeList")
    public String findAllAtype(
                        Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
            PageHelper.startPage(pageNum,8);
            List<AType> aTypes = aTypeService.findAll();
            PageInfo<AType> pageInfo = new PageInfo<>(aTypes);
            model.addAttribute("pageInfo" + "",pageInfo);
            return "atype";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/aTypeS")
    public String search(AType aType,
            Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
            PageHelper.startPage(pageNum, 8);
            List<AType> aTypeBySearch = aTypeService.search(aType);
            PageInfo<AType> pageInfo = new PageInfo<>(aTypeBySearch);
            model.addAttribute("pageInfo", pageInfo);
            return "atype :: atyList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addAty")
    public String add(Model model){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("atype", new AType());
        model.addAttribute("isTitle","类别新增");
        return "atypeAdd";
    }

    /**
     * 增加类别
     * @param typeCode
     * @param typeName
     * @return
     */
    @PostMapping("/addAType")
    public String addAType(@RequestParam String typeCode,@RequestParam String typeName){
        aTypeService.createAType(typeCode,typeName);
        return "redirect:/aTypeList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        System.out.println(1111);
        AType byId = aTypeService.findById(id);
        System.out.println(2222);
        model.addAttribute("atype", byId);
        model.addAttribute("isTitle","类别编辑");
        return "atypeAdd";
    }


    /**
     * 编辑修改分类
     * @param aType
     * @param id
     * @return
     */
    @PostMapping("/aType/{id}")
    public String editPost(AType aType, @PathVariable Long id) {
        aTypeService.updateATypeById(aType);
        return "redirect:/aTypeList";
    }

    /**
     * 改变类别状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/changeStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        aTypeService.changeStuById(id);
     return "redirect:/aTypeList";
    }


 }
