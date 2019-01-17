drop database if exists `computer_mall`;  #如果数据库 computer_mall 存在，则删除该数据库
create database `computer_mall`;  #创建数据库
use `computer_mall`;	#引用数据库

#用户表  user
drop table if exists `user`;
create table `user`
(
	user_id int primary key auto_increment comment'id',
	user_account_number varchar(20) unique not null comment'登入账号',
	user_password varchar(16) not null comment'登入密码',
	user_nickname varchar(16) not null comment'用户昵称',
	user_state int default 1 comment'用户状态',  # 1 正常 0 冻结
	user_create_time datetime default now() comment'用户创建时间',
	user_head_portrait varchar(100) default '/images/head_portrait/599a521472424.jpg'
);

#添加数据
insert into `user`(user_account_number,user_password,user_nickname)
	values('ldl326308','123456','刘大仙'),('ch1224','123456','CH'),('oukele','123456','欧大仙'),('xiaobai','123456','小白'),
	('weibanggang','123456','杠总'),('daqi','123456','唐玉琪'),('chensheng','123456','陈胜'),('weifenghao','123456','韦奉豪'),
	('niulaoshi','123456','牛老师'),('wuguang','123456','吴广'),('huge','123456','胡歌');
		

# 查询所有用户 user
select * from `user`;

# 管理员表 administrators
drop table if exists `administrators`;
create table `administrators`
(
	admin_id int primary key auto_increment comment'id',
	admin_id_number varchar(24) unique not null comment'身份证号码',
	admin_account_number varchar(16)  unique not null comment'登入账号',
	admin_password varchar(16) default '20181123' not null comment'登入密码',
	admin_sexual enum('男','女') default '男' not null comment'性别',
	admin_age int comment'年龄',
	admin_power_user int default 0 comment'管理用户的权限', # 0 默认false 1 true
	admin_power_computer int default 0 comment'管理商品的权限', # 0 默认false 1 true
	admin_power_superme int default 0 comment'管理的最高权限',
	admin_state int default 0 comment'状态' # 0 默认正常 1 冻结
);

# 452226199809146014
insert into `administrators`(admin_id_number,admin_account_number,admin_password,admin_sexual,admin_age,
	admin_power_superme,admin_power_computer,admin_power_user)
	values('360731199912033434','ldl12345','nihaoma','男',19,1,1,1);

	

#查询管理员所有数据
select * from `administrators`;




#品牌表
drop table if exists `brand`;
create table `brand`
(
	brand_id int primary key auto_increment comment'id',
	brand_name varchar(12) not null comment'品牌名称',
	brand_title varchar(50) not null comment'品牌标题',
	brand_image varchar(200) not null comment'品牌图片'
);



#数据录入
insert into `brand`(brand_name,brand_title,brand_image) 
values('Lenovo','联想(Lenovo)','/images/brand/15668b30fabe0850.jpg'),
	('DELL','戴尔(DELL)','/images/brand/59804402N1c4e5159.jpg'),
	('HP','惠普(HP)','/images/brand/598035b4N9cd3ed1e.jpg'),
	('ThinkPad','ThinkPad','/images/brand/5a533a0eNdb977d35.png'),
	('ASUS','华硕(ASUS)','/images/brand/5a25249dN279cc35d.jpg'),
	('武极','武极','/images/brand/5a211ca7Nf8eb4275.jpg'),
	('华为','华为(HUAWEI)','/images/brand/f2c28fcb98037424.jpg'),
	('Apple','Apple','/images/brand/574d36dbN262ef26d.jpg'),
	('小米','小米(MI)','/images/brand/600c61f344607414.jpg'),
	('联想','联想(ThinkCentre)','/images/brand/5534b947Na4502fe8.jpg'),
	('御龙者','御龙者','/images/brand/568c6d4aNe52d233c.jpg'),
	('HASEE','神舟(HASEE)','/images/brand/59803674N3ea83874.jpg'),
	('SAMSUNG','三星(SAMSUNG)','/images/brand/74dc92d16e483509.jpg'),
	('极限矩阵','极限矩阵','/images/brand/5b693a42N871ad037.jpg'),
	('钛度','钛度(Taidu)','/images/brand/59813344N7ae1f7d3.jpg'),
	('Haier','海尔(Haier)','/images/brand/5b221dd6N8b93f2ef.jpg');

select * from `brand`;

#类型表 type
drop table if exists `type`;
create table `type`
(
	type_id int primary key auto_increment comment'id',
	type_name varchar(20) not null comment'类型名称'
);

# 添加数据
insert into `type`(type_name) 
	values('台式机'),('笔记本'),('一体机'),('游戏本'),('平板电脑'); 

select * from `type`;

#处理器表 processor
drop table if exists `processor`;
create table `processor`
(
	processor_id int primary key auto_increment comment'id',
	processor_name varchar(30) not null comment'处理器名称'
);

# 添加处理器
insert into `processor`(processor_name) 
	values('Intel i7'),('Intel i5'),('Intel i3'),('Intel奔腾 赛扬'),('AMD'),('Ryzen锐龙'),('Intel i5低功耗版'),('Intel 其他'),('锐龙5'),
	('Intel 奔腾'),('intel CoreM'),('Intel i7低功耗版'),('Intel i7标准电压版'),('桌面级处理器'),('Intel i5标准电压版'),('AMD系列'),('其它');

select * from `processor`;

# 内存容量 memory_capacity
drop table if exists `memory_capacity`;
create table `memory_capacity`
(
	memory_capacity_id int primary key auto_increment comment'id',
	memory_capacity_name varchar(10) not null comment'内存容量名称'
);

# 添加数据
insert into `memory_capacity`(memory_capacity_name) 
	values('2G'),('4G'),('4GB'),('8G'),('8GB'),('16G'),('16GB'),('32G'),('其它');

select * from `memory_capacity`;

# 硬盘容量表 hard_disk
drop table if exists `hard_disk`;
create table `hard_disk`
(
	hard_disk_id int primary key auto_increment comment'id',
	hard_disk_name varchar(20) not null comment'硬盘容量名称'
);

# 添加数据
insert into `hard_disk`(hard_disk_name)
	values('1T'),('固态+机械'),('固态硬盘'),('2T'),('500G'),('1TB'),('256G固态'),('机械+固态硬盘'),('128G固态'),
	('512G+1T'),('128G+500G'),('240G固态+1T'),('240G固态'),('512G固态'),('混合硬盘'),('128G+1T'),('256G+1T'),('其它');

select * from `hard_disk`;


# 电脑系统表 computer_system
drop table if exists `computer_system`;
create table `computer_system`
(
	computer_system_id int primary key auto_increment comment'id',
	computer_system_name varchar(30) not null comment'系统名称'
);

# 添加数据
insert into `computer_system`(computer_system_name) 
	values('Windows 10'),('Windows 7'),('windows'),('MAC'),('ios系统'),('Android'),('Windows 7 专业版'),('shell'),
	('DOS/Linux'),('双系统'),('Windows 8'),('Windows 10专业版'),('IOS'),('其它');

select * from `computer_system`;


# 电脑尺寸表 dimension
drop table if exists `dimension`;
create table `dimension`
(
	dimension_id int primary key auto_increment comment'id',
	dimension_name varchar(30) not null comment'尺寸名称'
);

# 添加数据
insert into `dimension`(dimension_name) 
	values('22-23.8英寸'),('20-21.5英寸'),('21.5英寸'),('27英寸以上'),('23.8英寸以上'),('19.5英寸及以下'),('15.6英寸'),
	('27英寸'),('14.0英寸'),('19.5-20英寸'),('13.3英寸'),('17.3英寸'),('11.6英寸'),('12.5英寸'),('18.4英寸'),('其它');

select * from `dimension`;


#电脑显卡表 nvdia
drop table if exists `nvdia`;
create table `nvdia`
(
	nvdia_id int primary key auto_increment comment'id',
	nvdia_name varchar(30) not null comment'电脑显卡名称'
);

#添加数据
insert into `nvdia`(nvdia_name) 
	values('集成显卡'),('AMD芯片'),('GTX 9系/7系'),('GTX1050Ti 4G/ GTX1050 2G'),('GTX1060 3G/6G'),('1G独显'),('GTX1050Ti 4G/GTX1050 2G'),
	('GTX1070 8G'),('1080TI 11G/GTX1080 8G'),('4G独显'),('GTX1060'),('RTX2080'),('K620'),('RTX2080TI'),('GTX750'),('GTX1080'),
	('GTX650'),('GTX1080Ti'),('RX570'),('RX580'),('RTX2070'),('GTX1050Ti'),('GTX1050'),('P1000'),('p600'),('其它'),('6G独显'),('2G独显');


select * from `nvdia`;


# 电脑商品表
drop table if exists `computer`;
create table `computer`
(
	computer_id int primary key auto_increment comment'id',
	computer_describe varchar(200) not null comment'电脑描述',
	computer_price decimal(10,2) not null comment'电脑价格',
	computer_state int default 0 comment'商品状态', # 0 默认正常 1 下架
	computer_create_time datetime default now() comment'商品添加时间',
	brand_id int comment'品牌',
	type_id int comment'类型',
	processor_id int comment'处理器',
	memory_capacity_id int comment'内存容量',
	hard_disk_id int comment'硬盘容量',
	computer_system_id int comment'电脑系统',
	dimension_id int comment'电脑尺寸',
	nvdia_id int comment'电脑显卡',
	foreign key (brand_id) references `brand`(brand_id),
	foreign key (type_id) references `type`(type_id),
	foreign key (processor_id) references `processor`(processor_id),
	foreign key (memory_capacity_id) references `memory_capacity`(memory_capacity_id),
	foreign key (hard_disk_id) references `hard_disk`(hard_disk_id),
	foreign key (computer_system_id) references `computer_system`(computer_system_id),
	foreign key (dimension_id) references `dimension`(dimension_id),
	foreign key (nvdia_id) references `nvdia`(nvdia_id)
	
);
select * from brand;
select * from `type`;
select * from processor;
select * from memory_capacity;
select * from hard_disk;
select * from computer_system;
select * from `dimension`;
select * from nvdia;

insert into `computer`(computer_describe,computer_price,brand_id,type_id,processor_id,memory_capacity_id,hard_disk_id,computer_system_id,dimension_id,nvdia_id)
	values('联想(Lenovo)小新潮7000 14英寸英特尔八代酷睿轻薄窄边框笔记本电脑(I5-8250U 8G 2T+128G PCIE R535 2G)银',5399.00,1,2,2,1,16,1,9,3),
	('联想(Lenovo)拯救者Y7000 15.6英寸游戏笔记本电脑(英特尔八代酷睿i7-8750H 8G 2T+128G GTX1050Ti 黑)',7599.00,1,2,1,4,16,1,7,22),
	('联想（Lenovo）天逸510 Pro商用台式电脑整机（英特尔八代酷睿i5-8400 8G 1T GT730 2G独显 ）23英寸',5099.00,1,1,2,4,1,2,1,6),
	('联想(Lenovo)330C15.6英寸英特尔八代酷睿商务影音笔记本电脑(i5-8250U 4G 1T+128G MX110 Office)黑',4399.00,1,2,2,2,16,1,1,2),
	('联想(Lenovo)拯救者Y7000P英特尔八代酷睿 15.6英寸游戏笔记本电脑(i7-8750H 8G 512G PCIE GTX1060 144Hz黑)',8699.00,1,4,1,4,14,1,7,5),
	('联想小新平板电脑 10.1英寸安卓pad 娱乐游戏轻薄 TB-X804F WIFI版 香槟金 官方标配',1788.00,1,5,8,3,18,6,13,26),
	('联想 Miix520二合一平板电脑 12英寸笔记本电脑（i5-8250U 8G/256G/内含键盘/指纹识别)闪电银',5549.00,1,5,2,4,7,2,14,26),
	('戴尔DELL游匣G3烈焰版 15.6英寸游戏笔记本电脑(i7-8750H 8G 128GSSD 1T GTX1060MQ 6G独显 背光键盘 IPS)',7999.00,2,2,1,4,9,1,7,26),
	('戴尔DELL灵越燃7000 II 14.0英寸轻薄窄边框笔记本电脑(i5-8250U 8G 256GSSD IPS Win10)元気粉',5099.00,2,2,2,4,7,1,9,1),
	('戴尔DELL XPS13.3英寸超轻薄窄边框笔记本电脑(i5-8250U 8G 256GSSD IPS 2年全智服务)无忌银',7699.00,2,2,2,4,7,1,11,4),
	('戴尔(DELL)成就3470高性能商用办公台式电脑整机(八代i3-8100 8G 1T 四年上门售后 键鼠 WIFI 蓝牙)21.5英寸',3399.00,2,1,3,4,18,1,3,3),
	('华硕(ASUS) 飞行堡垒5 15.6英寸游戏笔记本电脑(i5-8300H 8G 128GSSD+1T GTX1050Ti 4G IPS)火陨红黑(FX80)',6299.00,5,4,2,4,16,1,7,1),
	('华硕顽石(ASUS) 畅玩版Y5000 15.6英寸窄边框娱乐办公笔记本电脑(i5-8250U 8G 1T 2G独显) 灰色',4299.00,5,2,2,4,16,1,7,2),
	('华硕(ASUS) 灵耀U 2代 14英寸合金机身轻薄笔记本电脑(i5-8265U 8G 512GSSD MX150 2G IPS)尊爵蓝(U4300)',6999.00,5,2,2,4,10,1,9,26),
	('华硕（ASUS） 旗舰店 轻薄PX554 15.6英寸手提笔记本电脑 银灰色 i5-8250U/8G/256G SSD',4399.00,5,2,2,4,17,1,7,3),
	('华硕(ASUS)傲世V241IC 23.8英寸一体机电脑(新八代i5-8250U 8G内存 128GSSD+1T 2G独显 高清 上门售后)黑',5199.00,5,2,2,4,9,1,5,28),
	('华硕(ASUS) 飞行堡垒5 15.6英寸游戏笔记本电脑(i5-8300H 8G 128GSSD+1T GTX1050Ti 4G IPS)火陨红黑(FX80)',5999.00,5,4,2,4,9,1,7,1),
	('游戏本YX570顽石热血版15.6英寸商务办公学生笔记本电脑 黑+闪电蓝 定制 四核/8G/1T+128G/GTX1050',4799.00,5,2,2,4,16,1,7,27),
	('三星（SAMSUNG）35X0AA-X04 15.6英寸轻薄笔记本电脑（i5-8250U 8G 500GB+128GSSD 2G独显 FHD Win10）黑',3969.00,13,2,2,4,9,1,7,28),
	('三星（SAMSUNG）300E5M-L06 15.6英寸笔记本电脑（3865U 4G 128GB 高清屏 Win10）白',2069.00,13,2,2,2,9,1,7,26),
	('三星Tab E T560平板电脑 9.6英寸WIFI娱乐 星小E 白色',799.00,13,5,3,9,18,1,16,26),
	('三星（SAMSUNG） 350XAA 15.6英寸高清轻薄便携商务办公 手提电脑学生游戏笔记本电脑 月光灰 【定制】3865U/4G/500G+128G',2499.00,13,2,2,2,9,1,7,2),
	('三星（SAMSUNG） 350XAA 15.6英寸超薄便携商务办公手提电脑 独显学生游戏笔记本电脑 月光灰 350XAA i5-8250U 【定制】i5/8G/1T+NVMe128G',4399.00,13,2,2,4,16,1,7,2),
	('三星（SAMSUNG） 笔记本战匣旗舰店 超薄15.6英寸轻薄便携学生商务办公笔记本电脑 新品白色 8G/500G+128GSSD/定制',2899.00,13,2,2,4,11,1,7,1),
	('海尔（Haier）天越Y30 商用台式办公电脑整机(新八代G4900 4G 1TB 有线键鼠 正版Win10 三年上门)19.5英寸IPS',2188.00,16,1,2,2,18,1,6,1),
	('海尔（Haier）简爱S11 11.6英寸轻薄便携二合一触控笔记本电脑(Intel四核 4G 64G 360°翻转 1080P Win10)灰',1499.00,16,2,8,2,18,1,13,2),
	('海尔（Haier）天越X7 21.5英寸轻薄微边一体机商用办公台式电脑(四核J3160 4G 120G SSD 双频WIFI 无线键鼠)',2099.00,16,3,1,2,18,1,3,27),
	('神舟(HASEE) 战神Z7-KP7GC GTX1060 6G独显 15.6英寸游戏笔记本电脑(i7-8750H 8G 1T+128G SSD 1080P)IPS',6999.00,12,2,1,4,16,1,7,11);
	
select count(*) from `computer` where computer.computer_describe like '%华硕%';

select * from `computer`;

select * from `type`;

# 商品图片 computer_image
drop table if exists `computer_image`;
create table `computer_image`
(
	computer_image_id int primary key auto_increment comment'id',
	computer_id int comment'商品id',
	computer_image_url varchar(100) not null comment'图片地址',
	foreign key (computer_id) references `computer`(computer_id)
);

# 添加数据
insert into `computer_image`(computer_id,computer_image_url) 
	values(1,'/images/computer/5b3c3822Nea8f73e4.jpg'),(1,'/images/computer/5b3c3823Nb0530bbb.jpg'),(1,'/images/computer/5ac9ac60N04e25348.jpg'),
	(2,'/images/computer/5b11632fNbcf2b880.jpg'),(2,'/images/computer/5b07bf70Nb0dc19ac.jpg'),(2,'/images/computer/5b07bf74N63a18425.jpg'),
	(3,'/images/computer/5b0fd9dbNeadc1b8d.jpg'),(3,'/images/computer/5b068304N9cb7d10a.jpg'),(3,'/images/computer/5b06830eNac588068.jpg'),
	(4,'/images/computer/5b723894N7b459827.jpg'),(4,'/images/computer/5b723898Nd5cd8d20.jpg'),(4,'/images/computer/5b151d7cN10a57e9d.jpg'),
	(5,'/images/computer/5bea4504Nb056f6cb.jpg'),(5,'/images/computer/5b63d543N72e67ca2.jpg'),(5,'/images/computer/5b63d5c2N19b49f4c.jpg'),
	(6,'/images/computer/5bf3ea0aN4960c965.jpg'),(6,'/images/computer/5a252a4cN5a2c9601.jpg'),(6,'/images/computer/5a252a4aN08795195.jpg'),
	(7,'/images/computer/5a027e8dNa2766ce3.jpg'),(7,'/images/computer/5a02a07fN060b0041.jpg'),(7,'/images/computer/5a02a07fNf9fb9726.jpg'),
	(8,'/images/computer/5b8c9a05N5da289f4.jpg'),(8,'/images/computer/5b8c9a05N70384091.jpg'),(8,'/images/computer/5b8c9a05N864a476e.jpg'),
	(9,'/images/computer/59f15bb4Nf9517d75.jpg'),(9,'/images/computer/59c38f2bN216f7622.jpg'),(9,'/images/computer/5a1ba712Ne76c1ca8.jpg'),
	(10,'/images/computer/59f156f1N704c1c7a.jpg'),(10,'/images/computer/59b261dfN40cd53d7.jpg'),(10,'/images/computer/5a1d1684N9426a1b8.jpg'),
	(11,'/images/computer/5ae00211N25afad2c.jpg'),(11,'/images/computer/5ade9570Nce9d5157.jpg'),(11,'/images/computer/5ae190daN7b9a4f44.jpg'),
	(12,'/images/computer/5b714df8N00e75d13.jpg'),(12,'/images/computer/5ac1d880N8fd51747.jpg'),(12,'/images/computer/5ac1d886Na0751754.jpg'),
	(13,'/images/computer/5bf4c103N739ef1b9.jpg'),(13,'/images/computer/5b7293b8N39fa9e52.jpg'),(13,'/images/computer/5b7293b8N770a954c.jpg'),
	(14,'/images/computer/5bf4c103N739ef1b9.jpg'),(14,'/images/computer/5b7293b9N51c8c8ca.jpg'),(14,'/images/computer/5b7293b9Nc5596e51.jpg'),
	(15,'/images/computer/5bf38350N60acad0f.jpg'),(15,'/images/computer/b21ace1fa114c54e.jpg'),(15,'/images/computer/23d6a48c2ef1c1f0.jpg'),
	(16,'/images/computer/5bf38225Nece16556.jpg'),(16,'/images/computer/5b778982N310b9734.jpg'),(16,'/images/computer/5b778982Na884518f.jpg'),
	(17,'/images/computer/5b1e17b2Nb62472fd.jpg'),(17,'/images/computer/5b4d63f0Nb302d7d2.jpg'),(17,'/images/computer/31901ed484c239d7.jpg'),
	(18,'/images/computer/5b714df8N00e75d13.jpg'),(18,'/images/computer/5ac1d886Na0751754.jpg'),(18,'/images/computer/5ac1d88eN62354e3f.jpg'),
	(19,'/images/computer/5bfa90e5N14eb4b40.jpg'),(19,'/images/computer/5baf1295N5ae3d86e.jpg'),(19,'/images/computer/5badc63dNe79c6a7d.jpg'),
	(20,'/images/computer/5bbf0c20N627d644d.jpg'),(20,'/images/computer/5acc36f0N44cfe41d.jpg'),(20,'/images/computer/5b023422Nd0a5a2f8.jpg'),
	(21,'/images/computer/5bbf0dddN33c9da74.jpg'),(21,'/images/computer/33bb900f2d2d1573.jpg'),(21,'/images/computer/3dacc9fdaac6e81e.jpg'),
	(22,'/images/computer/567a05edNecaa1f0a.jpg'),(22,'/images/computer/567a05faN01b531b9.jpg'),(22,'/images/computer/567a05f1Naecc8144.jpg'),
	(23,'/images/computer/5b582284N273ebaa7.jpg'),(23,'/images/computer/5b582284N91fb5525.jpg'),(23,'/images/computer/5b582284N4d539628.jpg'),
	(24,'/images/computer/5bea3fa2Nd3641143.jpg'),(24,'/images/computer/3bf7cc4ccb0f8bbc.jpg'),(24,'/images/computer/5b5985ebN3c822906.jpg'),
	(26,'/images/computer/598e8a7dN9ecbd47a.jpg'),(25,'/images/computer/5a162978N948fb06f.jpg'),(25,'/images/computer/58ae9d31Nd3abeca7.jpg'),
	(25,'/images/computer/5b7691f6N656bfc30.jpg'),(26,'/images/computer/5b7691e5Ne12a0c35.jpg'),(26,'/images/computer/5b76916cN76ad11f6.jpg'),
	(27,'/images/computer/bd650555baf114ab.jpg'),(27,'/images/computer/bb8f4811394624ea.jpg'),(27,'/images/computer/aa49f29c0539dcba.jpg'),
	(28,'/images/computer/5abdebe9Nb9531f98.jpg'),(28,'/images/computer/5ad6fac3N20935d11.jpg'),(28,'/images/computer/5abdebb3N2738bf5a.jpg');


# 收货地址表 address
drop table if exists `address`;
create table `address`
(
	address_id int primary key auto_increment comment'id',
	receiving_name varchar(20) not null comment'收货人姓名',
	address_name varchar(50) not null comment'收货地址',
	receiving_phone varchar(20) not null comment'收货人联系电话',
	address_detailed varchar(50) null comment'收货详细地址',
	user_id int comment'用户id',
	foreign key (user_id) references `user`(user_id)
);


#insert into `address`(receiving_name,address_name,receiving_phone,address_detailed,user_id)
#	values('刘地林','广东省珠海市斗门区','13718071824','南方IT学院',1);


select * from `address`;

select * from `address` where address.user_id = 1;

# 购物车表 shopping_cart
drop table if exists `shopping_cart`;
create table `shopping_cart`
(
	shopping_id int primary key auto_increment comment'id',
	computer_id int comment'商品id',
	computer_count int comment'商品数量',
	shopping_cart_state int default 0 comment'状态',
	user_id int comment'用户id',
	foreign key (computer_id) references `computer`(computer_id),
	foreign key (user_id) references `user`(user_id)
);


select * from shopping_cart 
inner join computer
on shopping_cart.computer_id = computer.computer_id
where shopping_cart.shopping_id in (5,6);

select * from shopping_cart 
	inner join computer on shopping_cart.computer_id = computer.computer_id 
	inner join `user` on shopping_cart.user_id = `user`.user_id;

select * from `shopping_cart`;


#订单表 order
drop table if exists `order`;
create table `order`
(
	order_id int primary key auto_increment comment'id',
	order_number varchar(100) not null comment'订单编号',
	address_id int comment'地址id',
	shopping_cart_id int comment'购物车id',
	order_total_price decimal(10,2) comment'总价钱',
	order_create_time datetime default now() not null comment'订单生成时间',
	user_id int comment'用户id',
	order_state int default 0 comment'订单状态',
	foreign key (address_id) references `address`(address_id),
	foreign key (user_id) references `user`(user_id)
);

select * from `order`;


#insert into `order`(order_number,address_id,shopping_cart_id,order_total_price,user_id)
#	values('ho902kksjd8003',1,1,5999.00,1);

select computer.computer_id,computer.computer_describe,computer.computer_price,computer.computer_state,computer.computer_create_time,
	brand.*,`type`.*,processor.*,memory_capacity.*,hard_disk.*,computer_system.*,`dimension`.*,`nvdia`.*,
	computer_image.computer_image_id,computer_image.computer_image_url
from computer
inner join brand on computer.brand_id = brand.brand_id
inner join `type` on computer.type_id = `type`.type_id
inner join processor on computer.processor_id = processor.processor_id
inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
inner join `dimension` on dimension.dimension_id = computer.dimension_id
inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
inner join computer_image on computer.computer_id = computer_image.computer_id
where computer.computer_state = 0
group by computer.computer_id;


  select count(*) from computer
  inner join brand on computer.brand_id = brand.brand_id
  inner join `type` on computer.type_id = `type`.type_id
  inner join processor on computer.processor_id = processor.processor_id
  inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
  inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
  inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
  inner join `dimension` on dimension.dimension_id = computer.dimension_id
  inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
  where  computer.computer_state = 0;
  
#查询电脑信息
select * from computer inner join brand on computer.brand_id = brand.brand_id 
inner join `type` on computer.type_id = `type`.type_id 
inner join processor on computer.processor_id = processor.processor_id 
inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id 
inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id 
inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
inner join `dimension` on dimension.dimension_id = computer.dimension_id 
inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id 
inner join computer_image on computer.computer_id = computer_image.computer_id 
group by computer.computer_id;
 
 
select * from computer 
inner join shopping_cart on computer.computer_id = shopping_cart.computer_id
inner join brand on computer.brand_id = brand.brand_id 
inner join `type` on computer.type_id = `type`.type_id 
inner join processor on computer.processor_id = processor.processor_id 
inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id 
inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id 
inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
inner join `dimension` on dimension.dimension_id = computer.dimension_id 
inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id 
inner join computer_image on computer.computer_id = computer_image.computer_id 
group by computer.computer_id
having shopping_cart.user_id = 1 and shopping_cart.shopping_cart_state = 0;
 
select count(*)/3 from computer 
inner join brand on computer.brand_id = brand.brand_id 
inner join `type` on computer.type_id = `type`.type_id 
inner join processor on computer.processor_id = processor.processor_id 
inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id 
inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id 
inner join computer_system on computer.computer_system_id = computer_system.computer_system_id 
inner join `dimension` on dimension.dimension_id = computer.dimension_id 
inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id 
inner join computer_image on computer.computer_id = computer_image.computer_id 
WHERE `type`.type_id = 2;

select * from computer where computer.brand_id = 1;

select * from computer inner join brand on computer.brand_id = brand.brand_id 
inner join `type` on computer.type_id = `type`.type_id 
inner join processor on computer.processor_id = processor.processor_id 
inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id 
inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id 
inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
 inner join `dimension` on dimension.dimension_id = computer.dimension_id 
 inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id 
 inner join computer_image on computer.computer_id = computer_image.computer_id 
 where computer.computer_id = 1;

select * from shopping_cart inner join computer on shopping_cart.computer_id = computer.computer_id
	where shopping_cart.shopping_id in (5,6);
	
select * from shopping_cart;	
	
 select * from computer
 inner join shopping_cart on computer.computer_id = shopping_cart.computer_id
 inner join brand on computer.brand_id = brand.brand_id
 inner join `type` on computer.type_id = `type`.type_id
 inner join processor on computer.processor_id = processor.processor_id
 inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
 inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
 inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
 inner join `dimension` on dimension.dimension_id = computer.dimension_id
 inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
 inner join computer_image on computer.computer_id = computer_image.computer_id
 group by computer.computer_id
 having shopping_cart.shopping_id in(11,12);
	
	
    select * from computer
    inner join shopping_cart on computer.computer_id = shopping_cart.computer_id
    inner join brand on computer.brand_id = brand.brand_id
    inner join `type` on computer.type_id = `type`.type_id
    inner join processor on computer.processor_id = processor.processor_id
    inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
    inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
    inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
    inner join `dimension` on dimension.dimension_id = computer.dimension_id
    inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
    inner join computer_image on computer.computer_id = computer_image.computer_id
    group by computer.computer_id
    having shopping_cart.shopping_id in (11,14);
	

select count(*) from (
 		select 
		 	computer.computer_id
		  from computer
        inner join brand on computer.brand_id = brand.brand_id
        inner join `type` on computer.type_id = `type`.type_id
        inner join processor on computer.processor_id = processor.processor_id
        inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
        inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
        inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
        inner join `dimension` on dimension.dimension_id = computer.dimension_id
        inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
        inner join computer_image on computer.computer_id = computer_image.computer_id
        where   computer.computer_state = 0 
        group by computer.computer_id ) a;
	
	
	
	 select * from computer
    inner join shopping_cart on computer.computer_id = shopping_cart.computer_id
    inner join brand on computer.brand_id = brand.brand_id
    inner join `type` on computer.type_id = `type`.type_id
    inner join processor on computer.processor_id = processor.processor_id
    inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
    inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
    inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
    inner join `dimension` on `dimension`.dimension_id = computer.dimension_id
    inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
    inner join computer_image on computer.computer_id = computer_image.computer_id
    inner join `order` on shopping_cart.shopping_id = `order`.shopping_cart_id
    inner join `address` on `address`.address_id = `order`.address_id
    where `order`.order_state = 0
	group by `order`.order_id;
	
	select count(*) from (
	 select computer.*,shopping_cart.computer_count,shopping_cart.shopping_id,brand.brand_name,`type`.type_name,processor.processor_name,
	 memory_capacity.memory_capacity_name,hard_disk.hard_disk_name,computer_system.computer_system_name,`dimension`.dimension_name,`nvdia`.nvdia_name,
	 computer_image.computer_image_id,computer_image.computer_image_url,`order`.*,
	 `address`.receiving_name,`address`.address_name,`address`.receiving_phone  from computer
    inner join shopping_cart on computer.computer_id = shopping_cart.computer_id
    inner join brand on computer.brand_id = brand.brand_id
    inner join `type` on computer.type_id = `type`.type_id
    inner join processor on computer.processor_id = processor.processor_id
    inner join memory_capacity on computer.memory_capacity_id = memory_capacity.memory_capacity_id
    inner join hard_disk on computer.hard_disk_id = hard_disk.hard_disk_id
    inner join computer_system on computer.computer_system_id = computer_system.computer_system_id
    inner join `dimension` on `dimension`.dimension_id = computer.dimension_id
    inner join `nvdia` on computer.nvdia_id = `nvdia`.nvdia_id
    inner join computer_image on computer.computer_id = computer_image.computer_id
    inner join `order` on shopping_cart.shopping_id = `order`.shopping_cart_id
    inner join `address` on `address`.address_id = `order`.address_id
    where  `order`.order_state = 0
    group by `order`.order_id
    ) a;
	
	
	select * from `order`;
	
	