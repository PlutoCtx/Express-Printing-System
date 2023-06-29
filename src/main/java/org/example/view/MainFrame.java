package org.example.view;

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

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private BackgroundPanel jPanel = null;// 声明自定义背景面板对象
    private JMenuBar jMenuBar = null;
    private JMenu jMenu = null;
    private JMenuItem jMenuItem = null;
    private JMenuItem jMenuItem2 = null;
    private JMenu jMenu1 = null;
    private JMenu jMenu2 = null;
    private JMenuItem jMenuItem3 = null;
    private JMenuItem jMenuItem4 = null;
    private JMenuItem jMenuItem5 = null;
    private JMenuItem jMenuItem1 = null;


    public MainFrame() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     */
    private void initialize() {
        this.setSize(1017, 584);
        this.setJMenuBar(getJJMenuBar());
        this.setTitle("蓝宇快递打印系统");
        this.setContentPane(getJContentPane());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private BackgroundPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/mainFrame.jpg"))).getImage());
            jPanel.setLayout(null);
        }
        return jPanel;
    }

    /**
     * This method initializes jMenuBar
     *
     * @return javax.swing.JMenuBar
     */
    private JMenuBar getJJMenuBar() {
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(getJMenu());
            jMenuBar.add(getJMenu1());
            jMenuBar.add(getJMenu2());
        }
        return jMenuBar;
    }

    /**
     * This method initializes jMenu
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenu() {
        if (jMenu == null) {
            jMenu = new JMenu();
            jMenu.setText("快递单管理");
            jMenu.add(getJMenuItem());
            jMenu.add(getJMenuItem2());
        }
        return jMenu;
    }

    /**
     * This method initializes jMenuItem
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem() {
        if (jMenuItem == null) {
            jMenuItem = new JMenuItem();
            jMenuItem.setText("添加快递单");
            jMenuItem.addActionListener(e -> {
                AddExpressFrame thisClass = new AddExpressFrame();
                thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Toolkit tookit = thisClass.getToolkit();
                Dimension dm = tookit.getScreenSize();
                thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                thisClass.setVisible(true);
            });
        }
        return jMenuItem;
    }

    /**
     * This method initializes jMenuItem2
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem2() {
        if (jMenuItem2 == null) {
            jMenuItem2 = new JMenuItem();
            jMenuItem2.setText("修改快递单");
            jMenuItem2.addActionListener(e -> {
                UpdateExpressFrame thisClass = new UpdateExpressFrame();
                thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Toolkit toolkit = thisClass.getToolkit();
                Dimension dm = toolkit.getScreenSize();
                thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                thisClass.setVisible(true);
            });
        }
        return jMenuItem2;
    }

    /**
     * This method initializes jMenu1
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenu1() {
        if (jMenu1 == null) {
            jMenu1 = new JMenu();
            jMenu1.setText("打印管理");
            jMenu1.add(printExpressCheckMenuItem());
        }
        return jMenu1;
    }

    /**
     * This method initializes jMenu2
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenu2() {
        if (jMenu2 == null) {
            jMenu2 = new JMenu();
            jMenu2.setText("系统");
            jMenu2.add(addUserMenuItem());
            jMenu2.add(updatePasswordMenuItem4());
            jMenu2.add(exitMenuItem());
        }
        return jMenu2;
    }

    /**
     * This method initializes jMenuItem3
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem printExpressCheckMenuItem() {
        if (jMenuItem3 == null) {
            jMenuItem3 = new JMenuItem();
            jMenuItem3.setText("打印快递单");
            jMenuItem3.addActionListener(e -> {
                PrintAndPrintSetFrame thisClass = new PrintAndPrintSetFrame();
                thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Toolkit toolkit = thisClass.getToolkit();
                Dimension dm = toolkit.getScreenSize();
                thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                thisClass.setVisible(true);
            });
        }
        return jMenuItem3;
    }

    /**
     * This method initializes jMenuItem4
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem updatePasswordMenuItem4() {
        if (jMenuItem4 == null) {
            jMenuItem4 = new JMenuItem();
            jMenuItem4.setText("修改用户密码");
            jMenuItem4.addActionListener(e -> {
                UpdatePasswordFrame thisClass = new UpdatePasswordFrame();
                thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Toolkit tookit = thisClass.getToolkit();
                Dimension dm = tookit.getScreenSize();
                thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                thisClass.setVisible(true);
            });
        }
        return jMenuItem4;
    }

    /**
     * This method initializes jMenuItem5
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem exitMenuItem() {
        if (jMenuItem5 == null) {
            jMenuItem5 = new JMenuItem();
            jMenuItem5.setText("退出系统");
            jMenuItem5.addActionListener(e -> System.exit(0));
        }
        return jMenuItem5;
    }

    /**
     * This method initializes jMenuItem1
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem addUserMenuItem() {
        if (jMenuItem1 == null) {
            jMenuItem1 = new JMenuItem();
            jMenuItem1.setText("添加用户");
            jMenuItem1.addActionListener(e -> {
                AddUserFrame thisClass = new AddUserFrame();
                thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Toolkit toolkit = thisClass.getToolkit();
                Dimension dm = toolkit.getScreenSize();
                thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
                thisClass.setVisible(true);
            });
        }
        return jMenuItem1;
    }

}
