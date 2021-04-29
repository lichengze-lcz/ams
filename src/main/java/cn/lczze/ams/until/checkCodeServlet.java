package cn.lczze.ams.until;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
/**
 * Created by lczze on 2020/10/8 17:10
 */
@Controller
public class checkCodeServlet {

    @RequestMapping("/checkCode")
    public void registuser(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setCharacterEncoding("utf-8");
        int width = 100;
        int height = 39;

        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        g.setColor(Color.gray);

        g.fillRect(0, 0, width, height);

        g.setColor(Color.black);

        g.setFont(new Font("",Font.BOLD,22));
        g.drawRect(0, 0, width-1, height-1);

        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";

        Random ran = new Random();

        StringBuilder sb = new StringBuilder();
        for(int i =1; i<= 4; i++) {

            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);

            sb.append(ch);

            g.drawString(ch+"", width/5*i,20);
        }
        String checkCodeSession01 = sb.toString();

        request.getSession().setAttribute("checkCodeSession",checkCodeSession01);
        System.out.println("打印一下checkCodecopyucp类生成的验证码"+checkCodeSession01);
        g.setColor(Color.pink);

        for(int i = 1; i <= 6; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            g.drawLine(x1, x2, y1,y2);
        }
        //3.将图片输出到页面展示    图片生成到内存里了 要输出到客户端，要借助对象 ImageIO. write方法
        // 参数  输出图片，名     图片类型    输出流      该流（输出到浏览器）
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
