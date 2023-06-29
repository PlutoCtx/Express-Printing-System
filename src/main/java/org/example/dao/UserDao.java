package org.example.dao;

import org.example.entity.User;
import org.example.tool.DatabaseConnector;
import org.example.tool.SaveUserStateTool;

import javax.swing.*;
import java.sql.*;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:26
 * @since JDK17
 */

public class UserDao {

    /**
     * 判断用户名和密码的方法
     *
     * @param user
     * 实体类User的实例
     */
    public static boolean okUser(User user) {
        Connection conn = null;
        try {
            String username = user.getName();
            String pwd = user.getPwd();
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn.prepareStatement("select password " +
                    "from tb_user " +
                    "where username = ?");
            ps.setString(1, username); // 为参数赋值
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            if (rs.next() && rs.getRow() > 0) { // 查询到用户信息
                String password = rs.getString(1); // 获得密码
                if (password.equals(pwd)) {
                    SaveUserStateTool.setUsername(username);
                    SaveUserStateTool.setPassword(pwd);
                    return true; // 密码正确返回true
                } else {
                    JOptionPane.showMessageDialog(null, "密码不正确。");
                    return false; // 密码错误返回false
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在。");
                return false; // 用户不存在返回false
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "数据库异常！\n" + ex.getMessage());
            return false; // 数据库异常返回false
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 添加用户信息的方法
     *
     * @param user
     *            实体类User的实例
     */
    public static void insertUser(User user) {
        Connection conn = null;
        try {
            String username = user.getName(); // 获得用户名
            String pwd = user.getPwd(); // 获得密码
            String okPwd = user.getOkPwd(); // 获得确认密码
            if (username == null || username.trim().equals("") || pwd == null || pwd.trim().equals("") || okPwd == null || okPwd.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空。");
                return;
            }
            if (!pwd.trim().equals(okPwd.trim())) {
                JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
                return;
            }
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn.prepareStatement("insert into" +
                    " tb_user (username, password)  " +
                    "values(?,?)");
            ps.setString(1, username.trim()); // 为参数赋值
            ps.setString(2, pwd.trim()); // 为参数赋值
            int flag = ps.executeUpdate(); // 执行SQL语句
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "添加成功。");
            } else {
                JOptionPane.showMessageDialog(null, "添加失败。");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "用户名重复，请换个名称！");
            return;
        } finally {
            try {
                if (conn != null) {
                    conn.close(); // 关闭数据库连接对象
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 修改用户密码的方法
     *
     * @param oldPwd
     *            原密码
     * @param newPwd
     *            新密码
     * @param okPwd
     *            确认新密码
     */
    public static void updateUser(String oldPwd, String newPwd, String okPwd) {
        try {
            if (!newPwd.trim().equals(okPwd.trim())) {
                JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
                return;
            }
            if (!oldPwd.trim().equals(SaveUserStateTool.getPassword())) {
                JOptionPane.showMessageDialog(null, "原密码不正确。");
                return;
            }
            Connection conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn.prepareStatement("update tb_user " +
                    "set password = ? " +
                    "where username = ?");
            ps.setString(1, newPwd.trim()); // 为参数赋值
            ps.setString(2, SaveUserStateTool.getUsername()); // 为参数赋值
            int flag = ps.executeUpdate(); // 执行SQL语句
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "修改成功。");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败。");
            }
            ps.close();
            conn.close(); // 关闭数据库连接
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "数据库异常！" + ex.getMessage());
            return;
        }
    }
}
