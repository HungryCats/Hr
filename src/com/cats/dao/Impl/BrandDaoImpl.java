package com.cats.dao.Impl;

import com.cats.dao.BrandDao;
import com.cats.pojo.Brand;
import com.cats.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {
    /**
     * 查询所有
     *
     * @return brands
     */
    @Override
    public List<Brand> selectAllBrand() {
        Connection connection = JDBCUtils.getConnection();
        //1.注册驱动
        //2.获取链接
        try {
            //3.定义sql
            String sql = "select * from tb_brand;";

            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            //5.执行sql
            ResultSet resultSet = statement.executeQuery();

            //创建集合
            List<Brand> brands = new ArrayList<>();

            //6.处理数据 遍历resultSet的所有数据
            //6.1 光标向下移动一行，并且判断当前行是否有数据
            while (resultSet.next()) {
                Brand brand = new Brand();

                //6.2 获取数据 getXxx();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String pwd = resultSet.getString("pwd");
                String money = resultSet.getString("money");

                //赋值
                brand.setId(id);
                brand.setName(name);
                brand.setPwd(pwd);
                brand.setMoney(money);

                //存入集合
                brands.add(brand);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return brands;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
    }

    /**
     *
     * @param name
     * @param pwd
     * @param money
     * @return
     */
    @Override
    public Brand addBrand(String name, String pwd, String money) {
        Connection connection = JDBCUtils.getConnection();
        //1.注册驱动
        //2.获取链接

        try {
            //3.定义sql
            String sql = "insert into tb_brand value(0,?,?,?);";
            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            //设置?的值
            statement.setString(1, name);
            statement.setString(2, pwd);
            statement.setString(3, money);
            //5.执行sql
            int i = statement.executeUpdate();
            Brand brand;
            if (i == 1) {
                brand = new Brand();
                brand.setName(name);
                brand.setPwd(pwd);
                brand.setMoney(money);
                return brand;
            } else {
                System.out.println("添加失败");
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

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public Brand deleteById(String id) {
        Connection connection = JDBCUtils.getConnection();
        try {
            //3.定义sql
            String sql = "delete from tb_brand where id=?;";
            String ai = "alter table tb_brand AUTO_INCREMENT=1;";
            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(ai);
            statement.setString(1, id);
            //5.执行sql
            int i = statement.executeUpdate();
            preparedStatement.executeUpdate();
            //释放资源
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
        return null;
    }

    /**
     * 根据id查询，用于修改前回显数据
     *
     * @param id
     * @return brand
     */
    @Override
    public Brand selectById(String id) {
        Connection connection = JDBCUtils.getConnection();
        try {
            //3.定义sql
            String sql = "select * from tb_brand where id=?;";

            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            //5.执行sql
            ResultSet resultSet = statement.executeQuery();

            Brand brand = new Brand();
            //6.处理数据 遍历resultSet的所有数据
            //6.1 光标向下移动一行，并且判断当前行是否有数据
            while (resultSet.next()) {
                brand.setId(resultSet.getInt("id"));
                brand.setName(resultSet.getString("name"));
                brand.setPwd(resultSet.getString("pwd"));
                brand.setMoney(resultSet.getString("money"));
                return brand;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
        return null;
    }

    /**
     * 修改
     *
     * @param brand
     * @param id
     * @return
     */
    @Override
    public int updateBrand(Brand brand, String id) {
        Connection connection = JDBCUtils.getConnection();
        int i;
        try {
            //3.定义sql
            String sql = "update tb_brand set name=?,pwd=?,money=? where id=?;";

            //4.获取执行sql的对象 prepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, brand.getName());
            statement.setString(2, brand.getPwd());
            statement.setString(3, brand.getMoney());
            statement.setObject(4, id);
            i = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.freeConnection(connection);
        }
        return i;
    }
}
