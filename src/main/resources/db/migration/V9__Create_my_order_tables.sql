create table MY_ORDER
(
    ID          int auto_increment,
    USER_ID     int                        not null,
    SHOP_ID     int                        not null,
    TOTAL_MONEY int                        not null,
    ADDRESS_ID  int                        not null,
    STATUS      VARCHAR(10) default '待配送' not null
        comment ' 待配送 | 配送中 | 已完成 | 退款中 | 已退款',
    CREATED_AT  TIMESTAMP   default NOW()  not null,
    UPDATED_AT  TIMESTAMP   default NOW()  not null,
    constraint ORDER_pk
        primary key (ID),
    constraint ORDER_USER_ID_fk
        foreign key (USER_ID) references USER (ID),
    constraint ORDER_SHOP_ID_fk
        foreign key (SHOP_ID) references SHOP (ID),
    constraint ORDER_ADDRESS_ID_fk
        foreign key (ADDRESS_ID) references ADDRESS (ID)
)
    comment '订单表';

INSERT INTO MY_ORDER(ID, USER_ID, SHOP_ID, TOTAL_MONEY, ADDRESS_ID, STATUS, CREATED_AT, UPDATED_AT)
VALUES (202000001, 1, 1, 2000, 1, '已完成', '2020-04-17 22:43:50', '2020-04-17 22:43:50');

INSERT INTO MY_ORDER(USER_ID, SHOP_ID, TOTAL_MONEY, ADDRESS_ID, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 2000, 2, '配送中', '2020-04-17 22:43:50', '2020-04-17 22:43:50');

INSERT INTO MY_ORDER(USER_ID, SHOP_ID, TOTAL_MONEY, ADDRESS_ID, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 2000, 1, '已退款', '2020-04-17 22:43:50', '2020-04-17 22:43:50');

INSERT INTO MY_ORDER(USER_ID, SHOP_ID, TOTAL_MONEY, ADDRESS_ID, STATUS, CREATED_AT, UPDATED_AT)
VALUES (1, 1, 6000, 1, '待配送', '2020-04-17 22:43:50', '2020-04-17 22:43:50');
