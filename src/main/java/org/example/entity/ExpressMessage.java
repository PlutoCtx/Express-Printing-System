package org.example.entity;

import lombok.Data;

/**
 * Express-Printing-System
 * 快递
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/6/27 23:25
 * @since JDK17
 */

@Data
public class ExpressMessage {

    private int id = 0;
    /**
        寄件人信息必须填写
     */
    private String sendName = null;
    /**
     * 寄件人电话必须填写
     */
    private String sendTelephone = null;
    /**
     * 寄件人公司必须填写
     */
    private String sendCompary = null;
    /**
     * 寄件人地址必须填写
     */
    private String sendAddress = null;
    /**
     * 寄件人邮编必须填写
     */
    private String sendPostcode = null;
    /**
     * 收件人姓名必须填写
     */
    private String receiveName = null;
    /**
     * 收件人电话必须填写
     */
    private String receiveTelephone = null;
    /**
     * 收件人公司必须填写
     */
    private String receiveCompary = null;
    /**
     * 收件人地址必须填写
     */
    private String receiveAddress = null;
    /**
     * 收件人邮编必须填写
     */
    private String receivePostcode = null;
    /**
     * 快递单上添加信息的组件位置（坐标）
     */
    private String ControlPosition = null;
    /**
     * 快递单的尺寸（大小）
     */
    private String expressSize = null;

}
