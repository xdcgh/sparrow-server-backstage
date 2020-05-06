create table PROVINCE
(
	ID int,
	NAME VARCHAR(30) not null,
	constraint PROVINCE_pk
		primary key (ID)
)
    comment '省级表';

INSERT INTO PROVINCE(ID, NAME) VALUES (440000,'广东');
