package org.example.view;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.panel.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:27
 * @since JDK17
 */

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private BackgroundPanel jPanel = null;// 声明自定义背景面板对象
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JTextField tf_username = null;
    private JPasswordField pf_password = null;
    private JButton btn_login = null;
    private JButton btn_reset = null;
    private JButton btn_exit = null;

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(221, 176, 63, 18));
            jLabel1.setText("密    码：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(220, 141, 63, 18));
            jLabel.setText("用    户：");
            jPanel = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/loginin.jpg"))).getImage());
            jPanel.setLayout(null);
            jPanel.add(jLabel, null);
            jPanel.add(jLabel1, null);
            jPanel.add(getTf_username(), null);
            jPanel.add(getPf_password(), null);
            jPanel.add(getBtn_login(), null);
            jPanel.add(getBtn_reset(), null);
            jPanel.add(getBtn_exit(), null);
        }
        return jPanel;
    }

    /**
     * This method initializes tf_username
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_username() {
        if (tf_username == null) {
            tf_username = new JTextField();
            tf_username.setBounds(new Rectangle(290, 140, 143, 22));
            tf_username.addActionListener(e -> pf_password.requestFocus());
        }
        return tf_username;
    }

    /**
     * This method initializes pf_password
     *
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPf_password() {
        if (pf_password == null) {
            pf_password = new JPasswordField();
            pf_password.setBounds(new Rectangle(290, 175, 141, 22));
            pf_password.setEchoChar('*');
            pf_password.addActionListener(e -> {
                String username = tf_username.getText().trim();
                String password = new String(pf_password.getPassword());
                User user = new User();
                user.setName(username);
                user.setPwd(password);
                if (UserDao.okUser(user)) {
                    MainFrame thisClass = new MainFrame();
                    thisClass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    Toolkit tookit = thisClass.getToolkit();
                    Dimension dm = tookit.getScreenSize();
                    thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                    thisClass.setVisible(true);
                    dispose();
                }
            });
        }
        return pf_password;
    }

    /**
     * This method initializes btn_login
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_login() {
        if (btn_login == null) {
            btn_login = new JButton();
            btn_login.setBounds(new Rectangle(221, 211, 56, 22));
            btn_login.setRolloverIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/login.jpg"))));
            btn_login.setIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/login01.jpg"))));
            btn_login.setMargin(new Insets(0, 0, 0, 0));
            btn_login.addActionListener(e -> {
                String username = tf_username.getText().trim();
                String password = new String(pf_password.getPassword());
                User user = new User();
                user.setName(username);
                user.setPwd(password);
                if (UserDao.okUser(user)) {
                    MainFrame thisClass = new MainFrame();
                    thisClass.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    Toolkit tookit = thisClass.getToolkit();
                    Dimension dm = tookit.getScreenSize();
                    thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                    thisClass.setVisible(true);
                    dispose();
                }
            });
        }
        return btn_login;
    }

    /**
     * This method initializes btn_reset
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_reset() {
        if (btn_reset == null) {
            btn_reset = new JButton();
            btn_reset.setBounds(new Rectangle(299, 211, 55, 23));
            btn_reset.setRolloverIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/reset.jpg"))));
            btn_reset.setIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/reset01.jpg"))));
            btn_reset.setMargin(new Insets(0, 0, 0, 0));
            btn_reset.addActionListener(e -> {
                tf_username.setText("");
                pf_password.setText("");
                tf_username.requestFocus();
            });
        }
        return btn_reset;
    }

    /**
     * This method initializes btn_exit
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_exit() {
        if (btn_exit == null) {
            btn_exit = new JButton();
            btn_exit.setBounds(new Rectangle(374, 211, 53, 22));
            btn_exit.setRolloverIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/quit.jpg"))));
            btn_exit.setIcon(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/quit01.jpg"))));
            btn_exit.setMargin(new Insets(0, 0, 0, 0));
            btn_exit.addActionListener(e -> System.exit(0));
        }
        return btn_exit;
    }


    /**
     * This is the default constructor
     */
    public LoginFrame() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     */
    private void initialize() {
        this.setSize(476, 301);
        this.setContentPane(getJContentPane());
        this.setTitle("系统登录");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getJPanel(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

}
