/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : notepad

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-02-02 15:06:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方法',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '请求参数',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '笔记内容',
  `creat_time` datetime NOT NULL,
  `last_modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_ke` (`user_id`),
  CONSTRAINT `user_id_ke` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_note
-- ----------------------------
INSERT INTO `tb_note` VALUES ('19', '10', '外国政要积极评价和支持中国抗击新型冠状病毒感染肺炎疫情', '央视网消息（新闻联播）：连日来，又有一些国家政要通过各种方式，纷纷高度评价中方为抗击疫情所做努力，并表达对中国的支持。\n俄罗斯总统普京致电习近平主席，对疫情给很多中国家庭带来痛苦和损失表示慰问，祝愿所有患者早日康复。他表示，相信在习近平主席领导下，中方采取的坚决措施一定会阻止疫情蔓延并将损失减少到最低程度。俄罗斯人民愿向友好的中国人民提供必要协助，俄罗斯有关部门将与中方相关部门开展最密切协作，以尽快消除我们面临的这一共同威胁。\n白俄罗斯总统卢卡申科表示，中国领导人的高效应对和中国人民的英勇精神令人钦佩。白俄罗斯永远是中国的可靠、忠实朋友。白方将向中方提供医疗援助物资，帮助中国人民抗击疫情。\n泰国国王哇集拉隆功表示，国际社会对中国政府应对疫情的努力、决心和采取的广泛防疫措施印象深刻。我及全体泰国人民愿与中国人民同舟共济，祝愿中国早日成功克服困难，战胜疫情。\n尼泊尔总统班达里表示，在这个艰难时刻，我们将坚定地与中国政府和友好的中国人民团结在一起。我们对中国领导人为遏制疫情传播所作非凡努力深表赞赏和支持，感谢中方关照尼泊尔在华公民。\n突尼斯总统赛义德高度赞赏中国政府抗击疫情努力，表示相信在习近平主席坚强睿智领导下，中方举措一定能早日取得成效，成功控制疫情。\n喀麦隆总统比亚表示，在中国政府和中国人民行动起来英勇抗击疫情的时刻，我代表喀麦隆人民表达对中国人民的慰问和支持。\n科特迪瓦总统瓦塔拉表示，科特迪瓦政府和人民坚定支持中国政府和人民为战胜疫情所作努力。\n巴基斯坦总理伊姆兰·汗表示，巴方高度赞赏并坚定支持中方抗击疫情努力，感谢中方为巴在华公民提供帮助，坚信中方能够充分发挥独特制度优势战胜疫情，愿调集巴全国现在所有库存向中方提供抗疫医疗物资援助。巴基斯坦人民将坚定地与兄弟的中国人民站在一起。\n蒙古国总理呼日勒苏赫表示，蒙古国人民对中国政府和人民面临的疫情挑战感同身受，坚信在中国政府坚强领导和中国人民团结努力下，中方能够很快遏制疫情蔓延。在此困难时刻，蒙古国和蒙古国人民愿同中方并肩努力。\n新加坡总理李显龙表示，中国正在努力做好疫情防控，新加坡已做好准备，没有必要感到恐慌。新加坡将同中国密切合作，共同抗击疫情。\n圣多美和普林西比总理热苏斯向中国政府表达慰问和支持，表示相信中国一定能战胜当前疫情。\n泰国、印尼、印度、伊朗、埃塞俄比亚、布基纳法索、赤道几内亚、冈比亚、塞拉利昂等国外长赞赏中国领导人果断决策、正确指挥，迅速采取坚决有力措施，展现公开透明和负责任态度，表示相信中方一定能够取得抗击疫情的最终胜利。\n国际奥委会主席巴赫表示，我对中国人民正在作出的努力表示全力支持、高度赞赏和崇高敬意。中国人民正在积极有序抗击疫情，习近平主席亲自指挥、部署，给我们增添了信心。我们完全相信，北京2022年冬奥会筹备工作不会受到影响，中国将再次在北京欢迎全世界运动员同场竞技。\n上海合作组织秘书长诺罗夫表示，中国政府采取果断有力举措，特别是公开透明发布疫情信息，不仅体现了中国政府对人民生命健康的高度负责，也为地区和世界公共卫生事业发展作出重大贡献。相信勤劳勇敢、智慧坚强的中国人民一定能够在最短时间内打赢疫情防控阻击战。\n非盟委员会主席法基代表非洲联盟声援中国抗击疫情，表示在此艰难时刻，我们将与中国保持牢固团结。\n世界银行行长马尔帕斯、亚洲开发银行行长浅川雅嗣、亚洲基础设施投资银行行长金立群、新开发银行行长卡马特、博鳌论坛理事长潘基文、联合国儿童基金会执行主任福尔赞赏中国领导人和中国政府为抗击疫情采取的果断有力措施，相信中国必将打赢这场疫情防控阻击战，表示将坚定地与中国政府和中国人民站在一起，并准备为中方提供帮助。', '2020-02-01 17:10:38', '2020-02-01 17:11:42');
INSERT INTO `tb_note` VALUES ('22', '9', '管理员日记', '哈哈哈哈哈哈哈', '2020-02-01 18:55:47', '2020-02-01 18:56:02');
INSERT INTO `tb_note` VALUES ('27', '9', '2月3日起，湖北全省暂停办理婚姻登记！黄冈严控居民出行：每户每2天只能1人外出采购', '来源：21世纪经济报道\n走进经济生活里的一切\n导读：从2月1日起，在黄冈市区范围内实行居民出行管控措施。每户家庭每两天可指派1名家庭成员上街采购生活物资，其他人员除生病就医、疫情防控工作需要、在商超和药店上班外，不得外出。\n另外，湖北省民政厅表示：2月3日起，全省暂停办理婚姻登记。\n来 源丨央视新闻、人民日报、丁香医生、中国新闻网、南方周末等\n黄冈严控市区居民出行！\n每家每2天可指派1人上街采购\n今天（2月1日），记者从黄冈市新型冠状病毒感染的肺炎疫情防控工作指挥部了解到，为切实做好新型冠状病毒感染的肺炎疫情防控工作，黄冈市下发紧急通知，通知全文如下：\n关于加强黄冈市区人员出行管控工作的紧急通知\n为切实做好新型冠状病毒感染的肺炎疫情防控工作，最大限度减少人员流动，最大力度控制疫情传播，最大程度保证人民群众生命健康，经黄冈市新型冠状病毒感染的肺炎疫情防控工作指挥部研究，决定从2月1日起，在黄冈市区范围内实行居民出行管控措施。现就有关要求通知如下：\n一、严格控制市区居民出行。每户家庭每两天可指派1名家庭成员上街采购生活物资，其他人员除生病就医、疫情防控工作需要、在商超和药店上班外，不得外出。\n二、市区所有党员干部、人大代表、政协委员要发挥带头作用，管好自己、家人、亲属，带动街坊邻居，协助工作人员劝导小区居民按要求少出门、少上街、不串门、不聚集。\n三、对拒不听从居民小区工作人员管理劝阻、聚众闹事的，公安机关要加大打击力度。凡发现党员干部、公职人员不服从管理，不听从劝阻，参与聚众闹事的，提请纪检监察机关严肃问责，同时追究其所在单位主要负责人责任。\n四、驻居民小区联系包保的党员干部要切实履行包保责任，按时上岗履责，主动支持配合居民小区工作人员做好人员外出管控工作。履职不到位的，严肃问责。\n五、市区人员出行管控措施解除时间另行通知。\n各县（市、区）比照执行。\n2020年2月1日', '2020-02-02 05:43:30', '2020-02-02 05:45:14');
INSERT INTO `tb_note` VALUES ('28', '9', '报告“云监工”，武汉火神山医院已完工！', 'IT之家2月2日消息 据国内媒体报道，有记者从中建三局获悉，就在刚刚，武汉火神山医院完工。\n总建筑面积3.39万平方米，参照2003年非典期间北京小汤山医院所建的武汉火神山医院历时8天时间于今日建成，这座医院可容纳1000张床位，将于3日正式收治新型冠状病毒感染的肺炎患者。在春节假期延长期间，广大网友也化身“闲疯帝”通过网络监工武汉火神山医院建筑项目落成。\n武汉市火神山医院建造全过程：\n1月24日，除夕，上百台挖机抵达现场，开始土地平整。\n1月25日，大年初一，火神山医院正式开工。\n1月26日，大年初二，防渗层施工全面展开，地下管网沟槽开挖，集装箱板房材料陆续进场。\n1月27日，大年初三，场地整平、碎石黄沙回填全部完成，首批箱式集装箱板房吊装搭建。\n1月28日，大年初四，1栋双层病房区钢结构初显眉目。\n1月29日，大年初五，300多个箱式板房骨架安装完成，开始同步进行机电管线作业。\n1月30日，大年初六，HDPE膜铺设全面完成，同步进行污水处理间设备吊装。\n1月31日，大年初七，9成集装箱的拼装均已完成，活动板房骨架安装3000平方米。\n2月1日，大年初八，全面展开医疗配套设备安装。\n2月2日，大年初九，火神山医院工程完工。', '2020-02-02 05:46:03', '2020-02-02 05:46:26');
INSERT INTO `tb_note` VALUES ('29', '9', '中国疾控中心论文称新型冠状病毒12月已人传人引质疑 官方回应', '2020年1月29日，中国疾病预防控制中心、湖北省疾病预防控制中心等单位有关专业人员共同在新英格兰杂志发表了题为《新型冠状病毒感染的肺炎在中国武汉的初期传播动力学》的论文，有网友提出质疑。现将有关情况说明如下：\n一、论文是根据截至2020年1月23日上报的425例确诊病例（包括15名医务人员）所做的回顾性分析，所有病例在论文撰写前已向社会公布。论文中提及的15名医务人员感染病例，分别由国家卫健委高级别专家组组长钟南山院士于1月20日晚、武汉市卫健委于1月21日凌晨向社会公布。\n二、论文提出的“2019年12月份即在密切接触者中发生了人际传播”的观点，是基于425例病例流行病学调查资料做出的回顾性推论。\n三、论文是由来自中国疾病预防控制中心、湖北省疾病预防控制中心、香港大学等十几个单位的专业人员共同完成。\n四、及时在学术刊物发表调查结果，有助于国内外专业同行及时了解疾病的特征，共同评估和研判疫情，改进防控策略。\n感谢各位网友的关心和支持，欢迎对我们的工作进行监督。\n中国疾病预防控制中心\n2020年1月31日\n【报道回顾】\n【中国疾控中心主任新论文：新型冠状病毒12月中就开始人传人】1月29日，国际知名医学刊物《新英格兰医学杂志》刊登了一篇让许多中国网民震惊的论文。\n\n因为这篇关于武汉疫情的论文发现，新型冠状病毒可能在去年12月中旬，就已经开始人传人了……\n\n这篇由中国科学院院士、中国疾控中心主任高福等多名研究人员撰写的论文表示，他们通过分析确诊为新型冠状病毒感染者的425名病例后发现，新型冠状病毒可能早在12月中旬就已经出现了人传人的情况。', '2020-02-02 05:47:39', '2020-02-02 05:47:39');
INSERT INTO `tb_note` VALUES ('30', '9', '多渠道抗疫物资直达武汉协和：捐赠来得很多，但消耗得也快', '作为抗疫一线的重点医院，武汉协和医院的物资情况引发各方关注。\n2月1日上午，菜鸟“绿色通道”与快递公司连夜出击，将9省（区、市）40个单位的30多万件医疗物资，直接运抵武汉协和。\n多个渠道的救援物资直达武汉协和医院背后，是这家医院近日发出的防护用品告急信息。\n“不是告急！是没有了！”1月30日，一则显示武汉协和医院（全称：华中科技大学同济医学院附属协和医院）物资即将全部用尽的求助帖在互联网上流传：该院急需防护服3000件、医用N95口罩5000个、医用外科口罩8000个、一次性隔离衣3000件、防护面罩1000个。', '2020-02-02 05:48:05', '2020-02-02 05:48:05');
INSERT INTO `tb_note` VALUES ('31', '9', '百度上线 “新型肺炎防护自查手册” ，一站式获取权威防疫信息', '新型冠状病毒肺炎持续蔓延，截至1月29日13时，累计报告确诊病例6014例。在举国抗击肺炎的关键时期，民众关注疫情进展同时更需要全面系统地了解疫情防护相关权威知识，才能更好的远离疫情。近日，百度联合国家感染性疾病临床医学研究中心、传染病诊治国家重点实验室，推出了《新型肺炎防护自查手册》，民众可在线获得及时更新的新型冠状病毒肺炎防护、治疗权威指导。\n用户可以在百度搜索“肺炎”、“新型冠状病毒肺炎”等关键词，在搜索结果聚合页进入手册，也可在百度App“抗击肺炎”频道内查看，获取全面的防护、治疗信息。', '2020-02-02 05:48:58', '2020-02-02 05:48:58');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'ADMIN');
INSERT INTO `tb_role` VALUES ('2', 'USER');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('9', '管理员', 'admin', '$2a$10$3if5SOvBcL8Fv.Bgo6wtTOuMkfVNNETHJ7UxlZ5gZ79RvBpJxQyJC', '2020-01-30 10:41:00');
INSERT INTO `tb_user` VALUES ('10', '王大胖', 'mzq', '$2a$10$V/rbmRkC98b9B.AVZsk9fOGy8DNw6HxFALpKzgopb47BbxOHJioSi', '2020-01-30 11:31:16');
INSERT INTO `tb_user` VALUES ('11', 'mmm', 'mmm', '$2a$10$y16iVJ.vui88JYeNzfHUX.17CiIVkrmYqRrRQtpskyTCD3R5YKYZ.', '2020-02-01 18:09:17');
INSERT INTO `tb_user` VALUES ('12', 'wwww', 'w', '$2a$10$Ju4Z2lYNFbjZZa5aVkdW.eMxcJRXiT5k61AvcuyvnIF1hodEqgsAq', '2020-02-01 19:22:08');
INSERT INTO `tb_user` VALUES ('13', 'd', 'd', '$2a$10$yWRY2yikU9pwf28.iuvAM.2AE62Vi79dBXRENMVfBtAB.V2jzrvZC', '2020-02-02 07:05:05');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `userid_role_key` (`user_id`),
  CONSTRAINT `userid_role_key` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('9', '1');
INSERT INTO `tb_user_role` VALUES ('10', '2');
INSERT INTO `tb_user_role` VALUES ('11', '2');
INSERT INTO `tb_user_role` VALUES ('9', '2');
INSERT INTO `tb_user_role` VALUES ('12', '2');
INSERT INTO `tb_user_role` VALUES ('13', '2');
