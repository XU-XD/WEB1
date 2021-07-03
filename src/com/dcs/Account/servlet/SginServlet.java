package com.dcs.Account.servlet;
/**
 * projectName:AccountProject
 * author:dcs
 * time:2021/7/1 20:02
 * description:
 */

import com.dcs.Account.domain.Account;
import com.dcs.Account.service.AccountService;
import com.dcs.Account.service.Impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sginservlet")
public class SginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//请求乱码
        response.setContentType("text/html;charset=utf-8");//响应乱码

        //1、获取前端数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");

        try{
            //2、调用业务逻辑
            Account account = new Account(0,username,password,0);
            AccountService  accountService = new AccountServiceImpl();
            //判断两次输入密码是否一致
            if((password).equals(password1)){
                accountService.sgin(account);

                //3、分发转向
                response.getWriter().print("<script>alert('注册成功！');window.location='sign.html'</script>");
            }else{
                response.getWriter().print("<script>alert('两次密码输入不一致！');window.location='sign.html'</script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().print("<script>alert('注册失败！');window.location='sign.html'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}