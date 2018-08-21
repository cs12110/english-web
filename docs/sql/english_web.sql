/*
Navicat MySQL Data Transfer

Source Server         : 10.10.2.233
Source Server Version : 50717
Source Host           : 10.10.2.233:3306
Source Database       : english_web

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-21 16:51:54
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_t
-- ----------------------------
INSERT INTO `customer_t` VALUES ('1', '张三', '6666', '66', '66', '18', '66', '是的', null);
INSERT INTO `customer_t` VALUES ('11', 'hhp', '12052010', '430', '350', '60', '5', 'cs', null);
INSERT INTO `customer_t` VALUES ('12', '呵呵哒', '333', '435', '444', '123', '12', '2323', null);
INSERT INTO `customer_t` VALUES ('13', '余华杰', '20130603', '545', '2', '22', '22', '', null);
INSERT INTO `customer_t` VALUES ('14', 'leaf', '1212122', '655', '655', '24', '16', 'ddddd', null);
INSERT INTO `customer_t` VALUES ('15', '11111', '11111', '454', '434', '18', '10', '', null);
INSERT INTO `customer_t` VALUES ('16', '1111', '111111', '222', '333', '33', '12', '231', null);

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
-- Table structure for progress_t
-- ----------------------------
DROP TABLE IF EXISTS `progress_t`;
CREATE TABLE `progress_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper` int(2) NOT NULL COMMENT '试卷类型',
  `name` varchar(32) NOT NULL,
  `open` int(2) DEFAULT NULL COMMENT '是否打开测试,0:否,1:是',
  `op_time` varchar(32) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of progress_t
-- ----------------------------
INSERT INTO `progress_t` VALUES ('1', '1', '前测', '1', '2018-08-21 16:42:49');
INSERT INTO `progress_t` VALUES ('2', '2', '学习1', '0', '2018-08-21 16:42:36');
INSERT INTO `progress_t` VALUES ('3', '3', '学习2', '0', '2018-08-21 16:09:11');
INSERT INTO `progress_t` VALUES ('4', '4', '后测', '0', '2018-08-21 16:09:11');
INSERT INTO `progress_t` VALUES ('5', '5', '追踪', '0', '2018-08-21 16:09:11');

-- ----------------------------
-- Table structure for score_t
-- ----------------------------
DROP TABLE IF EXISTS `score_t`;
CREATE TABLE `score_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `sub_id` int(11) NOT NULL,
  `correct` int(11) DEFAULT NULL,
  `stopwatch` text COMMENT '每个单词的查看时间json数据',
  `paper` int(2) DEFAULT NULL COMMENT '试卷类型',
  `sub_type` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerIndex` (`cus_id`),
  KEY `subjectIndex` (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score_t
-- ----------------------------
INSERT INTO `score_t` VALUES ('1', '11', '10', '1', 'at#217,accent.#274,laughs#215,Everybody#255,my#223,', null, null);
INSERT INTO `score_t` VALUES ('2', '11', '12', '1', 'The#215,situation#248,calls#842,for#550,prompt#2456,action.#2368', null, null);
INSERT INTO `score_t` VALUES ('3', '11', '1948', '1', 'Susan#207,always#185,finish#208,her#190,work#209,slowly.#191', null, null);
INSERT INTO `score_t` VALUES ('4', '11', '1951', '0', 'This#584,text#271,illuminate#329,the#536,philosopher\'s#255,early#224,thinking.#608', null, null);

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
  `paper` int(2) DEFAULT NULL COMMENT '1:前测,2:学习1,3:学习2,4:后测,5:追踪',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2061 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject_t
-- ----------------------------
INSERT INTO `subject_t` VALUES ('1945', 'He apologize for breaking her heart.', 'He apologize for breaking', '2', 'He is indifferent to her.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1946', 'He admire your poems very much.', 'He admire your poems', '2', 'He appreciates your novles.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1947', 'Tom often dance the waltz with Jane.', 'Tom often dance the', '2', 'Tom often dances hip hop.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1948', 'Susan always finish her work slowly.', 'Susan always finish her', '2', 'Susan is very efficient', 'No', '1');
INSERT INTO `subject_t` VALUES ('1949', 'He behave like a true gentleman.', 'He behave like a', '2', 'He is a man of good manners.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1950', 'Smoking damage your health seriously.', 'Smoking damage your health', '2', 'Smoking hurts the health.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1951', 'This text illuminate the philosopher\'s early thinking.', 'text illuminate the philosopher\'s', '2', 'This text is mainly about the later ideas of this philospher.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1952', 'Jane imitate the cuckoo vividly.', 'Jane imitate the cuckoo', '2', 'Jane imitates the Yellow bird very realisticly.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1953', 'Each game last about an hour.', 'game last about an', '2', 'It took half an hour to finish each game.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1954', 'Everybody laugh at my accent.', 'Everybody laugh at my', '2', 'I speak in a strange accent.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1955', 'Every weekend, he play golf with his cumtomers.', 'he play golf with', '2', 'He spent his weekend with his customers.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1956', 'The situation call for prompt action.', 'situation call for prompt', '2', 'This situation needs timely actions.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1957', 'His father always listens to the BBC news.', 'always listens to the', '1', 'His father likes listening to the VOAs.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1958', 'The boss offers him a good salary.', 'boss offers him a', '1', 'The boss is satisfied with him.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1959', 'The company employs many talented people.', 'company employs many talented', '1', 'The talented employees worked in this company.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1960', 'Hangzhou locates in the east of China.', 'Hangzhou locates in the', '1', 'Hangzhou lies in the south of China.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1961', 'My friend likes to do the same things as I do.', 'friend likes to do', '1', 'I share the same hobbies with my friend.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1962', 'Helen tries her best to study English.', 'Helen tries her best', '1', 'Helen makes her efforts to study Spanish.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1963', 'Susan visits her grandpa every week.', 'Susan visits her grandpa', '1', 'Susan met with her grandmother monthly.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1964', 'She has the habit of eating an apple after dinner.', 'She has the habit', '1', 'She had the habbit of eating an apple before the dinner.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1965', 'Xiaoming usually waters the flower in the morning.', 'usually waters the flower', '1', 'Xiaoming watered the flower in the afternoon.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1966', 'He always helps others, especially the poor.', 'always helps others especially', '1', 'He devotes to helpin the poor.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1967', 'David usually goes to school by bicycle.', 'usually goes to school', '1', 'David rides the bicycle to school.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1968', 'Every Saturday afternoon, she drinks coffee in the Starbuck with her friend.', 'she drinks coffee in', '1', 'She likes to drink the coffee in the Starbuck every Saturday afternoon.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1969', 'The parks that we visited yesterday is very beautiful.', 'yesterday is very beautiful', '4', 'We plan to visit the parks some time.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1970', 'The room that I live in are very big.', 'in are very big', '4', 'I live in a very big room.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1971', 'The boy whose parents died two years ago are with his grandpa.', 'ago are with his', '4', 'The boy is now living with his parents.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1972', 'The engineers who gave us a talk is from America.', 'talk is from America', '4', 'The American engineers gave us a talk.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1973', 'The pen that you lost yesterday is found here.', 'yesterday is found here', '4', 'The pen was found somewhere.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1974', 'The room whose windows were broken are not my grandma\'s.', 'broken are not my', '4', 'The windows were intact.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1975', 'The letters that I received yesterday is from my mother.', 'yesterday is from my', '4', 'I received my father\'s letter.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1976', 'The reasons that he gave us is quite reasonable.', 'us is quite reasonable', '4', 'The reasons sounded nonsense.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1977', 'The problems that he asked me for help is hard to solve.', 'help is hard to', '4', 'It was not easy for me to give him help.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1978', 'The soldiers who saved the boy’s life is very brave.', 'life is very brave', '4', 'The soldies saved the boy\'s life.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1979', 'The foreigners who visited our class yesterday is from Canada.', 'yesterday is from Canada', '4', 'We received the Canadians.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1980', 'The girl whom we saw yesterday are John’s sister.', 'yesterday are John’s sister', '4', 'We met John\'s brother yesterday.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1981', 'The coats that I put on the desk are deep blue.', 'desk are deep blue', '3', 'I put the coats on the table.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1982', 'The kitchen that I decorated by my heart is very beautiful.', 'heart is very beautiful', '3', 'I decorated my kitchen arbitrarily.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1983', 'The school that he once studied in is very famous.', 'in is very famous', '3', 'I had ever studied in a well-known school.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1984', 'The house where I lived ten years ago is very old.', 'ago is very old', '3', 'I lived in a very old house ten years ago.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1985', 'The reason why he was unhappy yesterday is quite inconceivable.', 'yesterday is quite inconceivable', '3', 'He was unhappy for some inexplicable reasons.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1986', 'The dictionaries that I want to buy are the Chinese-English versions.', 'buy are the Chinese-English', '3', 'I need an English-Chinese dictionary.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1987', 'The scientists that we met in the hall are very famous.', 'hall are very famous', '3', 'I met the famous scientists in the street.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1988', 'The house whose roof is brown is not mine.', 'brown is not mine', '3', 'The roof of my house is brown.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1989', 'The man who I talked with is our English teacher.', 'with is our English', '3', 'I talked to my English teacher.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1990', 'The recorders that he bought are made in Japan.', 'bought are made in', '3', 'I bought the recorders in Japan.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1991', 'The girl whose mother went abroad last year is very excellent.', 'year is very excellent', '3', 'The girl\'s mother is very excellent.', 'No', '1');
INSERT INTO `subject_t` VALUES ('1992', 'The house that they built last year is very luxurious.', 'year is very luxurious', '3', 'They built a very luxurious house.', 'Yes', '1');
INSERT INTO `subject_t` VALUES ('1993', 'The cage for the birds was very big .', 'birds was very big', '5', 'The cage was for the tigers .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('1994', 'The umbrella with better styles was made in Hangzhou .', 'styles was made in', '5', 'The umbrella was imported .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('1995', 'The explanation for the actions was too complex .', 'actions was too complex', '5', 'It was a very simple explanation .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('1996', 'The boy with silly ideas was an idiot .', 'ideas was an idiot', '5', 'He was a very clever boy .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('1997', 'The concert of the musicians was very successful .', 'musicians was very successful', '5', 'It was a successful concert .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('1998', 'The warning from the experts was quite shocking .', 'experts was quite shocking', '5', 'It was a shocking warning .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('1999', 'The plan including outdoor activities was quite challenging .', 'activities was quite challengin', '5', 'Outdoor activities were very difficult .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2000', 'The culture of the groups was respected by the tourists.', 'groups was respected by', '5', 'The group culture was respectable .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2001', 'The shelf for the books was very high .', 'books was very high', '5', 'The shelf was very new .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2002', 'The coach of the players was found dead .', 'players was found dead', '5', 'The coach was still working hard .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2003', 'The challenge from the competitors was seriously harsh .', 'competitors was seriously harsh', '5', 'It was a very cruel challenge .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2004', 'The result from the Labs was seriously questioned .', 'Labs was seriously questioned', '5', 'No one believed the results .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2005', 'The girl with the flower was very beautiful .', 'flower was very beautiful', '6', 'She was a beautiful girl .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2006', 'The hill without a tree was very ugly .', 'tree was very ugly', '6', 'The hill was beautiful for the trees .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2007', 'The bottle with a pill was on the table .', 'pill was on the', '6', 'The bottle was full of sweets .', 'NO　', '1');
INSERT INTO `subject_t` VALUES ('2008', 'The ship with the traveler was traveling around the world .', 'traveler was traveling around', '6', 'The ship was traveling around the world .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2009', 'The student with learning problem was very poor .　', 'problem was very poor', '6', 'The student with learning disabilities was poor .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2010', 'The tower next to the tree was very high .', 'tree was very high', '6', 'The tower was by the lake .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2011', 'The card under the book was for Christmas .　', 'book was for Christmas', '6', 'It was a gift for the new years .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2012', 'The problem in highway system was solved at last.', 'system was solved at', '6', 'The problems still existed .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2013', 'The knife of the doctor was imported from Switzerland .', 'doctor was imported from', '6', 'The doctors made the knife themselves .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2014', 'The discussion by the expert was held in this hotel .', 'expert was held in', '6', 'The experts held the discussions .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2015', 'The ball of the kid was under the tree .', 'kid was under the', '6', 'The ball was in the tree .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2016', 'The boy in the crowd was very poor .　', 'crowd was very poor', '6', 'He was a poor boy .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2017', 'The cry from the crowds were quite terrible .', 'crowds were quite terrible', '7', 'The cry was acceptable .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2018', 'The proposal by the teachers were accepted by the students .', 'teachers were accepted by', '7', 'The proposal was refused .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2019', 'The attack against the students were quite terrible .', 'students were quite terrible', '7', 'It was terrible to attack the students .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2020', 'The party for the guests were very wonderful .', 'guests were very wonderful', '7', 'It was a wonderful party .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2021', 'The apartment with two bathrooms were sold by the landlord .', 'bathrooms were sold by', '7', 'The apartment was sold out .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2022', 'The plastic bag with tablecloths were left there .', 'tablecloths were left there', '7', 'The bag was here now .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2023', 'The condition for applications were very strict .', 'applications were very strict', '7', 'It was easy to apply .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2024', 'The aunt of the girls were in Hangzhou .', 'girls were in Hangzhou', '7', 'The uncle was in hangzhou .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2025', 'The cake with fresh fruits were for Tom .', 'fruits were for Tom', '7', 'The cake was for Tom .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2026', 'The charge for the overweighed products were very high .', 'products were very high', '7', 'The charge was high .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2027', 'The effect of the methods were newly discussed .', 'methods were newly discussed', '7', 'The discussion was about the method effects .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2028', 'The view on the battles were very subjective .　', 'battles were very subjective', '7', 'The view was objective and reasonable .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2029', 'The boss of the bar were attending a meeting .', 'bar were attending a', '8', 'The boss was very busy .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2030', 'The meeting on site selection were finished at last.', 'selection were finished at', '8', 'The meeting was about reform .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2031', 'The response to the event were far from warm .', 'event were far from', '8', 'The response was indifferent .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2032', 'The option of the girl were very reasonable  .', 'girl were very reasonable', '8', 'The girls made reasonable choices .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2033', 'The worry about the kid were totally unnecessary .', 'kid were totally unnecessary', '8', 'It was necessary to worry about the kids .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2034', 'The Contribution to the company were very huge .', 'company were very huge', '8', 'The contribution was huge .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2035', 'The award for the group were very important .', 'group were very important', '8', 'The award was not significant .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2036', 'The article by the researcher were published by the journal.', 'researcher were published by', '8', 'The article was still in the draft .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2037', 'The cat of the kid were very lovely .', 'kid were very lovely', '8', 'The dog was very cute .', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2038', 'The pipe for gas were placed under the ground .', 'gas were placed under', '8', 'The pipe was for the gases .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2039', 'The murderer in the crime were sentenced to death .', 'crime were sentenced to', '8', 'The murderer was sentenced to death .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2040', 'The room for the beggar were very big .', 'beggar were very big', '8', 'The room was big enough for the beggars .', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2041', 'The father  bought two bottles in that store .', 'bought two bottles in', '0', 'The bottles were bought from the supermarket', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2042', 'The girl asked the teacher something about how to learn English .', 'girl asked the teacher', '0', 'The girl wanted to know how to learn math', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2043', 'I have stay in Hangzhou for more than four years .', 'have stay in Hangzhou', '0', 'I  stayed in Hangzhou for less than 4 years', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2044', 'The manager fired the girl who was always late for work .', 'manager fired the girl', '0', 'The girl was out of work', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2045', 'With the help of his parents, the boy is do his homework Now .', 'boy is do his', '0', 'The boy can do the homework himself', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2046', 'After arriving in school, He began to do morning exercises .', 'He began to do', '0', 'It was required to do morning exercises by the school.', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2047', 'At January 4th, the fire damage the town hall badly .', 'fire damage the town', '0', 'The town hall  was destroyed', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2048', 'yesterday afternoon, we have three math classes .', 'have three math classes', '0', 'We had  two classes yesterday afternoon', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2049', 'He is used to live here in Beijing .', 'is used to live', '0', 'He  is Now living in Beijing', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2050', 'There are a lot of people in the meeting room .', 'are a lot of', '0', 'People are gathering in the meeting room', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2051', 'Contrary to  what I had originally thought, the trip turned out to be fun .', 'trip turned out to', '0', 'The trip was beyond my expectation', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2052', 'As a matter of fact, advertisement plays an informative role in our daily life .', 'advertisement plays an informative', '0', 'Advertisement provides  us  with  much information', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2053', 'Noise is unpleasant, especially when you are trying to sleep .', 'you are trying to', '0', 'Noise doesn’t affect the sleeping', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2054', 'As a result, Many of us  succeeded pass the examinations .', 'us succeeded pass the', '0', 'Most people failed in the test', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2055', 'In short, measures must be taken to prevent the environment  polluting .', 'measures must be taken', '0', 'We should do something about the pollution', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2056', 'They will be here soon . Meanwhile, let’s have coffee .', 'Meanwhile let’s have coffee', '0', 'They  have already arrived here', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2057', 'There are students here from all over the country .', 'students here from all', '0', 'The students are from the same area', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2058', 'This typewriter is cheap and fine indeed .', 'typewriter is cheap and', '0', 'The typewriter is of good quality', 'YES', '1');
INSERT INTO `subject_t` VALUES ('2059', 'At that time, they laugh at their own failure .', 'they laugh at their', '0', 'They  were satisfied with themselves in the past', 'NO', '1');
INSERT INTO `subject_t` VALUES ('2060', 'Last Summer, my friend rent a beach house .', 'my friend rent a', '0', 'My friend rented a village house', 'NO', '1');

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
