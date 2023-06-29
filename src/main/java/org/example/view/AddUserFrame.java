package org.example.view;

import org.example.dao.UserDao;
import org.example.entity.User;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:27
 * @since JDK17
 */

public class AddUserFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JTextField userTextField = null;
    private JPasswordField passwordTextField = null;
    private JPasswordField confirmPasswordTextField = null;
    private JButton saveBtn = null;
    private JButton resetBtn = null;

    /**
     * This is the default constructor
     */
    public AddUserFrame() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     */
    private void initialize() {
        this.setSize(300, 190);
        this.setContentPane(getJContentPane());
        this.setTitle("添加用户");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel2 = new JLabel();
            jLabel2.setBounds(new Rectangle(26, 80, 69, 18));
            jLabel2.setText("确认密码：");
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(34, 49, 44, 18));
            jLabel1.setText("密码：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(33, 18, 45, 18));
            jLabel.setText("用户：");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabel, null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(jLabel2, null);
            jContentPane.add(getUserName(), null);
            jContentPane.add(getPassword(), null);
            jContentPane.add(getConfirmPassword(), null);
            jContentPane.add(getSaveBtn(), null);
            jContentPane.add(getResetBtn(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes userTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getUserName() {
        if (userTextField == null) {
            userTextField = new JTextField();
            userTextField.setBounds(new Rectangle(95, 18, 166, 22));
        }
        return userTextField;
    }

    /**
     * This method initializes passwordTextField
     *
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPassword() {
        if (passwordTextField == null) {
            passwordTextField = new JPasswordField();
            passwordTextField.setBounds(new Rectangle(95, 49, 164, 22));
            passwordTextField.setEchoChar('*');
        }
        return passwordTextField;
    }

    /**
     * This method initializes confirmPasswordTextField
     *
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getConfirmPassword() {
        if (confirmPasswordTextField == null) {
            confirmPasswordTextField = new JPasswordField();
            confirmPasswordTextField.setBounds(new Rectangle(96, 78, 164, 22));
            confirmPasswordTextField.setEchoChar('*');
        }
        return confirmPasswordTextField;
    }

    /**
     * This method initializes saveBtn
     *
     * @return javax.swing.JButton
     */
    private JButton getSaveBtn() {
        if (saveBtn == null) {
            saveBtn = new JButton();
            saveBtn.setBounds(new Rectangle(41, 111, 84, 23));
            saveBtn.setText("保    存");
            saveBtn.addActionListener(e -> {
                String username = userTextField.getText().trim(); // 获得用户名
                String password = new String(passwordTextField.getPassword()); // 获得密码
                String okPassword = new String(confirmPasswordTextField.getPassword()); // 获得确认密码
                User user = new User(); // 创建User类的实例
                user.setName(username); // 封装用户名
                user.setPwd(password); // 封装密码
                user.setOkPwd(okPassword); // 封装确认密码
                UserDao.insertUser(user); // 保存用户信息
            });

        }
        return saveBtn;
    }

    /**
     * This method initializes resetBtn
     *
     * @return javax.swing.JButton
     */
    private JButton getResetBtn() {
        if (resetBtn == null) {
            resetBtn = new JButton();
            resetBtn.setBounds(new Rectangle(151, 110, 85, 23));
            resetBtn.setText("返    回");
            resetBtn.addActionListener(e -> dispose());
        }
        return resetBtn;
    }

}
