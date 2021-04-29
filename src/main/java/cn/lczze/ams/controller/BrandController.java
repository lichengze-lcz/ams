package cn.lczze.ams.controller;

import cn.lczze.ams.entity.Brand;
import cn.lczze.ams.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lczze on 2021/3/7 9:58
 */

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查出全部
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/brandList")
    public String findAllBrand(
            Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        List<Brand> brands = brandService.findAll();
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        model.addAttribute("pageInfo" + "",pageInfo);
        return "brand";
    }

    /**
     * 模糊查询 带分页
     * @param
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/brandS")
    public String search(Brand brand,
                         Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        List<Brand> brandBySearch = brandService.search(brand);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "brand :: brandList";
    }


    /**
     * 到增加页面
     * @param model
     * @return
     */
    @RequestMapping("/addBrd")
    public String add(Model model){
        //添加 编辑共用一个页面   根据id 是否有值
        model.addAttribute("brand", new Brand());
        model.addAttribute("isTitle","品牌新增");
        return "brandAdd";
    }

    /**
     * 增加
     * @param brandCode
     * @param brandName
     * @return
     */
    @PostMapping("/addBrand")
    public String addBrand(@RequestParam String brandCode,@RequestParam String brandName){
        brandService.createBrand(brandCode,brandName);
        return "redirect:/brandList";
    }

    /**
     * 到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/brandEdit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Brand byId = brandService.findById(id);
        model.addAttribute("brand", byId);
        model.addAttribute("isTitle","品牌编辑");
        return "brandAdd";
    }


    /**
     * 编辑分类
     * @param brand
     * @param id
     * @return
     */
    @PostMapping("/brand/{id}")
    public String editPost(Brand brand, @PathVariable Long id) {
        brandService.updateBrandById(brand);
        return "redirect:/brandList";
    }

    /**
     * 改变状态
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/BrandStu/{id}")
    public String changeStu( @PathVariable Long id,Model model){
        brandService.changeStuById(id);
        return "redirect:/brandList";
    }
}
