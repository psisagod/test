SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tx_detall
-- ----------------------------
DROP TABLE IF EXISTS `tx_detall`;
CREATE TABLE `tx_detall`
(
  `tx_detall_id` bigint NOT NULL auto_increment,
  `adress`  varchar(100),
  `amount`   double,
  `type`     tinyint,
  `txhash`   char(64),
  PRIMARY KEY (`tx_detall_id`),
  index `idx_adress` (`adress`),
  index `idx_txhash` (`txhash`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
