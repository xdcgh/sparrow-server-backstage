create table ADDRESS
(
    ID         int auto_increment,
    USER_ID    int                        not null,
    AREA_ID    int                        not null,
    PHONE      VARCHAR(11)                not null,
    DETAIL     VARCHAR(200)               not null,
    NAME       VARCHAR(50)                not null,
    IS_DEFAULT VARCHAR(3)  default 'yes'  not null comment 'yes | no',
    constraint ADDRESS_pk
        primary key (ID),
    constraint ADDRESS_AREA_ID_fk
        foreign key (AREA_ID) references AREA (ID),
    constraint ADDRESS_USER_ID_fk
        foreign key (USER_ID) references USER (ID)
)
    comment '收获地址表';


INSERT INTO ADDRESS(USER_ID, AREA_ID, PHONE, DETAIL, NAME, IS_DEFAULT)
VALUES (1, 441928, '15622958503', '东莞理工学院城市学院北门', '许达成', 'yes');

INSERT INTO ADDRESS(USER_ID, AREA_ID, PHONE, DETAIL, NAME, IS_DEFAULT)
VALUES (1, 441928, '10086', '东莞理工学院城市学院正门', '冯诺依曼', 'no');

INSERT INTO ADDRESS(USER_ID, AREA_ID, PHONE, DETAIL, NAME, IS_DEFAULT)
VALUES (1, 441928, '10010', '东莞理工学院城市学院中门', '图灵', 'no');

