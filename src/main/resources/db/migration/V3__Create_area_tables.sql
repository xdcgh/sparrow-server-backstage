create table AREA
(
    ID int,
    NAME VARCHAR(30) not null,
    CITY_ID int not null comment '市级 id',
    constraint AREA_pk
        primary key (ID),
    constraint AREA_CITY_ID_fk
        foreign key (CITY_ID) references CITY (ID)
)
    comment '地区表';

INSERT INTO AREA(ID, NAME, CITY_ID) VALUES (441928, '寮步镇', 441900);
INSERT INTO AREA(ID, NAME, CITY_ID) VALUES (441933, '大朗镇', 441900);
INSERT INTO AREA(ID, NAME, CITY_ID) VALUES (441907, '莞城街道', 441900);

INSERT INTO AREA(ID, NAME, CITY_ID) VALUES (441302, '惠城区', 441300);
INSERT INTO AREA(ID, NAME, CITY_ID) VALUES (441303, '惠阳区', 441300);
