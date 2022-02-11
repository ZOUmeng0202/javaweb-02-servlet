package com.meng.servlet;

import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;
import sun.java2d.pipe.BufferedBufImgOps;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //如何热昂浏览器5秒自动刷新一次
        resp.setHeader("refresh","3");
      //在内存中创建一个图片
        BufferedImage bufferedImage = new BufferedImage(80,20, BufferedImage.TYPE_INT_RGB);
      //得到图片
        Graphics2D g = (Graphics2D)bufferedImage.getGraphics();//笔
        //设置图片的背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        //给图片写数据



    }
    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999)+"";
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<7-num.length();i++){
            sb.append("0");
        }
         String s=sb.toString()+num;
        return num;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
}
