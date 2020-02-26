package buy.dao.user;

import buy.entity.EasybuyUser;
import buy.util.DataSourceUtil;
import buy.util.EmptyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EasybuyUserImpl extends DataSourceUtil implements IUser {
     Connection conn;
     PreparedStatement pstmt;
    ResultSet rs;
    public EasybuyUser TableClass(ResultSet rs)throws  SQLException{
        EasybuyUser user=new EasybuyUser();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setIdentitycode(rs.getString("identityCode"));
        user.setLoginname(rs.getString("loginName"));
        user.setUsername(rs.getString("userName"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setType(rs.getInt("type"));
        return user;
    }

    @Override
    public EasybuyUser getUserByloginName(String loginName) throws SQLException {
        EasybuyUser user=null;

        //编写sql语句
        StringBuffer sql=new StringBuffer("SELECT * FROM easybuy_user WHERE 1=1 ");
        //判断用户名是否为空
        if(!EmptyUtils.isEmpty(loginName)){
            sql.append(" and loginName= ? ");

        }

        //执行sql
        conn=getConn();
        pstmt= conn.prepareStatement(sql.toString());
       pstmt.setObject(1,loginName);
         rs = pstmt.executeQuery();
         //处理结果集
        while (rs.next()){
           user=TableClass(rs);
        }
        return user;
    }
}
