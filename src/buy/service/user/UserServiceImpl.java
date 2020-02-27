package buy.service.user;

import buy.dao.user.EasybuyUserImpl;
import buy.dao.user.IUser;
import buy.entity.EasybuyUser;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService{
     IUser uDao=new EasybuyUserImpl();
    @Override
    public EasybuyUser getUserByName(String loginName)
            throws SQLException, ClassNotFoundException {

        return uDao.getUserByloginName(loginName);
    }

    @Override
    public boolean save(EasybuyUser user) {

        return uDao.save(user)>0?true:false;
    }
}
