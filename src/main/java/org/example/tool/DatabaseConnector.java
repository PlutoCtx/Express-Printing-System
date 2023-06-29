package org.example.tool;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:25
 * @since JDK17
 */

public class DatabaseConnector {
    private static final DatabaseConnector DATABASE_CONNECTOR = new DatabaseConnector(); // 声明DatabaseConnector类的静态实例

    /**
     * 构造方法，加载数据库驱动
     */
    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "数据库驱动加载失败，请将JTDS驱动配置到构建路径中。\n" + e.getMessage());
        }
    }

    /**
     * 获得数据库连接的方法
     *
     * @return Connection
     */
    public static Connection getConn() {
        try {
            Connection conn = null; // 定义数据库连接
            String url = "jdbc:mysql://localhost:3306/expressPrintingSystem"; // 数据库db_Express的URL
            String username = "root"; // 数据库的用户名
            String password = "Shangxiao111"; // 数据库密码
            conn = DriverManager.getConnection(url, username, password); // 建立连接
            return conn; // 返回连接
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库连接失败。\n请检查数据库用户名和密码是否正确。" + e.getMessage());
            return null;
        }
    }
}
