package buy.test;

import buy.dao.user.EasybuyUserImpl;
import buy.dao.user.IUser;
import buy.entity.EasybuyUser;

public class TestSaveUser {
    public static void main(String[] args) {
        IUser easybuyUser=new EasybuyUserImpl();
        EasybuyUser user=new EasybuyUser();
        user.setUsername("普通用户");
        user.setType(0);
        user.setPassword("123456");
        user.setLoginname("guess111");
        user.setSex(0);
        user.setMobile("13887675678");
        user.setIdentitycode("14022518998785458x");
        user.setEmail("guess@qq.com");
       int id=easybuyUser.save(user);
        System.out.println(id);
    }
}
