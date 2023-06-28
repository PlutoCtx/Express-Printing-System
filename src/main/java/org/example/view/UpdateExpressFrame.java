package org.example.view;

import org.example.dao.ExpressMessageDao;
import org.example.entity.ExpressMessage;
import org.example.panel.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Vector;

/**
 * Express-Printing-System
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:28
 * @since JDK17
 */

public class UpdateExpressFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private BackgroundPanel jPanel = null;// 声明自定义背景面板对象
    private JTextField sendName = null;
    private JTextField sendTelephone = null;
    private JTextField sendCompany = null;
    private JTextField sendAddress1 = null;
    private JTextField sendAddress2 = null;
    private JTextField sendAddress3 = null;
    private JTextField sendPostcode = null;
    private JTextField receiveName = null;
    private JTextField receiveTelephone = null;
    private JTextField receiveCompany = null;
    private JTextField receiveAddress1 = null;
    private JTextField receiveAddress2 = null;
    private JTextField receiveAddress3 = null;
    private JTextField receivePostcode = null;
    private JPanel jPanel1 = null;
    private JButton btn_next = null;
    private JButton btn_update = null;
    private JButton jButton2 = null;
    private JButton btn_pre = null;
    private int queryRow = -1;
    private Vector<ExpressMessage> queryResultVector = null;
    private String controlPosition = null;
    private String expressSize = null;
    private int id = 0;

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(new FlowLayout());
            jPanel1.add(getBtn_pre(), null);
            jPanel1.add(getBtn_next(), null);
            jPanel1.add(getBtn_update(), null);
            jPanel1.add(getJButton2(), null);
        }
        return jPanel1;
    }

    /**
     * This method initializes btn_next
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_next() {
        if (btn_next == null) {
            btn_next = new JButton();
            btn_next.setText("下一条");
            btn_next.addActionListener(e -> {
                if (queryResultVector != null) {
                    queryRow++;
                    if (queryRow > queryResultVector.size() - 1) {
                        queryRow = queryResultVector.size() - 1;
                        JOptionPane.showMessageDialog(null, "已经是最后一条信息。");
                    }
                    ExpressMessage m = (ExpressMessage) queryResultVector.get(queryRow);
                    showResultValue(m);
                }
            });
        }
        return btn_next;
    }

    /**
     * This method initializes btn_pre
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_pre() {
        if (btn_pre == null) {
            btn_pre = new JButton();
            btn_pre.setText("上一条");
            btn_pre.addActionListener(e -> {
                if (queryResultVector != null) {
                    queryRow--;
                    if (queryRow < 0) {
                        queryRow = 0;
                        JOptionPane.showMessageDialog(null, "已经是第一条信息。");
                    }
                    ExpressMessage m = (ExpressMessage) queryResultVector.get(queryRow);
                    showResultValue(m);
                }
            });
        }
        return btn_pre;
    }

    /**
     * This method initializes btn_update
     *
     * @return javax.swing.JButton
     */
    private JButton getBtn_update() {
        if (btn_update == null) {
            btn_update = new JButton();
            btn_update.setText("修    改");
            btn_update.addActionListener(e -> {
                StringBuilder buffer = new StringBuilder();
                ExpressMessage m = new ExpressMessage();
                m.setId(id);
                m.setSendName(sendName.getText().trim());
                m.setSendTelephone(sendTelephone.getText().trim());
                m.setSendCompary(sendCompany.getText().trim());
                m.setSendAddress(sendAddress1.getText().trim() + "|" +
                        sendAddress2.getText().trim() + "|" +
                        sendAddress3.getText().trim());
                m.setSendPostcode(sendPostcode.getText().trim());
                m.setReceiveName(receiveName.getText().trim());
                m.setReceiveTelephone(receiveTelephone.getText().trim());
                m.setReceiveCompary(receiveCompany.getText().trim());
                m.setReceiveAddress(receiveAddress1.getText().trim() + "|" +
                        receiveAddress2.getText().trim() + "|"
                        + receiveAddress3.getText().trim());
                m.setReceivePostcode(receivePostcode.getText().trim());
                buffer.append(sendName.getX()).append(",").append(sendName.getY()).append("/");
                buffer.append(sendTelephone.getX()).append(",").append(sendTelephone.getY()).append("/");
                buffer.append(sendCompany.getX()).append(",").append(sendCompany.getY()).append("/");
                buffer.append(sendAddress1.getX()).append(",").append(sendAddress1.getY()).append("/");
                buffer.append(sendAddress2.getX()).append(",").append(sendAddress2.getY()).append("/");
                buffer.append(sendAddress3.getX()).append(",").append(sendAddress3.getY()).append("/");
                buffer.append(sendPostcode.getX()).append(",").append(sendPostcode.getY()).append("/");
                buffer.append(receiveName.getX()).append(",").append(receiveName.getY()).append("/");
                buffer.append(receiveTelephone.getX()).append(",").append(receiveTelephone.getY()).append("/");
                buffer.append(receiveCompany.getX()).append(",").append(receiveCompany.getY()).append("/");
                buffer.append(receiveAddress1.getX()).append(",").append(receiveAddress1.getY()).append("/");
                buffer.append(receiveAddress2.getX()).append(",").append(receiveAddress2.getY()).append("/");
                buffer.append(receiveAddress3.getX()).append(",").append(receiveAddress3.getY()).append("/");
                buffer.append(receivePostcode.getX()).append(",").append(receivePostcode.getY());
                m.setControlPosition(new String(buffer));
                m.setExpressSize(jPanel.getWidth() + "," + jPanel.getHeight());
                ExpressMessageDao.updateExpress(m);
                queryResultVector = ExpressMessageDao.queryAllExpress();
                if (queryResultVector != null) {
                    m = (ExpressMessage) queryResultVector.get(queryRow);
                }
            });
        }
        return btn_update;
    }

    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setText("返    回");
            jButton2.addActionListener(e -> dispose());
        }
        return jButton2;
    }



    public UpdateExpressFrame() {
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
        this.setTitle("修改快递信息");
        this.setContentPane(getJContentPane());
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                queryResultVector = ExpressMessageDao.queryAllExpress();
                if (queryResultVector != null) {
                    queryRow++;
                    ExpressMessage m = (ExpressMessage) queryResultVector.get(queryRow);
                    showResultValue(m);
                }
            }
        });
    }

    private void showResultValue(ExpressMessage m) {
        id = m.getId();
        sendName.setText(m.getSendName());
        sendTelephone.setText(m.getSendTelephone());
        sendCompany.setText(m.getSendCompary());
        String addressValue1 = m.getSendAddress();
        sendAddress1.setText(addressValue1.substring(0, addressValue1.indexOf("|")));
        sendAddress2.setText(addressValue1.substring(addressValue1.indexOf("|") + 1, addressValue1.lastIndexOf("|")));
        sendAddress3.setText(addressValue1.substring(addressValue1.lastIndexOf("|") + 1));
        sendPostcode.setText(m.getSendPostcode());
        receiveName.setText(m.getReceiveName());
        receiveTelephone.setText(m.getReceiveTelephone());
        receiveCompany.setText(m.getReceiveCompary());
        String addressValue2 = m.getReceiveAddress();
        receiveAddress1.setText(addressValue2.substring(0, addressValue2.indexOf("|")));
        receiveAddress2.setText(addressValue2.substring(addressValue2.indexOf("|") + 1, addressValue2.lastIndexOf("|")));
        receiveAddress3.setText(addressValue2.substring(addressValue2.lastIndexOf("|") + 1));
        receivePostcode.setText(m.getReceivePostcode());
        controlPosition = m.getControlPosition();
        expressSize = m.getExpressSize();
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
            jPanel = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(LoginFrame.class.getResource("/蓝宇快递单.jpg"))).getImage());
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
     * This method initializes sendName
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendName() {
        if (sendName == null) {
            sendName = new JTextField();
            sendName.setBounds(new Rectangle(150, 114, 139, 22));
            // 149, 123, 139, 22
        }
        return sendName;
    }

    /**
     * This method initializes sendTelephone
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendTelephone() {
        if (sendTelephone == null) {
            sendTelephone = new JTextField();
            sendTelephone.setBounds(new Rectangle(347, 114, 131, 22));
        }
        return sendTelephone;
    }

    /**
     * This method initializes sendCompany
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendCompany() {
        if (sendCompany == null) {
            sendCompany = new JTextField();
            sendCompany.setBounds(new Rectangle(150, 141, 328, 22));
        }
        return sendCompany;
    }

    /**
     * This method initializes sendAddress1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress1() {
        if (sendAddress1 == null) {
            sendAddress1 = new JTextField();
            sendAddress1.setBounds(new Rectangle(115, 179, 362, 22));
        }
        return sendAddress1;
    }

    /**
     * This method initializes sendAddress2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress2() {
        if (sendAddress2 == null) {
            sendAddress2 = new JTextField();
            sendAddress2.setBounds(new Rectangle(114, 205, 362, 22));
        }
        return sendAddress2;
    }

    /**
     * This method initializes sendAddress3
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendAddress3() {
        if (sendAddress3 == null) {
            sendAddress3 = new JTextField();
            sendAddress3.setBounds(new Rectangle(114, 230, 361, 22));
        }
        return sendAddress3;
    }

    /**
     * This method initializes sendPostcode
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sendPostcode() {
        if (sendPostcode == null) {
            sendPostcode = new JTextField();
            sendPostcode.setBounds(new Rectangle(366, 256, 109, 22));
        }
        return sendPostcode;
    }

    /**
     * This method initializes receiveName
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveName() {
        if (receiveName == null) {
            receiveName = new JTextField();
            receiveName.setBounds(new Rectangle(151, 311, 142, 22));
        }
        return receiveName;
    }

    /**
     * This method initializes receiveTelephone
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveTelephone() {
        if (receiveTelephone == null) {
            receiveTelephone = new JTextField();
            receiveTelephone.setBounds(new Rectangle(349, 312, 126, 22));
        }
        return receiveTelephone;
    }

    /**
     * This method initializes receiveCompany
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveCompany() {
        if (receiveCompany == null) {
            receiveCompany = new JTextField();
            receiveCompany.setBounds(new Rectangle(150, 339, 325, 22));
        }
        return receiveCompany;
    }

    /**
     * This method initializes receiveAddress1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress1() {
        if (receiveAddress1 == null) {
            receiveAddress1 = new JTextField();
            receiveAddress1.setBounds(new Rectangle(115, 377, 363, 22));
        }
        return receiveAddress1;
    }

    /**
     * This method initializes receiveAddress2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress2() {
        if (receiveAddress2 == null) {
            receiveAddress2 = new JTextField();
            receiveAddress2.setBounds(new Rectangle(115, 404, 362, 22));
        }
        return receiveAddress2;
    }

    /**
     * This method initializes receiveAddress3
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receiveAddress3() {
        if (receiveAddress3 == null) {
            receiveAddress3 = new JTextField();
            receiveAddress3.setBounds(new Rectangle(116, 430, 362, 22));
        }
        return receiveAddress3;
    }

    /**
     * This method initializes receivePostcode
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTf_receivePostcode() {
        if (receivePostcode == null) {
            receivePostcode = new JTextField();
            receivePostcode.setBounds(new Rectangle(366, 456, 112, 22));
        }
        return receivePostcode;
    }
}

