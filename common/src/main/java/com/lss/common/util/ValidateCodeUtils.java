/**
 * @project:     lssplatform
 * @title:       ValidateCodeUtils.java
 */
package com.lss.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: ValidateCodeUtils
 * @description: 验证码工具类
 */
public class ValidateCodeUtils {
    public static final char[] CHARS_LETTER = "abcdefghjkmnprstuwxz".toCharArray();
    public static final char[] CHARS_DIGIT = "2345678".toCharArray();
    public static final int IMAGE_WIDTH = 160;
    public static final int IMAGE_HEIGHT = 80;
    /*** 字体名称表 */
    //private static final String[] fontNames = {"Times New Roman","Arial","Georgia","Comic Sans MS","Verdana"};
    //private static final String[] fontNames = { "Arial","Comic Sans MS"};
    private static final String[] fontNames = { Font.SANS_SERIF };
    /*** 字体样式表 */
    private static final int[] fontStylesBold = { Font.BOLD, Font.ITALIC|Font.BOLD };
    private static final int[] fontStylesNonbold = { Font.PLAIN, Font.ITALIC };
    //private static final int[] fontStyles = { Font.PLAIN, Font.ITALIC };
    /*** 彩色RGB表 */
    private static final int[][] colourRgbs = {{0,0,139},{0,0,205},{0,0,255},{0,103,184},{0,112,201},{0,114,178},
            {0,120,215},{0,158,115},{0,180,194},{0,59,77},{1,32,79},{128,0,0},
            {128,0,128},{139,0,0},{139,69,19},{148,38,69},{165,42,42},{175,63,31},
            {178,34,34},{188,4,13},{196,85,0},{199,21,133},{204,121,167},{213,94,0},
            {220,20,60},{230,159,0},{231,33,30},{240,196,84},{240,228,66},{25,25,112},
            {255,200,61},{30,144,255},{37,66,130},{51,102,153},{65,105,225},{70,130,180},
            {75,0,130},{86,180,233},{89,36,57}};
    /*** 黑色RGB表 */
    private static final int[][] blackRgbs = {{0,0,0},{16,16,16},{32,32,32},{48,48,48},{64,64,64}};
    
    /** 
     * 生成验证码图片
     * @param validateCodes 验证码
     * @return 图片对象
     * @author wangyg
     * @date:    2019.03.11 16:50:06
     * @since JDK 1.7
     */
    public static Image generateImage(char[] validateCodes) {
        Graphics g = null;
        try {
            BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
            g = image.getGraphics();
            
            drawBackground(g);
            drawValidateCodes(g, validateCodes);
            return image;
        }finally {
            if(g!=null) g.dispose();
        }
    }
    
    /** 
     * 生成验证码字符（4位）
     * @return 验证码字符
     * @author wangyg
     * @date:    2019.03.11 16:50:49
     * @since JDK 1.7
     */
    public static char[] generateValidateCode() {
        Random random = new Random();
        char[] chars = new char[4];
        for (int i = 0; i < 4; i++) {
            if(random.nextInt(100)>83){//取字母
                int index =  random.nextInt(CHARS_LETTER.length);
                chars[i] = random.nextInt(100)>90?CHARS_LETTER[index]:Character.toUpperCase(CHARS_LETTER[index]);
            }else{//取数字
                chars[i] = CHARS_DIGIT[random.nextInt(CHARS_DIGIT.length)];
            }
        }
        return chars;
    }
    
    /** 
     * 绘制验证码图片背景
     * @param g 图片对象
     * @author wangyg
     * @date:    2019.03.11 16:51:24
     * @since JDK 1.7
     */
    private static void drawBackground(Graphics g) {
        Random random = new Random();
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        for (int i = 0; i < 64; i++) {
            ((Graphics2D)g).setStroke(new BasicStroke( (float)(0.1 + random.nextInt(371) / 100 )));
            int x = random.nextInt(IMAGE_WIDTH - 17);
            int y = random.nextInt(IMAGE_HEIGHT - 17);
            g.setColor(randomColor());
            g.drawOval(x+3+random.nextInt(11), y+3+random.nextInt(13), 2, 2);
            g.setColor(randomColor());
            int x1 = 3 + random.nextInt(IMAGE_WIDTH - 7);
            int y1 = 3 + random.nextInt(IMAGE_HEIGHT - 7);
            int x2 = 3 + random.nextInt(IMAGE_WIDTH - 7);
            int y2 = 3 + random.nextInt(IMAGE_HEIGHT - 7);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /** 
     * 绘制验证码
     * @param g 图片对象
     * @param chars 验证码字符
     * @author wangyg
     * @date:    2019.03.11 16:52:01
     * @since JDK 1.7
     */
    private static void drawValidateCodes(Graphics g, char[] chars) {
        Random random = new Random();
        int mode = (random.nextInt(100)>50)?0:1;
        for(int i=0;i<chars.length;i++) {
            int angdeg = 37 - random.nextInt(75);
            int offsetX = 1 - angdeg/5;
            int offsetY = 3 - angdeg/3;
            //System.out.println(angdeg +" "+offsetX+" "+offsetY);
            g.setColor(randomColor(mode,i));
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(angdeg), 0, 0);
            int fontStyle = fontStylesBold[random.nextInt(fontStylesBold.length)];
            if(random.nextInt(100)>71){
                fontStyle = fontStylesNonbold[random.nextInt(fontStylesNonbold.length)];
            }
            Font font = new Font(fontNames[random.nextInt(fontNames.length)], fontStyle, 60);
            Font rotatedFont = font.deriveFont(affineTransform);
            g.setFont(rotatedFont);
            g.drawString(String.valueOf(chars[i]),33*i+7+offsetX,55+offsetY);
        }
    }
    
    /** 
     * 生成随机颜色（黑白彩色相间）
     * @param mode 模式
     * @param index 索引
     * @return 颜色对象
     * @author wangyg
     * @date:    2019.03.11 16:52:01
     * @since JDK 1.7
     */
    private static Color randomColor(int mode,int index) {
        Random random = new Random();
        if(index%2==0) {
            if(0==mode) {//首位颜色为彩色
                int colorIndex = random.nextInt(colourRgbs.length);
                return new Color(colourRgbs[colorIndex][0], colourRgbs[colorIndex][1], colourRgbs[colorIndex][2]);
            }else {
                int colorIndex = random.nextInt(blackRgbs.length);
                return new Color(blackRgbs[colorIndex][0], blackRgbs[colorIndex][1], blackRgbs[colorIndex][2]);                
            }
        }else {
            if(0==mode) {//首位颜色为彩色
                int colorIndex = random.nextInt(blackRgbs.length);
                return new Color(blackRgbs[colorIndex][0], blackRgbs[colorIndex][1], blackRgbs[colorIndex][2]);                                
            }else {
                int colorIndex = random.nextInt(colourRgbs.length);
                return new Color(colourRgbs[colorIndex][0], colourRgbs[colorIndex][1], colourRgbs[colorIndex][2]);
            }            
        }
    }
    
    /** 
     * 生成随机颜色
     * @return 颜色对象
     * @author wangyg
     * @date:    2019.03.11 16:52:01
     * @since JDK 1.7
     */
    private static Color randomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = Math.min( (510 - red - blue), random.nextInt(256) );
        return new Color(red, green, blue);
    }
    
    public static void main(String[] args) throws IOException {
        for(int i=1;i<=3;i++) {
            char[] codes = generateValidateCode();//{'M','M','M','M'};
            System.out.println(String.valueOf(codes));
            Image image = generateImage(codes);
            ImageIO.write((BufferedImage) image, "PNG", new File("f:\\validateCode-"+i+".png"));
        }
    }
}
