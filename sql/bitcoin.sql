SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bitcoin
-- ----------------------------
DROP TABLE IF EXISTS `bitcoin`;
CREATE TABLE `bitcoin`
(
  `bitcoin_id` int NOT NULL auto_increment,
  `name`  Varchar(255) NOT NULL,
  `shortname`  Varchar(255),
  `type`       Varchar(255),
  PRIMARY KEY (`bitcoin_id`),
  index `idx_name` (`name`),
  index `idx_shortname` (`shortname`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
