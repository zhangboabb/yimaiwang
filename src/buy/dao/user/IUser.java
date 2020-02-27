package buy.dao.user;

import buy.entity.EasybuyUser;

import java.sql.SQLException;

public interface IUser {
    EasybuyUser getUserByloginName(String loginName) throws SQLException;
    int save(EasybuyUser user);
}
