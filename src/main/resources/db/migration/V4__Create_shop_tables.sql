create table SHOP
(
    ID          int auto_increment,
    AREA_ID     int                            not null,
    NAME        VARCHAR(50)                    not null UNIQUE,
    LOGO        VARCHAR(1024)                  null,
    PHONE       VARCHAR(11)                    not null,
    SHOP_KEEPER VARCHAR(30)                    not null,
    STATUS      VARCHAR(20) default '审核中' not null comment '审核中 | 营业 | 停业',
    PASSWORD    VARCHAR(20)                    not null,
    DESCRIPTION VARCHAR(1024)                  null,
    CREATED_AT  TIMESTAMP   default NOW()      not null,
    UPDATED_AT  TIMESTAMP   default NOW()      not null,
    constraint SHOP_pk
        primary key (ID),
    constraint SHOP_AREA_ID_fk
        foreign key (AREA_ID) references AREA (ID)
)
    comment '店铺表';

create unique index SHOP_NAME_uindex
    on SHOP (NAME);

create unique index SHOP_PHONE_uindex
    on SHOP (PHONE);

INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '乐码', 'https://i.loli.net/2020/04/17/pZsFUXHktg7TucY.png',
        '15622958503', '许达成', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '喵鲜人', 'https://i.loli.net/2020/05/02/jGzLkOQlAZeVFiN.png',
        '15622958585', '许德明', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '美果秀', 'https://i.loli.net/2020/05/02/qmu3VSwH8yQe7JW.png',
        '15622958475', '许昊然', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '淘篮', 'https://i.loli.net/2020/05/02/13vythfJxrLmQs6.png',
        '15622958725', '许鸿朗', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '田觅园', 'https://i.loli.net/2020/05/02/HrsYTPXIzm1qKE3.png',
        '15622958589', '许景平', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '福若村', 'https://i.loli.net/2020/05/02/ngYtBhVc7dyvUMW.png',
        '15622958396', '许昆皓', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '集鲜丰', 'https://i.loli.net/2020/05/02/wM1qeLfjzYuUaSA.png',
        '15622958899', '许曦晨', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '绿美嘉', 'https://i.loli.net/2020/05/02/vBYfxSGPWN8DFLV.png',
        '15622958900', '许轩昂', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441928, '乐萃', 'https://i.loli.net/2020/05/02/dcxEwahlQmgH2zf.png',
        '15622958138', '许博耘', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');
INSERT INTO SHOP(AREA_ID, NAME, LOGO, PHONE, SHOP_KEEPER, STATUS, PASSWORD, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES (441302, '天美益', 'https://i.loli.net/2020/05/02/XvCZQ6eJwRBnYyu.png',
        '15622958739', '许晨轩', '营业', '123456', '一家好店，专注于生鲜食品一家好店，专注于生鲜食品一家好店，专注于生鲜食品', '2020-04-17 01:23:50', '2020-04-17 01:23:50');