package buy.web.pre;

import buy.entity.EasybuyUser;
import buy.service.user.IUserService;
import buy.service.user.UserServiceImpl;
import buy.util.EmptyUtils;
import buy.util.ReturnResult;
import buy.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends AbstractServlet {
    //依赖于service层
    IUserService userService;

    @Override
    public void init() throws ServletException {
        userService=new UserServiceImpl();
    }
/*
* 实例化servlet
* */

    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }

    public String toLogin(HttpServletRequest request,HttpServletResponse response){



        return "/front/login";
    }

    public ReturnResult login(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException {
        ReturnResult result=new ReturnResult();

        //获取参数： 在登录页面输入的用户名和密码
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        //根据loginName获取用户对象
        EasybuyUser user = userService.getUserByName(loginName);

        //判断用户对象是否存在
        if (EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在！");

        }else {
            //比较用户的信息
            if (user.getPassword().equals(SecurityUtils.md5Hex(password))){
                request.getSession().setAttribute("loginUser",user);
                result.returnSuccess("登陆成功");

            }else {
                result.returnFail("密码错误");
            }
        }
        return result;

    }



}
