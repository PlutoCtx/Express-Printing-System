package org.example.view;

import org.example.dao.ExpressMessageDao;
import org.example.entity.ExpressMessage;
import org.example.panel.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:26
 * @since JDK17
 */

public class AddExpressFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private BackgroundPanel jPanel = null;// 声明自定义背景面板对象
    private JTextField tf_sendName = null;
    private JTextField tf_sendTelephone = null;
    private JTextField tf_sendCompany = null;
    private JTextField tf_sendAddress1 = null;
    private JTextField tf_sendAddress2 = null;
    private JTextField tf_sendAddress3 = null;
    private JTextField tf_sendPostcode = null;
    private JTextField tf_receiveName = null;
    private JTextField tf_receiveTelephone = null;
    private JTextField tf_receiveCompany = null;
    private JTextField tf_receiveAddress1 = null;
    private JTextField tf_receiveAddress2 = null;
    private JTextField tf_receiveAddress3 = null;
    private JTextField tf_receivePostcode = null;
    private JPanel jPanel1 = null;
    private JButton btn_clear = null;
    private JButton btn_save = null;
    private JButton btn_return = null;

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(new FlowLayout());
            jPanel1.add(getBtn_clear(), null);
            jPanel1.add(getBtn_save(), null);
            jPanel1.add(getBtn_return(), null);
        }
        return jPanel1;
    }

    /**
     * This method initializes btn_clear
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_clear() {
        if (btn_clear == null) {
            btn_clear = new JButton();
            btn_clear.setText("清    空");
            btn_clear.addActionListener(e -> {
                tf_sendName.setText(null);
                tf_sendTelephone.setText(null);
                tf_sendCompany.setText(null);
                tf_sendAddress1.setText(null);
                tf_sendAddress2.setText(null);
                tf_sendAddress3.setText(null);
                tf_sendPostcode.setText(null);
                tf_receiveName.setText(null);
                tf_receiveTelephone.setText(null);
                tf_receiveCompany.setText(null);
                tf_receiveAddress1.setText(null);
                tf_receiveAddress2.setText(null);
                tf_receiveAddress3.setText(null);
                tf_receivePostcode.setText(null);
                tf_sendName.requestFocus();
            });
        }
        return btn_clear;
    }

    /**
     * This method initializes btn_save
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_save() {
        if (btn_save == null) {
            btn_save = new JButton();
            btn_save.setText("保    存");
            btn_save.addActionListener(e -> {
                StringBuilder buffer = new StringBuilder();
                ExpressMessage m = new ExpressMessage();
                m.setSendName(tf_sendName.getText().trim());
                m.setSendTelephone(tf_sendTelephone.getText().trim());
                m.setSendCompary(tf_sendCompany.getText().trim());
                m.setSendAddress(tf_sendAddress1.getText().trim() + "|" + tf_sendAddress2.getText().trim() + "|" + tf_sendAddress3.getText().trim());
                m.setSendPostcode(tf_sendPostcode.getText().trim());
                m.setReceiveName(tf_receiveName.getText().trim());
                m.setReceiveTelephone(tf_receiveTelephone.getText().trim());
                m.setReceiveCompary(tf_receiveCompany.getText().trim());
                m.setReceiveAddress(tf_receiveAddress1.getText().trim() + "|" + tf_receiveAddress2.getText().trim() + "|"
                        + tf_receiveAddress3.getText().trim());
                m.setReceivePostcode(tf_receivePostcode.getText().trim());
                buffer.append(tf_sendName.getX()).append(",").append(tf_sendName.getY()).append("/");
                buffer.append(tf_sendTelephone.getX()).append(",").append(tf_sendTelephone.getY()).append("/");
                buffer.append(tf_sendCompany.getX()).append(",").append(tf_sendCompany.getY()).append("/");
                buffer.append(tf_sendAddress1.getX()).append(",").append(tf_sendAddress1.getY()).append("/");
                buffer.append(tf_sendAddress2.getX()).append(",").append(tf_sendAddress2.getY()).append("/");
                buffer.append(tf_sendAddress3.getX()).append(",").append(tf_sendAddress3.getY()).append("/");
                buffer.append(tf_sendPostcode.getX()).append(",").append(tf_sendPostcode.getY()).append("/");
                buffer.append(tf_receiveName.getX()).append(",").append(tf_receiveName.getY()).append("/");
                buffer.append(tf_receiveTelephone.getX()).append(",").append(tf_receiveTelephone.getY()).append("/");
                buffer.append(tf_receiveCompany.getX()).append(",").append(tf_receiveCompany.getY()).append("/");
                buffer.append(tf_receiveAddress1.getX()).append(",").append(tf_receiveAddress1.getY()).append("/");
                buffer.append(tf_receiveAddress2.getX()).append(",").append(tf_receiveAddress2.getY()).append("/");
                buffer.append(tf_receiveAddress3.getX()).append(",").append(tf_receiveAddress3.getY()).append("/");
                buffer.append(tf_receivePostcode.getX()).append(",").append(tf_receivePostcode.getY());
                m.setControlPosition(new String(buffer));
                m.setExpressSize(jPanel.getWidth() + "," + jPanel.getHeight());
                ExpressMessageDao.insertExpress(m);
            });
        }
        return btn_save;
    }

    /**
     * This method initializes btn_return
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_return() {
        if (btn_return == null) {
            btn_return = new JButton();
            btn_return.setText("返    回");
            btn_return.addActionListener(e -> dispose());
        }
        return btn_return;
    }



    public AddExpressFrame() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(1017, 584);
        this.setTitle("添加快递信息");
        this.setContentPane(getJContentPane());
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
            jContentPane.add(getJPanel1(), BorderLayout.SOUTH);
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
            jPanel = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/expressCheck.jpg"))).getImage());
            jPanel.setLayout(null);
            jPanel.add(getTf_sendName(), null);
            jPanel.add(getTf_sendTelephone(), null);
            jPanel.add(getTf_sendCompany(), null);
            jPanel.add(getTf_sendAddress1(), null);
            jPanel.add(getTf_sendAddress2(), null);
            jPanel.add(getTf_sendAddress3(), null);
            jPanel.add(getTf_sendPostcode(), null);
            jPanel.add(getTf_receiveName(), null);
            jPanel.add(getTf_receiveTelephone(), null);
            jPanel.add(getTf_receiveCompany(), null);
            jPanel.add(getTf_receiveAddress1(), null);
            jPanel.add(getTf_receiveAddress2(), null);
            jPanel.add(getTf_receiveAddress3(), null);
            jPanel.add(getTf_receivePostcode(), null);
        }
        return jPanel;
    }

    /**
     * This method initializes tf_sendName
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendName() {
        if (tf_sendName == null) {
            tf_sendName = new JTextField();
            tf_sendName.setBounds(new Rectangle(150, 114, 139, 22));
        }
        return tf_sendName;
    }

    /**
     * This method initializes tf_sendTelephone
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendTelephone() {
        if (tf_sendTelephone == null) {
            tf_sendTelephone = new JTextField();
            tf_sendTelephone.setBounds(new Rectangle(347, 114, 131, 22));
        }
        return tf_sendTelephone;
    }

    /**
     * This method initializes tf_sendCompany
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendCompany() {
        if (tf_sendCompany == null) {
            tf_sendCompany = new JTextField();
            tf_sendCompany.setBounds(new Rectangle(150, 141, 328, 22));
        }
        return tf_sendCompany;
    }

    /**
     * This method initializes tf_sendAddress1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress1() {
        if (tf_sendAddress1 == null) {
            tf_sendAddress1 = new JTextField();
            tf_sendAddress1.setBounds(new Rectangle(115, 179, 362, 22));
        }
        return tf_sendAddress1;
    }

    /**
     * This method initializes tf_sendAddress2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress2() {
        if (tf_sendAddress2 == null) {
            tf_sendAddress2 = new JTextField();
            tf_sendAddress2.setBounds(new Rectangle(114, 205, 362, 22));
        }
        return tf_sendAddress2;
    }

    /**
     * This method initializes tf_sendAddress3
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress3() {
        if (tf_sendAddress3 == null) {
            tf_sendAddress3 = new JTextField();
            tf_sendAddress3.setBounds(new Rectangle(114, 230, 361, 22));
        }
        return tf_sendAddress3;
    }

    /**
     * This method initializes tf_sendPostcode
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendPostcode() {
        if (tf_sendPostcode == null) {
            tf_sendPostcode = new JTextField();
            tf_sendPostcode.setBounds(new Rectangle(366, 256, 109, 22));
        }
        return tf_sendPostcode;
    }

    /**
     * This method initializes tf_receiveName
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveName() {
        if (tf_receiveName == null) {
            tf_receiveName = new JTextField();
            tf_receiveName.setBounds(new Rectangle(151, 311, 142, 22));
        }
        return tf_receiveName;
    }

    /**
     * This method initializes tf_receiveTelephone
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveTelephone() {
        if (tf_receiveTelephone == null) {
            tf_receiveTelephone = new JTextField();
            tf_receiveTelephone.setBounds(new Rectangle(349, 312, 126, 22));
        }
        return tf_receiveTelephone;
    }

    /**
     * This method initializes tf_receiveCompany
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveCompany() {
        if (tf_receiveCompany == null) {
            tf_receiveCompany = new JTextField();
            tf_receiveCompany.setBounds(new Rectangle(150, 339, 325, 22));
        }
        return tf_receiveCompany;
    }

    /**
     * This method initializes tf_receiveAddress1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress1() {
        if (tf_receiveAddress1 == null) {
            tf_receiveAddress1 = new JTextField();
            tf_receiveAddress1.setBounds(new Rectangle(115, 377, 363, 22));
        }
        return tf_receiveAddress1;
    }

    /**
     * This method initializes tf_receiveAddress2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress2() {
        if (tf_receiveAddress2 == null) {
            tf_receiveAddress2 = new JTextField();
            tf_receiveAddress2.setBounds(new Rectangle(115, 404, 362, 22));
        }
        return tf_receiveAddress2;
    }

    /**
     * This method initializes tf_receiveAddress3
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress3() {
        if (tf_receiveAddress3 == null) {
            tf_receiveAddress3 = new JTextField();
            tf_receiveAddress3.setBounds(new Rectangle(116, 430, 362, 22));
        }
        return tf_receiveAddress3;
    }

    /**
     * This method initializes tf_receivePostcode
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receivePostcode() {
        if (tf_receivePostcode == null) {
            tf_receivePostcode = new JTextField();
            tf_receivePostcode.setBounds(new Rectangle(366, 456, 112, 22));
        }
        return tf_receivePostcode;
    }
}
