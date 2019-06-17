SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
  `block_id` int NOT NULL auto_increment,
  `blockhash`  char(64) NOT NULL,
  `height`     int NOT NULL,
  `time`       datetime,
  `txSize`     smallint,
  `size`       int,
  `difficulty` double,
  `weight`     float,
  `next_block` char(64),
  `prev_block` char(64),
  PRIMARY KEY (`block_id`),
  index `idx_blockhash` (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
