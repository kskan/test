package com.imooc.servicempl;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptcahCode {
    public static String drawImage(HttpServletResponse response){
//     验证码
        StringBuilder bulider =new StringBuilder();
        for(int i=0;i<4;i++){
            bulider.append(rendomChar());
        }
        String code=bulider.toString();
//      在这里设置长宽
        int width=70;
        int height=20;

//      建立buferedImage对象，制定图片的长度和宽度以及色彩
        BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g=bi.createGraphics();
//      设置颜色和字体样式
        Font font=new Font("黑体",Font.PLAIN,20);
        Color color=new Color(0,0,255);
        g.setFont(font);
        g.setColor(color);

        g.setBackground(new Color(226,226,200));
        g.clearRect(0,0,width,height);

        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code,context);

        double x = (width - bounds.getWidth())/2;
        double y = (height - bounds.getHeight())/2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code,(int)x,(int)baseY);
        g.dispose();
        try{
            ImageIO.write(bi,"jpg",response.getOutputStream());
            response.flushBuffer();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return code;
    }

    private static char rendomChar() {
        String string = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        Random random = new Random();
        return string.charAt(random.nextInt(string.length()));
    }

}
