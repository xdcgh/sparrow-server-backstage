create table USER
(
    ID         int auto_increment,
    OPENID     VARCHAR(50)                                                 not null UNIQUE,
    NICK_NAME  VARCHAR(50)   default '游客'                                  not null,
    ACCOUNT    int           default 10000                                 not null comment '单位是分',
    AVATAR     VARCHAR(1024) default 'https://sm.ms/image/xsmzRpNB8VAgw3t' null,
    CREATED_AT TIMESTAMP     default NOW()                                 not null,
    UPDATED_AT TIMESTAMP     default NOW()                                 not null,
    constraint USER_pk
        primary key (ID)
)
    comment '用户表';

INSERT INTO USER(OPENID, NICK_NAME, ACCOUNT, AVATAR, CREATED_AT, UPDATED_AT)
VALUES ('oSOj25TRwnWj41HWjOPibHSwewug', '许达成', 233333,
        'https://wx.qlogo.cn/mmopen/vi_32/AfWk3JK3gsJX1WCBGmEt135XLibmpSC8hhVFOiaiad9aeLhlUyyDNibyIqCKalEQZ9PH70CtpwrYZAMLux4BrobqJA/132',
        '2020-04-17 22:23:50',
        '2020-04-17 22:23:50');
