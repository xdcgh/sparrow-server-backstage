create table CITY
(
    ID int,
    NAME VARCHAR(30) not null,
    PROVINCE_ID int not null,
    constraint CITY_pk
        primary key (ID),
    constraint CITY_PROVINCE_ID_fk
        foreign key (PROVINCE_ID) references PROVINCE (ID)
)
    comment '市级表';

INSERT INTO CITY(ID, NAME, PROVINCE_ID) VALUES (440100, '广州', 440000);
INSERT INTO CITY(ID, NAME, PROVINCE_ID) VALUES (440300, '深圳', 440000);
INSERT INTO CITY(ID, NAME, PROVINCE_ID) VALUES (441300, '惠州', 440000);
INSERT INTO CITY(ID, NAME, PROVINCE_ID) VALUES (441900, '东莞', 440000);
