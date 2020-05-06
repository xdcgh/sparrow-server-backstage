create table ORDER_FRESH
(
    ID       int auto_increment,
    ORDER_ID int not null,
    FRESH_ID int not null,
    amount   int not null comment '单位 个',
    PRICE    int not null comment '单位 分',
    constraint ORDER_FRESH_pk
        primary key (ID),
    constraint ORDER_FRESH_FRESH_ID_fk
        foreign key (FRESH_ID) references FRESH (ID),
    constraint ORDER_FRESH_MY_ORDER_ID_fk
        foreign key (ORDER_ID) references MY_ORDER (ID)
)
    comment '订单商品表';

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000001, 1, 1, 20);

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000001, 2, 1, 20);

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000001, 3, 1, 20);

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000002, 3, 1, 20);

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000003, 2, 1, 20);

insert into ORDER_FRESH(order_id, fresh_id, amount, price)
VALUES (202000004, 1, 1, 20);
