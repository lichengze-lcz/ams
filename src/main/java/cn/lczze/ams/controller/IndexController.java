package cn.lczze.ams.controller;

import cn.lczze.ams.service.Loginservice;
import cn.lczze.ams.until.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * Created by lczze on 2021/3/3 15:38
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private Loginservice loginservice;

    @RequestMapping("/")
    public String loginI(){
        return "login";
    }


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/toError")
    public String itoError(){
        return "LoError";
    }



    @RequestMapping("/per")
    public String person(){
        return "person";
    }
    @RequestMapping("/perP")
    public String personP( ){
        return "personP";
    }
    @RequestMapping("/perPplus")
    public String perPplus(){
        return "personPplus";
    }
    @RequestMapping("/uAvatar")
    public String updateAvatar(){

        return "personPplus";
    }

    //上传图片
    @ResponseBody
    @PostMapping("/uploadA")
    public ModelAndView upload(@RequestParam("picture") MultipartFile file, String username, String showflay ) throws IOException {
        ModelAndView mv = new ModelAndView();
        System.out.println(file.getOriginalFilename());
        String pathimg;
        if (!file.isEmpty()) {
            //获取上传文件名
            String filename = file.getOriginalFilename();
            //文件上传格式判断
            if ((filename).contains(".gif") || (filename).contains(".GIF") ||
                    (filename).contains(".jpg") || (filename).contains(".JPG") ||
                    (filename).contains(".jpeg") || (filename).contains(".JPEG") ||
                    (filename).contains(".PNG") || (filename).contains(".png")) {
            } else {
                log.warn("文件上传失败");
                mv.addObject("errmsg", "文件上传格式不支持");
                mv.addObject("path", "per");
                mv.setViewName("perror");
                return mv;
            }
            //上传路径
            String filepath = "/lczze/net/image/";
            //随机字符串
            String RandomS = RandomUtil.generateStr(6);
            //上传路径 + 文件名
            File dest = new File(filepath + RandomS + ".png");
            //文件上传
            file.transferTo(dest);

            //测试回显路径
            pathimg = "http://loveweb.lczze.cn/" + RandomS + ".png";
        } else {
            mv.addObject("errmsg", "文件上传失败");
            mv.addObject("path", "per");
            mv.setViewName("perror");
            return mv;
        }
        //更新文件
        loginservice.updateAvatar(pathimg);
        mv.setViewName("redirect:/per");
        return mv;
    }


    //更新用户信息
    @RequestMapping("/upUser")
    public String updateUser(String nickName,String email,String phoneNum, String sign){

        loginservice.updateUser(nickName,email,phoneNum, sign);
        return "redirect:/per";
    }


//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        RedirectAttributes attributes,
//                        HttpServletRequest request) {
//
//        //获取用户填写的验证码
//        String verifycode = request.getParameter("verifycode");
//
//        //验证码校验,获取session域验证码
//        String checkcode = (String)session.getAttribute("checkCodeSession");
//
//        System.out.println(checkcode+"======"+verifycode);
//        //确保验证码一次性  清除验证码session信息
//        session.removeAttribute("checkCodeSession");
//
//        //验证码不正确
//        if(!checkcode.equalsIgnoreCase(verifycode)) {
//
//            //提示信息,放在request域
//            attributes.addFlashAttribute("errormsg", "验证码错误 !");
//            //跳转到登录页面
//            return "redirect:/";
//
//        }
//
//        UserInfo userinfo = loginservice.checkUser(username,password);
//        if (userinfo != null) {
//            userinfo.setPassward(null);
//            return "index";
//        } else {
//            attributes.addFlashAttribute("errormsg", "用户名或密码错误");
//            return "redirect:/";
//        }
//    }






}
