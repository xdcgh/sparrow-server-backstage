create table FRESH
(
    ID          int auto_increment,
    TYPE_ID     int                          not null,
    SHOP_ID     int                          not null,
    AREA_ID int not null ,
    NAME        VARCHAR(50)                  not null,
    DESCRIPTION VARCHAR(100)                 null,
    DETAIL      VARCHAR(1024)                null,
    PICTURE     VARCHAR(1024)                null,
    PRICE       int         default 1        not null comment '单位是分',
    STOCK       int         default 0        not null,
    STATUS      VARCHAR(10) default 'online' not null comment 'online | stopping',
    CREATED_AT  TIMESTAMP   default NOW()    not null,
    UPDATED_AT  TIMESTAMP   default NOW()    not null,
    count       int         default 0,
    constraint FRESH_pk
        primary key (ID),
    constraint FRESH_FRESH_TYPE_ID_fk
        foreign key (TYPE_ID) references FRESH_TYPE (ID),
    constraint FRESH_SHOP_ID_fk
        foreign key (SHOP_ID) references SHOP (ID),
    constraint FRESH_AREA_ID_fk
        foreign key (AREA_ID) references AREA (ID)
)
    comment '生鲜商品表';

INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '香橙', '新鲜的香橙', '以下为详细描述', 'https://i.loli.net/2020/04/17/bTWDoZCXfyidkHO.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '龙眼', '新鲜的龙眼', '以下为详细描述', 'https://i.loli.net/2020/04/17/keDy7B58cOC3qSR.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '火龙果', '新鲜的火龙果', '以下为详细描述', 'https://i.loli.net/2020/04/17/Xq6Kwn9kHxr2mL3.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '香橙', '新鲜的香橙', '以下为详细描述', 'https://i.loli.net/2020/04/17/bTWDoZCXfyidkHO.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '龙眼', '新鲜的龙眼', '以下为详细描述', 'https://i.loli.net/2020/04/17/keDy7B58cOC3qSR.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 441928,  '火龙果', '新鲜的火龙果', '以下为详细描述', 'https://i.loli.net/2020/04/17/Xq6Kwn9kHxr2mL3.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 1, 441928,  '蚕豆', '新鲜的蚕豆', '以下为详细描述', 'https://i.loli.net/2020/04/17/86zfQpvt5eCi1AN.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 1, 441928,  '枸杞头', '新鲜的枸杞头', '以下为详细描述', 'https://i.loli.net/2020/04/17/H1TqgRupGv9Mi3s.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 1, 441928,  '蚕豆', '新鲜的蚕豆', '以下为详细描述', 'https://i.loli.net/2020/04/17/86zfQpvt5eCi1AN.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 1, 441928,  '枸杞头', '新鲜的枸杞头', '以下为详细描述', 'https://i.loli.net/2020/04/17/H1TqgRupGv9Mi3s.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '牛肉', '新鲜的牛肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/aSXPjcqyQBeIJLw.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '五花肉', '新鲜的五花肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/Mfse3lEL1J6V9d5.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '鸡肉', '新鲜的鸡肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/ngx9eEXbQu2Gdvs.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '牛肉', '新鲜的牛肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/aSXPjcqyQBeIJLw.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '五花肉', '新鲜的五花肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/Mfse3lEL1J6V9d5.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '鸡肉', '新鲜的鸡肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/ngx9eEXbQu2Gdvs.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '牛肉', '新鲜的牛肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/aSXPjcqyQBeIJLw.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '五花肉', '新鲜的五花肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/Mfse3lEL1J6V9d5.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 1, 441928,  '鸡肉', '新鲜的鸡肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/ngx9eEXbQu2Gdvs.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');

INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 2, 441928, '香橙', '新鲜的香橙', '以下为详细描述', 'https://i.loli.net/2020/04/17/bTWDoZCXfyidkHO.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 2, 441928, '龙眼', '新鲜的龙眼', '以下为详细描述', 'https://i.loli.net/2020/04/17/keDy7B58cOC3qSR.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 2, 441928, '火龙果', '新鲜的火龙果', '以下为详细描述', 'https://i.loli.net/2020/04/17/Xq6Kwn9kHxr2mL3.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 2, 441928, '蚕豆', '新鲜的蚕豆', '以下为详细描述', 'https://i.loli.net/2020/04/17/86zfQpvt5eCi1AN.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 2, 441928, '枸杞头', '新鲜的枸杞头', '以下为详细描述', 'https://i.loli.net/2020/04/17/H1TqgRupGv9Mi3s.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 2, 441928, '牛肉', '新鲜的牛肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/aSXPjcqyQBeIJLw.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 2, 441928, '五花肉', '新鲜的五花肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/Mfse3lEL1J6V9d5.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 2, 441928, '鸡肉', '新鲜的鸡肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/ngx9eEXbQu2Gdvs.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');


INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 3, 441928, '香橙', '新鲜的香橙', '以下为详细描述', 'https://i.loli.net/2020/04/17/bTWDoZCXfyidkHO.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 4, 441928,  '龙眼', '新鲜的龙眼', '以下为详细描述', 'https://i.loli.net/2020/04/17/keDy7B58cOC3qSR.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 3, 441928, '火龙果', '新鲜的火龙果', '以下为详细描述', 'https://i.loli.net/2020/04/17/Xq6Kwn9kHxr2mL3.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 4, 441928, '蚕豆', '新鲜的蚕豆', '以下为详细描述', 'https://i.loli.net/2020/04/17/86zfQpvt5eCi1AN.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (2, 3, 441928,  '枸杞头', '新鲜的枸杞头', '以下为详细描述', 'https://i.loli.net/2020/04/17/H1TqgRupGv9Mi3s.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 3, 441928,  '牛肉', '新鲜的牛肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/aSXPjcqyQBeIJLw.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 5, 441928,  '五花肉', '新鲜的五花肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/Mfse3lEL1J6V9d5.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
INSERT INTO FRESH(TYPE_ID, SHOP_ID, AREA_ID, NAME, DESCRIPTION, DETAIL, PICTURE, PRICE, STOCK, STATUS, CREATED_AT, UPDATED_AT)
VALUES (3, 5, 441928,  '鸡肉', '新鲜的鸡肉', '以下为详细描述', 'https://i.loli.net/2020/04/17/ngx9eEXbQu2Gdvs.png', 3, 100, 'online',
        '2020-04-17 02:23:50',
        '2020-04-17 02:23:50');
