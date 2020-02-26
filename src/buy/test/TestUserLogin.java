package buy.test;

import buy.dao.user.EasybuyUserImpl;
import buy.entity.EasybuyUser;

import java.sql.SQLException;

public class TestUserLogin {
    public static void main(String[] args) throws SQLException {
        EasybuyUserImpl user=new EasybuyUserImpl();
        EasybuyUser admin=user.getUserByloginName("admin");
        System.out.println(admin.getPassword());
    }
}
