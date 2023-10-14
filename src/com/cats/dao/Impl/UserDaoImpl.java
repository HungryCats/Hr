package com.cats.dao.Impl;

import com.cats.dao.UserDao;
import com.cats.pojo.User;
import com.cats.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        Connection connection = JDBCUtils.getConnection();
        //1.注册驱动
        //2.获取链接
        try {
            //3.定义sql
            String sql = "select * from tb_user where username=? and password=?;";

            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            //设置?的值
            statement.setString(1,username);
            statement.setString(2,password);
            //5.执行sql
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
        return null;
    }

    /**
     * 注册操作(添加数据)
     * @param username
     * @param password
     * @return
     */
    @Override
    public User register(String username, String password) {
        Connection connection = JDBCUtils.getConnection();
        //1.注册驱动
        //2.获取链接

        try {
            //3.定义sql
            String sql = "insert into tb_user value(0,?,?);";
            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            //设置?的值
            statement.setString(1,username);
            statement.setString(2,password);
            if (username != "" && password != "") {
                //5.执行sql
                int i = statement.executeUpdate();
                User user;
                if (i == 1) {
                    user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    return user;
                }else {
                    System.out.println("添加失败");
                }
            }else {
                System.out.println("账号或密码不能为空");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
        return null;
    }
}
