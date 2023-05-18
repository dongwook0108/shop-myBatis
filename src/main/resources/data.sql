INSERT INTO MEMBER (username, phone_number, email, zipcode, password, address, address_detail, role,
                    updated_date, created_date, updated_by, created_by, active)
VALUES ('동욱', '01012341234', 'test12@dongwook.com', '12345',
        '{bcrypt}$2a$10$gDsJ9wNtNWDR9d2UxJIvsufC7vTmRc9hqituCgb2X3o8vpuaJ1J9W', '123 Main St',
        'Apt 4B',
        'ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin', 1),

       ('지훈', '01097976543', 'test1@dongwook.com', '12345',
        '{bcrypt}$2a$10$gDsJ9wNtNWDR9d2UxJIvsufC7vTmRc9hqituCgb2X3o8vpuaJ1J9W', '123 Main St',
        'Apt 4B',
        'ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin', 1),

       ('유증', '01034347778', 'test1@naver.com', '12345',
        '{bcrypt}$2a$10$gDsJ9wNtNWDR9d2UxJIvsufC7vTmRc9hqituCgb2X3o8vpuaJ1J9W', '123 Main St',
        'Apt 4B',
        'user', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin', 1),

       ('동현', '01044882231', 'test12@gmail.com', '12345',
        '{bcrypt}$2a$10$gDsJ9wNtNWDR9d2UxJIvsufC7vTmRc9hqituCgb2X3o8vpuaJ1J9W', '123 Main St',
        'Apt 4B',
        'user', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin', 1),

       ('정언', '1234567890', 'test123@hanmail.net', '12345',
        '{bcrypt}$2a$10$gDsJ9wNtNWDR9d2UxJIvsufC7vTmRc9hqituCgb2X3o8vpuaJ1J9W', '123 Main St',
        'Apt 4B',
        'user', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin', 1);

INSERT INTO PRODUCT(name, description, simple_description, price, image_path, original_file_name,
                    created_date, created_by)
VALUES ('bottle', 'Product Description', 'Product Simple Description', 10000,
        '/Users/dongwook/Desktop/IdeaProjects/shop-myBatis/src/main/resources/static/images/product/upload/',
        'bottle.jpeg', CURRENT_TIMESTAMP, 'admin'),

       ('shirts', 'Product Description', 'Product Simple Description', 20000,
        '/Users/dongwook/Desktop/IdeaProjects/shop-myBatis/src/main/resources/static/images/product/upload/',
        'shirts.jpeg', CURRENT_TIMESTAMP, 'admin'),

       ('book', 'Product Description', 'Product Simple Description', 30000,
        '/Users/dongwook/Desktop/IdeaProjects/shop-myBatis/src/main/resources/static/images/product/upload/',
        'book.jpeg', CURRENT_TIMESTAMP, 'admin');







