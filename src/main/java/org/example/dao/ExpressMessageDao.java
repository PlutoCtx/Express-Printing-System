package org.example.dao;

import org.example.entity.ExpressMessage;
import org.example.tool.DatabaseConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:26
 * @since JDK17
 */

public class ExpressMessageDao {

    public static void insertExpress(ExpressMessage m) {
        if (m.getSendName() == null || "".equals(m.getSendName().trim())) {
            JOptionPane.showMessageDialog(null, "寄件人信息不能为空");
            return;
        }
        if (m.getSendTelephone() == null || "".equals(m.getSendTelephone().trim())) {
            JOptionPane.showMessageDialog(null, "寄件人电话不能为空");
            return;
        }
        if (m.getSendCompary() == null || "".equals(m.getSendCompary().trim())) {
            JOptionPane.showMessageDialog(null, "寄件人公司不能为空");
            return;
        }
        if (m.getSendAddress() == null || "||".equals(m.getSendAddress().trim())) {
            JOptionPane.showMessageDialog(null, "寄件人地址不能为空");
            return;
        }
        if (m.getSendPostcode() == null || "".equals(m.getSendPostcode().trim())) {
            JOptionPane.showMessageDialog(null, "寄件人邮编不能为空");
            return;
        }

        if (m.getReceiveName() == null || "".equals(m.getReceiveName().trim())) {
            JOptionPane.showMessageDialog(null, "收件人姓名不能为空");
            return;
        }
        if (m.getReceiveTelephone() == null || "".equals(m.getReceiveTelephone().trim())) {
            JOptionPane.showMessageDialog(null, "收件人电话不能为空");
            return;
        }
        if (m.getReceiveCompary() == null || "".equals(m.getReceiveCompary().trim())) {
            JOptionPane.showMessageDialog(null, "收件人公司不能为空");
            return;
        }
        if (m.getReceiveAddress() == null || "||".equals(m.getReceiveAddress().trim())) {
            JOptionPane.showMessageDialog(null, "收件人地址不能为空");
            return;
        }
        if (m.getReceivePostcode() == null || "".equals(m.getReceivePostcode().trim())) {
            JOptionPane.showMessageDialog(null, "收件人邮编不能为空");
            return;
        }
        Connection conn = null; // 声明数据库连接
        // 声明PreparedStatement对象
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            ps = conn.prepareStatement("insert into " +
                            "tb_receiveSendMessage (" +
                            "sendName, " +
                            "sendTelephone, " +
                            "sendCompary, " +
                            "sendAddress, " +
                            "sendPostcode, " +
                            "receiveName, " +
                            "recieveTelephone, " +
                            "recieveCompary, " +
                            "receiveAddress, " +
                            "receivePostcode, " +
                            "ControlPosition, " +
                            "expressSize)  " +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // 为参数赋值
            ps.setString(1, m.getSendName());
            ps.setString(2, m.getSendTelephone());
            ps.setString(3, m.getSendCompary());
            ps.setString(4, m.getSendAddress());
            ps.setString(5, m.getSendPostcode());
            ps.setString(6, m.getReceiveName());
            ps.setString(7, m.getReceiveTelephone());
            ps.setString(8, m.getReceiveCompary());
            ps.setString(9, m.getReceiveAddress());
            ps.setString(10, m.getReceivePostcode());
            ps.setString(11, m.getControlPosition());
            ps.setString(12, m.getExpressSize());
            int flag = ps.executeUpdate();
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "添加成功。");
            } else {
                JOptionPane.showMessageDialog(null, "添加失败。");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "添加失败！");
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateExpress(ExpressMessage m) {
        Connection conn = null; // 声明数据库连接
        // 声明PreparedStatement对象
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            ps = conn.prepareStatement("update tb_receiveSendMessage " +
                            "set sendName = ?, " +
                            "sendTelephone = ?, " +
                            "sendCompary = ?, " +
                            "sendAddress = ?, " +
                            "sendPostcode = ?, " +
                            "receiveName = ?, " +
                            "recieveTelephone = ?, " +
                            "recieveCompary = ?, " +
                            "receiveAddress = ?, " +
                            "receivePostcode = ?, " +
                            "ControlPosition = ?, " +
                            "expressSize = ? " +
                            "where id = ?");
            // 为参数赋值
            ps.setString(1, m.getSendName());
            ps.setString(2, m.getSendTelephone());
            ps.setString(3, m.getSendCompary());
            ps.setString(4, m.getSendAddress());
            ps.setString(5, m.getSendPostcode());
            ps.setString(6, m.getReceiveName());
            ps.setString(7, m.getReceiveTelephone());
            ps.setString(8, m.getReceiveCompary());
            ps.setString(9, m.getReceiveAddress());
            ps.setString(10, m.getReceivePostcode());
            ps.setString(11, m.getControlPosition());
            ps.setString(12, m.getExpressSize());
            ps.setInt(13, m.getId());
            int flag = ps.executeUpdate();
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "修改成功。");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败。");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "修改失败！" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<ExpressMessage> queryExpress() {

        Connection conn = null; // 声明数据库连接
        // 声明PreparedStatement对象
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            ps = conn.prepareStatement("select " +
                    "sendName, " +
                    "sendTelephone, " +
                    "sendCompary, " +
                    "sendAddress, " +
                    "sendPostcode," +
                    "receiveName, " +
                    "recieveTelephone, " +
                    "recieveCompary," +
                    "receiveAddress, " +
                    "receivePostcode, " +
                    "ControlPosition," +
                    "expressSize " +
                    "from tb_receiveSendMessage");
            ResultSet rs = ps.executeQuery();
            Vector<ExpressMessage> v = new Vector<ExpressMessage>();
            while (rs.next()) {
                ExpressMessage m = new ExpressMessage();
                m.setSendName(rs.getString(1));
                m.setSendTelephone(rs.getString(2));
                m.setSendCompary(rs.getString(3));
                m.setSendAddress(rs.getString(4));
                m.setSendPostcode(rs.getString(5));
                m.setReceiveName(rs.getString(6));
                m.setReceiveTelephone(rs.getString(7));
                m.setReceiveCompary(rs.getString(8));
                m.setReceiveAddress(rs.getString(9));
                m.setReceivePostcode(rs.getString(10));
                m.setControlPosition(rs.getString(11));
                m.setExpressSize(rs.getString(12));
                v.add(m);
            }
            return v;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<ExpressMessage> queryAllExpress() {
        Connection conn = null; // 声明数据库连接
        // 声明PreparedStatement对象
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnector.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            ps = conn.prepareStatement("select " +
                            "id, " +
                            "sendName, " +
                            "sendTelephone, " +
                            "sendCompary, " +
                            "sendAddress, " +
                            "sendPostcode, " +
                            "receiveName, " +
                            "recieveTelephone, " +
                            "recieveCompary, " +
                            "receiveAddress, " +
                            "receivePostcode, " +
                            "ControlPosition, " +
                            "expressSize " +
                            "from tb_receiveSendMessage");
            ResultSet rs = ps.executeQuery();
            Vector<ExpressMessage> v = new Vector<ExpressMessage>();
            while (rs.next()) {
                ExpressMessage m = new ExpressMessage();
                m.setId(rs.getInt(1));
                m.setSendName(rs.getString(2));
                m.setSendTelephone(rs.getString(3));
                m.setSendCompary(rs.getString(4));
                m.setSendAddress(rs.getString(5));
                m.setSendPostcode(rs.getString(6));
                m.setReceiveName(rs.getString(7));
                m.setReceiveTelephone(rs.getString(8));
                m.setReceiveCompary(rs.getString(9));
                m.setReceiveAddress(rs.getString(10));
                m.setReceivePostcode(rs.getString(11));
                m.setControlPosition(rs.getString(12));
                m.setExpressSize(rs.getString(13));
                v.add(m);
            }
            return v;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
