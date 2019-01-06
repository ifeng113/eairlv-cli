/*
 Navicat Premium Data Transfer

 Source Server         : 10.50.40.145
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 10.50.40.145:3306
 Source Schema         : lv

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 03/12/2018 22:00:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cli
-- ----------------------------
DROP TABLE IF EXISTS `cli`;
CREATE TABLE `cli`  (
  `id` bigint(20) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 0,
  `delete_flag` bit(1) NULL DEFAULT b'0',
  `create_time` bigint(20) NULL DEFAULT NULL,
  `modify_time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cli
-- ----------------------------
INSERT INTO `cli` VALUES (1069591238581784577, '1', '1', 0, b'0', 1543845397978, NULL);
INSERT INTO `cli` VALUES (1069591337416364033, '2', '2', 0, b'0', 1543845421543, NULL);
INSERT INTO `cli` VALUES (1069591383805366273, '3', '3', 0, b'0', 1543845432604, NULL);
INSERT INTO `cli` VALUES (1069591419788300290, 'string', 'string', 1, b'1', 1543845441181, 1543845554991);

SET FOREIGN_KEY_CHECKS = 1;
