insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf001','lxf001','刘向峰1','男','1992-01-01','lxf_44911@163.com','18050403041','山西大同一','037001');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf002','lxf002','刘向峰2','女','1992-02-02','lxf_44922@163.com','18050403042','山西大同二','037002');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf003','lxf003','刘向峰3','男','1992-03-03','lxf_44933@163.com','18050403043','山西大同三','037003');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf004','lxf004','刘向峰4','女','1992-04-04','lxf_44944@163.com','18050403044','山西大同四','037004');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf005','lxf005','刘向峰5','男','1992-05-05','lxf_44955@163.com','18050403045','山西大同五','037005');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf006','lxf006','刘向峰6','男','1992-06-01','lxf_44966@163.com','18050403046','山西大同六','037006');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf007','lxf007','刘向峰7','女','1992-07-02','lxf_44977@163.com','18050403047','山西大同七','037007');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf008','lxf008','刘向峰8','男','1992-08-03','lxf_44988@163.com','18050403048','山西大同八','037008');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf009','lxf009','刘向峰9','女','1992-09-04','lxf_44999@163.com','18050403049','山西大同九','037009');
insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode) values ('lxf000','lxf000','刘向峰0','男','1992-10-05','lxf_44900@163.com','18050403040','山西大同十','037000');

insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'电脑',0);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'手机',0);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'数码设备',0);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'联想',1);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'戴尔',1);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'惠普',1);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'索尼',3);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'苹果',2);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'华为',2);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'三星',2);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'小米',2);
insert into t_mc_type(nid,sname,npid) values (seq_t_mc_type.nextval,'东芝',3);

insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'联想y170','512G内存，500G磁盘，intel core i1处理器，集成显卡，win xp',1999,'lenovo1.jpg','0',date '2011-11-11',1,4);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'联想y270','1G内存，750G磁盘，intel core i2处理器，双显卡，win vista ',2999,'lenovo2.jpg','0',date '2012-1-24',1,4);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'联想y370','2G内存，750G磁盘，intel core i3处理器，双显卡，win7 32位',3999,'lenovo3.jpg','0',date '2013-2-24',1,4);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'联想y470','4G内存，750G磁盘，intel core i4处理器，双显卡，win7 64位',4999,'lenovo4.jpg','0',date '2013-4-14',1,4);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'联想y570','8G内存，750G磁盘，intel core i5处理器，双显卡，win8',5999,'lenovo5.jpg','0',date '2013-5-31',1,4);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'苹果1S','2G内存，iso1',2999,'iphone1.jpg','0',date '2013-10-10',2,8);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'苹果2S','4G内存，iso2',3999,'iphone2.jpg','0',date '2013-10-10',2,8);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'苹果3S','8G内存，iso3',4999,'iphone3.jpg','0',date '2013-10-10',2,8);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'苹果4s','16G内存，iso4',5999,'iphone4.jpg','0',date '2013-10-10',2,8);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'小米1','4G内存，2核处理器，android2.0.3',2999,'mi1.jpg','0',date '2013-1-1',2,11);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'小米2','8G内存，3核处理器，android3.0.3',3999,'mi2.jpg','0',date '2013-1-1',2,11);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'小米3','16G内存，4核处理器，android4.0.3',4999,'mi3.jpg','0',date '2013-1-1',2,11);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'三星','4G内存，2核处理器，android2.0.3',2999,'sanxing.jpg','0',date '2013-1-1',2,10);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'华为','8G内存，3核处理器，android3.0.3',3999,'huawei.jpg','0',date '2013-1-1',2,9);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'索尼照相机','1500W像素，全自动调焦技术',4999,'sony.jpg','0',date '2013-1-1',3,7);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'戴尔','4G内存，750G磁盘，intel core i3处理器，双显卡，win7 64位',4099,'dell.jpg','0',date '2013-4-14',1,5);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'惠普','4G内存，750G磁盘，intel core i3处理器，双显卡，win8',5099,'huipu.jpg','0',date '2013-5-31',1,6);
insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid) values (seq_t_mc.nextval,'东芝冰箱','全自动电脑控温，自动除霜技术',5999,'dongzhi.jpg','0',date '2013-10-10',3,12);

insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,sscode,ssphone ,ssemail )values(seq_t_order.nextval,'lxf001',sysdate,'网银支付','直接付款','2','4','1996.0','1','刘向峰1','山西大同1','037001','18050403041','lxf_44941@163.com')
insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,sscode,ssphone ,ssemail )values(seq_t_order.nextval,'lxf002',sysdate,'网银支付','直接付款','3','4','1199.0','1','刘向峰2','山西大同2','037002','18050403042','lxf_44942@163.com')
insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,sscode,ssphone ,ssemail )values(seq_t_order.nextval,'lxf003',sysdate,'网银支付','直接付款','2','4','11996.0','1','刘向峰3','山西大同3','037003','18050403043','lxf_44943@163.com')
insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,sscode,ssphone ,ssemail )values(seq_t_order.nextval,'lxf004',sysdate,'网银支付','直接付款','3','4','11880.0','1','刘向峰4','山西大同4','037004','18050403044','lxf_44944@163.com')
insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,sscode,ssphone ,ssemail )values(seq_t_order.nextval,'lxf005',sysdate,'网银支付','直接付款','2','4','41996.0','1','刘向峰5','山西大同5','037005','18050403045','lxf_44945@163.com')

insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,simg,ncount,nprice ,ntotalprice )values(seq_t_order_item.nextval,seq_t_order.currval,'1','联想y170','512G内存，500G磁盘，intel core i1处理器，集成显卡，win xp','lenovo1.jpg','1','1999','22994.0')
insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,simg,ncount,nprice ,ntotalprice )values(seq_t_order_item.nextval,seq_t_order.currval,'3','联想y370','2G内存，750G磁盘，intel core i3处理器，双显卡，win7 32位','lenovo3.jpg','2','3999','22994.0')
insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,simg,ncount,nprice ,ntotalprice )values(seq_t_order_item.nextval,seq_t_order.currval,'4','联想y470','4G内存，750G磁盘，intel core i4处理器，双显卡，win7 64位','lenovo4.jpg','1','4999','22994.0')
insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,simg,ncount,nprice ,ntotalprice )values(seq_t_order_item.nextval,seq_t_order.currval,'6','苹果1S','2G内存，iso1','iphone1.jpg','1','2999','22994.0')
insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,simg,ncount,nprice ,ntotalprice )values(seq_t_order_item.nextval,seq_t_order.currval,'8','苹果3S','8G内存，iso3','iphone3.jpg','1','4999','22994.0')

commit;