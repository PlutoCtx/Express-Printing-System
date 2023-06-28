/*
 Navicat Premium Data Transfer

 Source Server         : testmmysql
 Source Server Type    : MySQL
 Source Server Version : 100605
 Source Host           : localhost:3306
 Source Schema         : expressprintingsystem

 Target Server Type    : MySQL
 Target Server Version : 100605
 File Encoding         : 65001

 Date: 28/06/2023 18:19:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_receivesendmessage
-- ----------------------------
DROP TABLE IF EXISTS `tb_receivesendmessage`;
CREATE TABLE `tb_receivesendmessage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sendName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sendTelephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sendCompary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sendAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sendPostcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `receiveName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recieveTelephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recieveCompary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `receiveAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `receivePostcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ControlPosition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `expressSize` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_receivesendmessage
-- ----------------------------
INSERT INTO `tb_receivesendmessage` VALUES (1, '123', '111', '1234', '123|123|12', '1233', '23', '', '', '||', '', '150,114/347,114/150,141/115,179/114,205/114,230/366,256/151,311/349,312/150,339/115,377/115,404/116,430/366,456', '1003,511');
INSERT INTO `tb_receivesendmessage` VALUES (2, '111', '12321231233123', '333', '||', '', '', '', '', '||', '', '150,114/347,114/150,141/115,179/114,205/114,230/366,256/151,311/349,312/150,339/115,377/115,404/116,430/366,456', '1003,511');
INSERT INTO `tb_receivesendmessage` VALUES (3, '11231', '1111111111', '123123123123', '1233123123123|12312312312|12331231233', '12233123123', '123123123', '123312312', '12233123123123123', '1231233|asfsdfsdsdfgd|sdgfdrfgedr', '346456', '150,114/347,114/150,141/115,179/114,205/114,230/366,256/151,311/349,312/150,339/115,377/115,404/116,430/366,456', '1003,511');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', 'admin');
INSERT INTO `tb_user` VALUES (2, '123', '123');
INSERT INTO `tb_user` VALUES (3, '123123', '123123');

SET FOREIGN_KEY_CHECKS = 1;
