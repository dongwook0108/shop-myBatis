DROP TABLE IF EXISTS MEMBER;
CREATE TABLE MEMBER
(
    member_id     integer auto_increment,
    username      varchar(255) not null UNIQUE,
    phoneNumber   varchar(255) not null UNIQUE,
    email         varchar(255) not null UNIQUE,
    zipcode       varchar(255) not null,
    password      varchar(255) not null,
    address       varchar(255) not null,
    addressDetail varchar(255) not null,
    primary key (member_id)
);

-- INSERT INTO MEMBER(username, phoneNumber, email, zipcode, password, address, addressDetail)
-- VALUES ('dong125', '0101234124', 'test@naver.com', '1234', '123qwe', 'blackSt', '12443');

-- INSERT INTO MEMBER(username, phoneNumber, email, zipcode, password, address, addressDetail)
-- VALUES ('dong127', '0104444124', 'test12@naver.com', '1234', '123qwe', 'blackSt', '12443');


