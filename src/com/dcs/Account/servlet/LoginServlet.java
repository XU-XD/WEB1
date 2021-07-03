package com.dcs.Account.servlet;
/**
 * projectName:AccountProject
 * author:dcs
 * time:2021/6/27 15:25
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

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//请求乱码
        response.setContentType("text/html;charset=utf-8");//响应乱码

        //获取前端数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            //调用业务逻辑
            AccountService accountService = new AccountServiceImpl();
            Account account = accountService.check(username, password);
            //测试
            System.out.println(account);

            //分发转向
            if(account != null){
                request.setAttribute("account",account);
                request.getRequestDispatcher("wode.html").forward(request, response);
            }else {
                response.getWriter().print("<script>alert('用户名/密码错误');window.location='login.html'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}