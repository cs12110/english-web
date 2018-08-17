/*
Navicat MySQL Data Transfer

Source Server         : 47.98.104.252
Source Server Version : 50718
Source Host           : 47.98.104.252:3306
Source Database       : english_web

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-08-17 09:14:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content_t
-- ----------------------------
DROP TABLE IF EXISTS `content_t`;
CREATE TABLE `content_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(256) DEFAULT NULL COMMENT 'name',
  `summary` varchar(256) DEFAULT NULL COMMENT 'summary',
  `content` varchar(1024) DEFAULT NULL COMMENT 'content',
  `create_time` varchar(32) DEFAULT NULL COMMENT 'create time',
  `update_time` varchar(32) DEFAULT NULL COMMENT 'update time',
  `order_num` int(11) DEFAULT NULL COMMENT 'order num',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content_t
-- ----------------------------

-- ----------------------------
-- Table structure for customer_t
-- ----------------------------
DROP TABLE IF EXISTS `customer_t`;
CREATE TABLE `customer_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `code` varchar(255) DEFAULT NULL COMMENT '学号',
  `cet4` int(11) DEFAULT NULL COMMENT '四级成绩',
  `cet6` varchar(255) DEFAULT NULL COMMENT '六级成绩',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `eng_age` int(11) DEFAULT NULL COMMENT '学习英语成绩',
  `major` varchar(255) DEFAULT NULL COMMENT '四级专业',
  `gender` int(1) DEFAULT NULL COMMENT '性别,0:男,1:女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_t
-- ----------------------------
INSERT INTO `customer_t` VALUES ('11', 'hhp', '12052010', '430', '350', '60', '5', 'cs', null);
INSERT INTO `customer_t` VALUES ('12', '呵呵哒', '333', '435', '444', '123', '12', '2323', null);
INSERT INTO `customer_t` VALUES ('13', '余华杰', '20130603', '545', '2', '22', '22', '', null);
INSERT INTO `customer_t` VALUES ('14', 'leaf', '1212122', '655', '655', '24', '16', 'ddddd', null);

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户_角色关联表';

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for score_t
-- ----------------------------
DROP TABLE IF EXISTS `score_t`;
CREATE TABLE `score_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `sub_id` int(11) NOT NULL,
  `read_time1` int(11) DEFAULT NULL,
  `read_time2` int(11) DEFAULT NULL,
  `read_time3` int(11) DEFAULT NULL,
  `read_time4` int(11) DEFAULT NULL,
  `read_time5` int(11) DEFAULT NULL,
  `correct` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerIndex` (`cus_id`),
  KEY `subjectIndex` (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of score_t
-- ----------------------------
INSERT INTO `score_t` VALUES ('28', '11', '1', '920', '920', '520', '505', null, '0');
INSERT INTO `score_t` VALUES ('29', '11', '3', '297', '222', '265', '503', null, '1');
INSERT INTO `score_t` VALUES ('30', '12', '1', '704', '207', '205', '187', null, '1');
INSERT INTO `score_t` VALUES ('31', '12', '2', '216', '337', '266', '396', null, '1');
INSERT INTO `score_t` VALUES ('32', '12', '3', '309', '401', '220', '317', null, '0');
INSERT INTO `score_t` VALUES ('33', '12', '4', '517', '791', '919', '2214', null, '1');
INSERT INTO `score_t` VALUES ('34', '12', '5', '1618', '1273', '4625', '3615', null, '1');
INSERT INTO `score_t` VALUES ('35', '12', '6', '1095', '1024', '624', '2145', null, '0');
INSERT INTO `score_t` VALUES ('36', '12', '7', '1108', '1147', '1022', '897', null, '1');
INSERT INTO `score_t` VALUES ('37', '12', '8', '1008', '809', '835', '1044', null, '1');
INSERT INTO `score_t` VALUES ('38', '12', '9', '578', '876', '1323', '1220', null, '1');
INSERT INTO `score_t` VALUES ('39', '12', '10', '310', '386', '465', '449', null, '1');
INSERT INTO `score_t` VALUES ('40', '12', '11', '726', '580', '596', '553', null, '0');
INSERT INTO `score_t` VALUES ('41', '12', '12', '472', '539', '604', '538', null, '0');
INSERT INTO `score_t` VALUES ('42', '12', '13', '207', '629', '528', '476', null, '1');
INSERT INTO `score_t` VALUES ('43', '12', '14', '419', '427', '531', '497', null, '0');
INSERT INTO `score_t` VALUES ('44', '12', '15', '576', '509', '528', '440', null, '0');
INSERT INTO `score_t` VALUES ('45', '12', '16', '432', '523', '592', '686', null, '0');
INSERT INTO `score_t` VALUES ('46', '12', '17', '453', '476', '439', '444', null, '1');
INSERT INTO `score_t` VALUES ('47', '12', '18', '434', '464', '495', '429', null, '0');
INSERT INTO `score_t` VALUES ('48', '12', '19', '523', '481', '500', '538', null, '1');
INSERT INTO `score_t` VALUES ('49', '12', '20', '417', '410', '454', '421', null, '0');
INSERT INTO `score_t` VALUES ('50', '12', '21', '469', '606', '501', '512', '403', '0');
INSERT INTO `score_t` VALUES ('51', '11', '1', '488', '248', '544', '249', null, '0');
INSERT INTO `score_t` VALUES ('52', '11', '2', '297', '280', '232', '333', null, '0');
INSERT INTO `score_t` VALUES ('53', '11', '3', '221', '220', '280', '289', null, '1');
INSERT INTO `score_t` VALUES ('54', '11', '4', '435', '452', '561', '527', null, '1');
INSERT INTO `score_t` VALUES ('55', '11', '5', '535', '265', '239', '560', null, '1');
INSERT INTO `score_t` VALUES ('56', '11', '6', '728', '321', '264', '375', null, '1');
INSERT INTO `score_t` VALUES ('57', '11', '7', '680', '736', '680', '1935', null, '0');
INSERT INTO `score_t` VALUES ('58', '11', '8', '521', '342', '937', '296', null, '0');
INSERT INTO `score_t` VALUES ('59', '11', '9', '879', '601', '675', '581', null, '0');
INSERT INTO `score_t` VALUES ('60', '13', '1', '1065', '1055', '616', '744', null, '1');
INSERT INTO `score_t` VALUES ('61', '13', '2', '615', '520', '664', '568', null, '1');
INSERT INTO `score_t` VALUES ('62', '13', '3', '441', '432', '431', '401', null, '1');
INSERT INTO `score_t` VALUES ('63', '13', '4', '527', '529', '456', '464', null, '1');
INSERT INTO `score_t` VALUES ('64', '13', '5', '191', '208', '193', '215', null, '0');
INSERT INTO `score_t` VALUES ('65', '13', '6', '808', '1071', '489', '573', null, '1');
INSERT INTO `score_t` VALUES ('66', '14', '1', '672', '559', '464', '480', null, '0');
INSERT INTO `score_t` VALUES ('67', '14', '2', '824', '200', '424', '216', null, '0');
INSERT INTO `score_t` VALUES ('68', '14', '3', '192', '240', '264', '216', null, '0');

-- ----------------------------
-- Table structure for subject_t
-- ----------------------------
DROP TABLE IF EXISTS `subject_t`;
CREATE TABLE `subject_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sentence` varchar(1024) DEFAULT NULL COMMENT '句子',
  `keyword` varchar(512) DEFAULT NULL COMMENT '关键字',
  `type` int(3) DEFAULT NULL COMMENT '类型',
  `question` varchar(255) DEFAULT NULL COMMENT '问题',
  `answer` varchar(5) DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject_t
-- ----------------------------
INSERT INTO `subject_t` VALUES ('1', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('2', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('3', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('4', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('5', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('6', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('7', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('8', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('9', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('10', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('11', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('12', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('13', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('14', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('15', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('16', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('17', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('18', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('19', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('20', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('21', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('22', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('23', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('24', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('25', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('26', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('27', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('28', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('29', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('30', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('31', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('32', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('33', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('34', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('35', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('36', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('37', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('38', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('39', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('40', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('41', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('42', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('43', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('44', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('45', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('46', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('47', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('48', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('49', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('50', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('51', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('52', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('53', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('54', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('55', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('56', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('57', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('58', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('59', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('60', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('61', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('62', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('63', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('64', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('65', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('66', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('67', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('68', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('69', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('70', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('71', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('72', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('73', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('74', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('75', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('76', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('77', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('78', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('79', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('80', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('81', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('82', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('83', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('84', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('85', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('86', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('87', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('88', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('89', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('90', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('91', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('92', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('93', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('94', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('95', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('96', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('97', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('98', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('99', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('100', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('101', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('102', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('103', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('104', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('105', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('106', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('107', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('108', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('109', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('110', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('111', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('112', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('113', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('114', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('115', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('116', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');
INSERT INTO `subject_t` VALUES ('117', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('118', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('119', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('120', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('121', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('122', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('123', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('124', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('125', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('126', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('127', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('128', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('129', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('130', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('131', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('132', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('133', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('134', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('135', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('136', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('137', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('138', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('139', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('140', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('141', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('142', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('143', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('144', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('145', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('146', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('147', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('148', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('149', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('150', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('151', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('152', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('153', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('154', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('155', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('156', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('157', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('158', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('159', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('160', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('161', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('162', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('163', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('164', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('165', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('166', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('167', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('168', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('169', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('170', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('171', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('172', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('173', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('174', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('175', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('176', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('177', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('178', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('179', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('180', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('181', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('182', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('183', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('184', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('185', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('186', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('187', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('188', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('189', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('190', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('191', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('192', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('193', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('194', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('195', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('196', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('197', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('198', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('199', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('200', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('201', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('202', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('203', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('204', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('205', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('206', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('207', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('208', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('209', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('210', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('211', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('212', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('213', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('214', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('215', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('216', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('217', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('218', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('219', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('220', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('221', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('222', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('223', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('224', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('225', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('226', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('227', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('228', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('229', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('230', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('231', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('232', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');
INSERT INTO `subject_t` VALUES ('233', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('234', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('235', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('236', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('237', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('238', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('239', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('240', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('241', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('242', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('243', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('244', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('245', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('246', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('247', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('248', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('249', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('250', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('251', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('252', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('253', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('254', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('255', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('256', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('257', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('258', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('259', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('260', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('261', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('262', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('263', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('264', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('265', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('266', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('267', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('268', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('269', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('270', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('271', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('272', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('273', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('274', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('275', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('276', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('277', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('278', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('279', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('280', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('281', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('282', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('283', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('284', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('285', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('286', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('287', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('288', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('289', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('290', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('291', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('292', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('293', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('294', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('295', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('296', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('297', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('298', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('299', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('300', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('301', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('302', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('303', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('304', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('305', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('306', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('307', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('308', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('309', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('310', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('311', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('312', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('313', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('314', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('315', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('316', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('317', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('318', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('319', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('320', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('321', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('322', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('323', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('324', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('325', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('326', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('327', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('328', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('329', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('330', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('331', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('332', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('333', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('334', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('335', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('336', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('337', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('338', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('339', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('340', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('341', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('342', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('343', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('344', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('345', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('346', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('347', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('348', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');
INSERT INTO `subject_t` VALUES ('349', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('350', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('351', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('352', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('353', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('354', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('355', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('356', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('357', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('358', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('359', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('360', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('361', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('362', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('363', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('364', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('365', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('366', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('367', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('368', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('369', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('370', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('371', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('372', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('373', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('374', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('375', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('376', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('377', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('378', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('379', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('380', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('381', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('382', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('383', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('384', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('385', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('386', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('387', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('388', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('389', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('390', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('391', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('392', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('393', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('394', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('395', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('396', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('397', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('398', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('399', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('400', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('401', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('402', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('403', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('404', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('405', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('406', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('407', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('408', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('409', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('410', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('411', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('412', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('413', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('414', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('415', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('416', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('417', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('418', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('419', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('420', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('421', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('422', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('423', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('424', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('425', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('426', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('427', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('428', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('429', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('430', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('431', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('432', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('433', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('434', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('435', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('436', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('437', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('438', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('439', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('440', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('441', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('442', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('443', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('444', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('445', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('446', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('447', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('448', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('449', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('450', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('451', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('452', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('453', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('454', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('455', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('456', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('457', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('458', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('459', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('460', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('461', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('462', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('463', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('464', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');
INSERT INTO `subject_t` VALUES ('465', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('466', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('467', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('468', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('469', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('470', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('471', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('472', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('473', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('474', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('475', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('476', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('477', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('478', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('479', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('480', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('481', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('482', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('483', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('484', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('485', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('486', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('487', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('488', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('489', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('490', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('491', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('492', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('493', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('494', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('495', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('496', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('497', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('498', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('499', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('500', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('501', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('502', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('503', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('504', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('505', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('506', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('507', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('508', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('509', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('510', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('511', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('512', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('513', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('514', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('515', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('516', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('517', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('518', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('519', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('520', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('521', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('522', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('523', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('524', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('525', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('526', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('527', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('528', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('529', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('530', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('531', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('532', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('533', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('534', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('535', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('536', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('537', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('538', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('539', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('540', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('541', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('542', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('543', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('544', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('545', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('546', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('547', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('548', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('549', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('550', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('551', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('552', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('553', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('554', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('555', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('556', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('557', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('558', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('559', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('560', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('561', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('562', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('563', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('564', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('565', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('566', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('567', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('568', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('569', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('570', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('571', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('572', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('573', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('574', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('575', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('576', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('577', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('578', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('579', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('580', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');
INSERT INTO `subject_t` VALUES ('581', 'He apologizes for breaking her heart.', 'He apologizes for breaking', '1', 'He is indifferent to her.', 'No');
INSERT INTO `subject_t` VALUES ('582', 'He admires your poems very much.', 'He admires your poems', '1', 'He appreciates your novles.', 'No');
INSERT INTO `subject_t` VALUES ('583', 'Tom often dances the waltz with Jane.', 'often dances the waltz', '1', 'Tom often dances hip hop.', 'No');
INSERT INTO `subject_t` VALUES ('584', 'Susan always finishes her work slowly.', 'always finishes her work', '1', 'Susan is very efficient', 'No');
INSERT INTO `subject_t` VALUES ('585', 'He behaves like a true gentleman.', 'He behaves like a', '1', 'He is a man of good manners.', 'Yes');
INSERT INTO `subject_t` VALUES ('586', 'Smoking damages your health seriously.', 'Smoking damages your health', '1', 'Smoking hurts the health.', 'Yes');
INSERT INTO `subject_t` VALUES ('587', 'This text illuminates the philosopher\'s early thinking.', 'text illuminates the philosopher\'s', '1', 'This text is mainly about the later ideas of this philospher.', 'No');
INSERT INTO `subject_t` VALUES ('588', 'Jane imitates the cuckoo vividly.', 'Jane imitates the cuckoo', '1', 'Jane imitates the Yellow bird very realisticly.', 'No');
INSERT INTO `subject_t` VALUES ('589', 'Each game lasts about an hour.', 'game lasts about an', '1', 'It took half an hour to finish each game.', 'No');
INSERT INTO `subject_t` VALUES ('590', 'Everybody laughs at my accent.', 'Everybody laughs at my', '1', 'I speak in a strange accent.', 'Yes');
INSERT INTO `subject_t` VALUES ('591', 'Every weekend, he plays golf with his cumtomers.', 'he plays golf with', '1', 'He spent his weekend with his customers.', 'Yes');
INSERT INTO `subject_t` VALUES ('592', 'The situation calls for prompt action.', 'situation calls for prompt', '1', 'This situation needs timely actions.', 'Yes');
INSERT INTO `subject_t` VALUES ('593', 'His father always listen to the BBC news.', 'always listen to the', '2', 'His father likes listening to the VOAs.', 'No');
INSERT INTO `subject_t` VALUES ('594', 'The boss offer him a good salary.', 'boss offer him a', '2', 'The boss is satisfied with him.', 'Yes');
INSERT INTO `subject_t` VALUES ('595', 'The company employ many talented people.', 'company employ many talented', '2', 'The talented employees worked in this company.', 'Yes');
INSERT INTO `subject_t` VALUES ('596', 'Hangzhou locate in the east of China.', 'Hangzhou locate in the', '2', 'Hangzhou lies in the south of China.', 'No');
INSERT INTO `subject_t` VALUES ('597', 'My friend like to do the same things as I do.', 'friend like to do', '2', 'I share the same hobbies with my friend.', 'Yes');
INSERT INTO `subject_t` VALUES ('598', 'Helen try her best to study English.', 'Helen try her best', '2', 'Helen makes her efforts to study Spanish.', 'No');
INSERT INTO `subject_t` VALUES ('599', 'Susan visit her grandpa every week.', 'Susan visit her grandpa', '2', 'Susan met with her grandmother monthly.', 'No');
INSERT INTO `subject_t` VALUES ('600', 'She have the habit of eating an apple after dinner.', 'She have the habit', '2', 'She had the habbit of eating an apple before the dinner.', 'No');
INSERT INTO `subject_t` VALUES ('601', 'Xiaoming usually water the flower in the morning.', 'usually water the flower', '2', 'Xiaoming watered the flower in the afternoon.', 'No');
INSERT INTO `subject_t` VALUES ('602', 'He always help others, especially the poor.', 'always help others especially', '2', 'He devotes to helpin the poor.', 'Yes');
INSERT INTO `subject_t` VALUES ('603', 'David usually go to school by bicycle.', 'sually go to school', '2', 'David rides the bicycle to school.', 'Yes');
INSERT INTO `subject_t` VALUES ('604', 'Every Saturday afternoon, she drink coffee in the Starbuck with her friend.', 'she drink coffee in', '2', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes');
INSERT INTO `subject_t` VALUES ('605', 'The parks that we visited yesterday are very beautiful.', 'yesterday are very beautiful', '3', 'We plan to visit the parks some time.', 'No');
INSERT INTO `subject_t` VALUES ('606', 'The room that I live in is very big.', 'in is very big', '3', 'I live in a very big room.', 'Yes');
INSERT INTO `subject_t` VALUES ('607', 'The boy whose parents died two years ago is with his grandpa.', 'ago is with his', '3', 'The boy is now living with his parents.', 'No');
INSERT INTO `subject_t` VALUES ('608', 'The engineers who gave us a talk are from America.', 'talk are from America', '3', 'The American engineers gave us a talk.', 'Yes');
INSERT INTO `subject_t` VALUES ('609', 'The pens that you lost yesterday are found here.', 'yesterday are found here', '3', 'The pen was found somewhere.', 'Yes');
INSERT INTO `subject_t` VALUES ('610', 'The room whose windows were broken is not my grandma\'s.', 'broken is not my', '3', 'The windows were intact.', 'No');
INSERT INTO `subject_t` VALUES ('611', 'The letters that I received yesterday are from my mother.', 'yesterday are from my', '3', 'I received my father\'s letter.', 'No');
INSERT INTO `subject_t` VALUES ('612', 'The reasons that he gave us are quite reasonable.', 'us are quite reasonable', '3', 'The reasons sounded nonsense.', 'No');
INSERT INTO `subject_t` VALUES ('613', 'The problems that he asked me for help are hard to solve.', 'help are hard to', '3', 'It was not easy for me to give him help.', 'Yes');
INSERT INTO `subject_t` VALUES ('614', 'The soldiers who saved the boy’s life are very brave.', 'life are very brave', '3', 'The soldies saved the boy\'s life.', 'Yes');
INSERT INTO `subject_t` VALUES ('615', 'The foreigners who visited our class yesterday are from Canada.', 'yesterday are from Canada', '3', 'We received the Canadians.', 'Yes');
INSERT INTO `subject_t` VALUES ('616', 'The girl whom we saw yesterday is John’s sister.', 'yesterday is John’s sister', '3', 'We met John\'s brother yesterday.', 'No');
INSERT INTO `subject_t` VALUES ('617', 'The coats that I put on the desk is deep blue.', 'desk is deep blue', '4', 'I put the coats on the table.', 'No');
INSERT INTO `subject_t` VALUES ('618', 'The kitchen that I decorated by my heart are very beautiful.', 'heart are very beautiful', '4', 'I decorated my kitchen arbitrarily.', 'No');
INSERT INTO `subject_t` VALUES ('619', 'The school that he once studied in are very famous.', 'in are very famous', '4', 'I had ever studied in a well-known school.', 'Yes');
INSERT INTO `subject_t` VALUES ('620', 'The house where I lived ten years ago are very old.', 'ago are very old', '4', 'I lived in a very old house ten years ago.', 'Yes');
INSERT INTO `subject_t` VALUES ('621', 'The reason why he was unhappy yesterday are quite inconceivable.', 'yesterday are quite inconceivable', '4', 'He was unhappy for some inexplicable reasons.', 'Yes');
INSERT INTO `subject_t` VALUES ('622', 'The dictionaries that I want to buy is the Chinese-English versions.', 'buy is the Chinese-English', '4', 'I need an English-Chinese dictionary.', 'No');
INSERT INTO `subject_t` VALUES ('623', 'The scientists that we met in the hall is very famous.', 'hall is very famous', '4', 'I met the famous scientists in the street.', 'No');
INSERT INTO `subject_t` VALUES ('624', 'The house whose roof is brown are not mine.', 'brown are not mine', '4', 'The roof of my house is brown.', 'No');
INSERT INTO `subject_t` VALUES ('625', 'The man who I talked with are our English teacher.', 'with are our English', '4', 'I talked to my English teacher.', 'Yes');
INSERT INTO `subject_t` VALUES ('626', 'The recorders that he bought is made in Japan.', 'bought is made in', '4', 'I bought the recorders in Japan.', 'No');
INSERT INTO `subject_t` VALUES ('627', 'The girl whose mother went abroad last year are very excellent.', 'year are very excellent', '4', 'The girl\'s mother is very excellent.', 'No');
INSERT INTO `subject_t` VALUES ('628', 'The house that they built last year are very luxurious.', 'year are very luxurious', '4', 'They built a very luxurious house.', 'Yes');
INSERT INTO `subject_t` VALUES ('629', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO');
INSERT INTO `subject_t` VALUES ('630', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO');
INSERT INTO `subject_t` VALUES ('631', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO');
INSERT INTO `subject_t` VALUES ('632', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO');
INSERT INTO `subject_t` VALUES ('633', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES');
INSERT INTO `subject_t` VALUES ('634', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES');
INSERT INTO `subject_t` VALUES ('635', 'The plan including outdoor activities was very challenging .', 'activities was very challenging', '5', 'Outdoor activities were very difficult .', 'YES');
INSERT INTO `subject_t` VALUES ('636', 'The culture of the groups was respected by the tourists .', 'groups was respected by', '5', 'The group culture was respectable .', 'YES');
INSERT INTO `subject_t` VALUES ('637', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO');
INSERT INTO `subject_t` VALUES ('638', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO');
INSERT INTO `subject_t` VALUES ('639', 'The challenge from the competitors was very harsh .', 'competitors was very harsh', '5', 'It was a very cruel challenge .', 'YES');
INSERT INTO `subject_t` VALUES ('640', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES');
INSERT INTO `subject_t` VALUES ('641', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES');
INSERT INTO `subject_t` VALUES ('642', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES');
INSERT INTO `subject_t` VALUES ('643', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　');
INSERT INTO `subject_t` VALUES ('644', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES');
INSERT INTO `subject_t` VALUES ('645', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES');
INSERT INTO `subject_t` VALUES ('646', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO');
INSERT INTO `subject_t` VALUES ('647', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO');
INSERT INTO `subject_t` VALUES ('648', 'The problem in highway system was solved in the end .', 'system was solved in', '6', 'The problems still existed .', 'NO');
INSERT INTO `subject_t` VALUES ('649', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported fro', '6', 'The doctors made the knife themselves .', 'NO');
INSERT INTO `subject_t` VALUES ('650', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES');
INSERT INTO `subject_t` VALUES ('651', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO');
INSERT INTO `subject_t` VALUES ('652', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES');
INSERT INTO `subject_t` VALUES ('653', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO');
INSERT INTO `subject_t` VALUES ('654', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO');
INSERT INTO `subject_t` VALUES ('655', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES');
INSERT INTO `subject_t` VALUES ('656', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES');
INSERT INTO `subject_t` VALUES ('657', 'The apartment with two bathrooms were sold by the landlord.', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES');
INSERT INTO `subject_t` VALUES ('658', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO');
INSERT INTO `subject_t` VALUES ('659', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO');
INSERT INTO `subject_t` VALUES ('660', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO');
INSERT INTO `subject_t` VALUES ('661', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES');
INSERT INTO `subject_t` VALUES ('662', 'The charge for the overweighed products were terribly high .', 'products were terribly high', '7', 'The charge was high .', 'YES');
INSERT INTO `subject_t` VALUES ('663', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES');
INSERT INTO `subject_t` VALUES ('664', 'The view on the battles were quite subjective .　', 'battles were quite subjective', '7', 'The view was objective and reasonable .', 'NO');
INSERT INTO `subject_t` VALUES ('665', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES');
INSERT INTO `subject_t` VALUES ('666', 'The meeting on site selection were finished at last .', 'selection were finished at', '8', 'The meeting was about reform .', 'NO');
INSERT INTO `subject_t` VALUES ('667', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES');
INSERT INTO `subject_t` VALUES ('668', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES');
INSERT INTO `subject_t` VALUES ('669', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES');
INSERT INTO `subject_t` VALUES ('670', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES');
INSERT INTO `subject_t` VALUES ('671', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO');
INSERT INTO `subject_t` VALUES ('672', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO');
INSERT INTO `subject_t` VALUES ('673', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO');
INSERT INTO `subject_t` VALUES ('674', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES');
INSERT INTO `subject_t` VALUES ('675', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES');
INSERT INTO `subject_t` VALUES ('676', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES');
INSERT INTO `subject_t` VALUES ('677', 'The father bought two bottles in that store .', 'father bought two bottles', '0', 'The bottles were bought from the supermarket', 'NO');
INSERT INTO `subject_t` VALUES ('678', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO');
INSERT INTO `subject_t` VALUES ('679', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO');
INSERT INTO `subject_t` VALUES ('680', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES');
INSERT INTO `subject_t` VALUES ('681', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO');
INSERT INTO `subject_t` VALUES ('682', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES');
INSERT INTO `subject_t` VALUES ('683', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES');
INSERT INTO `subject_t` VALUES ('684', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO');
INSERT INTO `subject_t` VALUES ('685', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES');
INSERT INTO `subject_t` VALUES ('686', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES');
INSERT INTO `subject_t` VALUES ('687', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES');
INSERT INTO `subject_t` VALUES ('688', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES');
INSERT INTO `subject_t` VALUES ('689', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO');
INSERT INTO `subject_t` VALUES ('690', 'As a result, Many of us succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO');
INSERT INTO `subject_t` VALUES ('691', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES');
INSERT INTO `subject_t` VALUES ('692', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO');
INSERT INTO `subject_t` VALUES ('693', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO');
INSERT INTO `subject_t` VALUES ('694', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES');
INSERT INTO `subject_t` VALUES ('695', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO');
INSERT INTO `subject_t` VALUES ('696', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(64) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '3306', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES ('2', 'admin', '21232f297a57a5a743894a0e4a801fc3');
