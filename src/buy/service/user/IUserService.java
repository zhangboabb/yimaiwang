package buy.service.user;

import buy.entity.EasybuyUser;

import java.sql.SQLException;

public interface IUserService {
    EasybuyUser getUserByName(String loginName) throws SQLException, ClassNotFoundException;
    boolean save(EasybuyUser user);

}
