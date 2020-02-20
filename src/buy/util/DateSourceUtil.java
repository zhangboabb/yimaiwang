package buy.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DateSourceUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/easybuy";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    //创建druid数据源对象
    private static DruidDataSource dataSource = null;

    static {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //配置druid数据源
    private static void init() throws SQLException {
        //实例化druid数据源对象
        dataSource = new DruidDataSource();
        //设置druid数据源对象的属性
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        //设置连接池相关属性
        dataSource.setInitialSize(5);//初始化连接池数量
        dataSource.setMaxActive(100);//最大连接数
        dataSource.setMinIdle(1);//最大空闲连接数
        dataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        dataSource.setFilters("stat");//设置监控
    }

    public static Connection getConn() {
        Connection conn = null;
        //加载mysql驱动（开启服务器）
        try {
            Class.forName(DRIVER);
            //如果数据库没有处于连接状态，则创建一个连接
            if (conn == null) {
                conn = dataSource.getConnection(USER, PASSWORD);
                System.out.println("数据库连接成功。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;



    }
    /*
    * 关闭连接的方法
    * */
    public static void  closeConnection(Connection conn){
        if (conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
