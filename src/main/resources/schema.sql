-- DROP TABLE IF EXISTS MEMBER;
-- CREATE TABLE MEMBER
-- (
--     member_id     integer auto_increment,
--     username      varchar(255) not null UNIQUE,
--     phoneNumber   varchar(255) not null UNIQUE,
--     email         varchar(255) not null UNIQUE,
--     zipcode       varchar(255) not null,
--     password      varchar(255) not null,
--     address       varchar(255) not null,
--     addressDetail varchar(255) not null,
--     primary key (member_id)
-- );
DROP TABLE IF EXISTS MEMBER;
CREATE TABLE MEMBER
(
    `member_id`      bigint       NOT NULL AUTO_INCREMENT,
    `username`       varchar(45)  NOT NULL,
    `phone_number`   varchar(45)  NOT NULL UNIQUE,
    `email`          varchar(45)  NOT NULL UNIQUE,
    `zipcode`        varchar(45)  NOT NULL,
    `password`       varchar(255) NOT NULL,
    `address`        varchar(45)  NOT NULL,
    `address_detail` varchar(45)  NOT NULL,
    `role`           varchar(45) DEFAULT NULL,
    `updated_date`   datetime    DEFAULT NULL,
    `created_date`   datetime    DEFAULT NULL,
    `updated_by`     varchar(45) DEFAULT NULL,
    `active`         tinyint      NOT NULL,
    PRIMARY KEY (`member_id`)
);

DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY
(
    `category_id`   bigint       NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) NULL,
    `category_code` varchar(255) NULL,
    `parent_id`     bigint       NULL,
    PRIMARY KEY (`category_id`)
);

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT
(
    `product_id`         bigint         NOT NULL AUTO_INCREMENT,
    `name`               varchar(45)    NOT NULL,
    `description`        varchar(255)   NOT NULL,
    `simple_description` varchar(45)    NOT NULL,
    `price`              decimal(10, 0) NOT NULL,
    `updated_date`       datetime    DEFAULT NULL,
    `created_date`       datetime    DEFAULT NULL,
    `updated_by`         varchar(45) DEFAULT NULL,
    `created_by`         varchar(45) DEFAULT NULL,
    `original_file_name` varchar(255),
    `featured`           tinyint        NOT NULL,
    `category_id`        bigint         NOT NULL,
    PRIMARY KEY (`product_id`),
    CONSTRAINT FK_CATEGORY_ID
        FOREIGN KEY (`category_id`)
            REFERENCES CATEGORY (`category_id`)
);



DROP TABLE IF EXISTS UPLOADFILE;
CREATE TABLE UPLOADFILE
(
    `upload_id`          bigint       NOT NULL AUTO_INCREMENT,
    `image_path`         varchar(255) NOT NULL,
    `original_file_name` varchar(255) NOT NULL,
    PRIMARY KEY (`upload_id`)
);



