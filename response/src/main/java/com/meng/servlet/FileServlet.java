package com.meng.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 要获取下载文件的路径
        String realPath = "F:\\code\\javaweb-02-servlet\\response\\target\\classes\\1.jpg";
        System.out.println("下载文件路径：" + realPath);
        //2. 下载的文件名是什么？
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //3.  设置想办法Content-Disposition让浏览器能够支持下载我们需要的东西,中文文件名URLEncoder.encode编码，否则会乱码
        //resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName,enc:"utf-8");
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //4.    获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.   创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];

        //6.  获取OutoutStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.  将FileOutputStream流写入到buffer缓冲区
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
      in.close();
        out.close();






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
