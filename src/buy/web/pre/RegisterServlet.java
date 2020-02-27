package buy.web.pre;

import buy.dao.user.EasybuyUserImpl;
import buy.dao.user.IUser;
import buy.entity.EasybuyUser;
import buy.service.user.IUserService;
import buy.service.user.UserServiceImpl;
import buy.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends AbstractServlet {
    IUserService userService=null;

    @Override
    public void init() throws ServletException {
     userService=new UserServiceImpl();
    }

    public String toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/front/register";
    }
/*
* 注册用户
* */
    public ReturnResult doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        ReturnResult result=new ReturnResult();
        //接受前台传过来的用户信息
        String loginName=request.getParameter("loginName");
        //检验loginName的唯一性
        EasybuyUser olduser = userService.getUserByName(loginName);
        if (EmptyUtils.isNotEmpty(olduser)){
            result.returnFail("用户已存在");
            return result;
        }


        String userName=request.getParameter("userName");
        String pwd=request.getParameter("pwd");
        String rePwd=request.getParameter("rePwd");
        Integer sex=Integer.valueOf(request.getParameter("sex"));
        String idCode=request.getParameter("idCode");
        String mobile=request.getParameter("phone");
        String email=request.getParameter("email");

         //封装用户信息
        EasybuyUser user=new EasybuyUser();
        user.setIdentitycode(idCode);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setSex(EmptyUtils.isEmpty(sex)?1:0);
        user.setLoginname(loginName);
        user.setUsername(userName);
        user.setPassword(SecurityUtils.md5Hex(pwd));
        user.setType(Constants.UserType.PRE);

        //信息校验
        result = checkUser(user);
        if (result.getStatus() == Constants.ReturnResult.SUCCESS) {
            //注册用户
            boolean flag = userService.save(user);
            if (!flag) {
                return  result.returnFail("注册失败");
            }else {
                return result.returnFail("注册成功");
            }
        }else {
            return result;
        }
    }
    /*
    * 后端校验数据格式
    * */
    public  ReturnResult checkUser(EasybuyUser user){
        ReturnResult result=new ReturnResult();
        //正则表达式校验
        if (EmptyUtils.isNotEmpty(user.getMobile())) {
            if (!RegUtils.checkMobile(user.getMobile())) {
                result.returnFail("手机格式不正确");
            }
        }
        if (EmptyUtils.isNotEmpty(user.getIdentitycode())) {
            if (!RegUtils.checkMobile(user.getIdentitycode())) {
                result.returnFail("身份证格式不正确");
            }
        }
        if (EmptyUtils.isNotEmpty(user.getEmail())) {
            if (!RegUtils.checkMobile(user.getEmail())) {
                result.returnFail("邮箱格式不正确");
            }
        }
        return result.returnSuccess();
    }

    @Override
    public Class getServletClass() {
        return RegisterServlet.class;
    }
}
