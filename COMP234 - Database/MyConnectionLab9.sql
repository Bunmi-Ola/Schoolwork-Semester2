CREATE TABLE Book
(BookCode	number(4) primary key,
ISBN	number(10),
Booktitle	varchar2(50),
Edition	varchar2(25),
PublisherCode	number(10),
FOREIGN KEY (PublisherCode) REFERENCES BookPublisher(PublisherCode))
TABLESPACE users;
drop table Book;

CREATE TABLE Seller
(BookSellerId	number(10) primary key,
BookSellerName	varchar2(50),
BookSellerPhoneNo	number(10))
TABLESPACE users;



CREATE TABLE BookPublisher
(PublisherCode	number(10) primary key,
PublisherName	varchar2(50),
PublisherAddress varchar2(50),
BookSellerPhoneNo	number(10))
TABLESPACE users;


CREATE TABLE BookPrice
(ReceiptNumber	number(5) primary key,
BookCode	number(4),
BookPrice	number(10),
FOREIGN KEY (BookCode) REFERENCES Book(BookCode))
TABLESPACE users;
drop table BookPrice;

CREATE TABLE Authors
(AuthorID	number(5) primary key,
AuthorName	varchar2(25),
AuthorAddress	varchar2(50))
TABLESPACE users;


CREATE TABLE BookAuthors
(BookCode	number(4),
AuthorID	number(5),
PRIMARY KEY(BookCode,AuthorID),
FOREIGN KEY (BookCode) REFERENCES Book(BookCode),
FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID))
TABLESPACE users;
drop table BookAuthors;

CREATE TABLE BookSellers
(BookCode	number(4),
BookSellerId	number(10),
PRIMARY KEY(BookCode,BookSellerId),
FOREIGN KEY (BookCode) REFERENCES Book(BookCode),
FOREIGN KEY (BookSellerId) REFERENCES Seller(BookSellerId))
TABLESPACE users;
drop table BookSellers;

INSERT INTO Seller
VALUES('1000',	'Ron McLarty',	'21221211');

INSERT INTO Seller
VALUES('1001',	'Peter Giles',	'332323232');

INSERT INTO Seller
VALUES('1002',	'Jan Maxwell',	'111222121');

INSERT INTO Seller
VALUES('1003',	'Dirk Cussler',	'232235485');

INSERT INTO Seller
VALUES('1004',	'Edward Herrmann',	'487815365');

INSERT INTO BookPublisher
VALUES('500',	'Egmont USA',	'106 North Street', '111111111');

INSERT INTO BookPublisher
VALUES('501',	'Bloomsbury Kids',	'1 Uplands Street', '22222222');

INSERT INTO BookPublisher
VALUES('502',	'Delacorte Press',	'23 Saskatchewan Drive', '3333333');

INSERT INTO Authors
VALUES('850',	'Mary Amato',	'2025 M Street, Northwest');

INSERT INTO Authors
VALUES('851',	'Ann Brashares',	'6 Ave NW #600');

INSERT INTO Authors
VALUES('852',	'Fanny Britt',	' 240 Saskatchewan Street East');

INSERT INTO Authors
VALUES('853',	'Erica Cameron',	'710-1A Main St N');

INSERT INTO Book
VALUES('10',	'11111',	'Good Crooks series', '1st Edition', '501');

INSERT INTO Book
VALUES('11',	'11111',	'Good Crooks series', '1st Edition', '501');

INSERT INTO Book
VALUES('12',	'11122',	'The Here and Now', '3rd Edition', '502');

INSERT INTO Book
VALUES('13',	'11133',	'The Testing', '3rd Edition', '500');

INSERT INTO Book
VALUES('14',	'11144',	'Breakfast Served', '2nd Edition', '502');

INSERT INTO Book
VALUES('15',	'11144',	'Breakfast Served', '2nd Edition', '502');

INSERT INTO Book
VALUES('16',	'11155',	'Deep Blue', '5th Edition', '500');

INSERT INTO BookAuthors
VALUES('10', '850');

INSERT INTO BookAuthors
VALUES('10',	'851');

INSERT INTO BookAuthors
VALUES('10',	'852');

INSERT INTO BookAuthors
VALUES('11',	'853');

INSERT INTO BookAuthors
VALUES('12',	'852');

INSERT INTO BookAuthors
VALUES('12',	'853');

INSERT INTO BookAuthors
VALUES('13',	'851');

INSERT INTO BookAuthors
VALUES('14',	'850');

INSERT INTO BookAuthors
VALUES('14',	'852');

INSERT INTO BookAuthors
VALUES('15',	'853');

INSERT INTO BookAuthors
VALUES('16',	'851');

INSERT INTO BookAuthors
VALUES('16',	'852');

INSERT INTO BookPrice
VALUES('901','10',	'17.99');

INSERT INTO BookPrice
VALUES('902', '11',	'20.00');

INSERT INTO BookPrice
VALUES(	'903','12', '9.95');

INSERT INTO BookPrice
VALUES('904','13',	'41.25');

INSERT INTO BookPrice
VALUES('905', '14',	'14.00');

INSERT INTO BookPrice
VALUES('906', '15',	'5.05');

INSERT INTO BookPrice
VALUES('907', '16',	 '8.00');

INSERT INTO BookSellers
VALUES('10', '1000');

INSERT INTO BookSellers
VALUES('10',	'1001');

INSERT INTO BookSellers
VALUES('10',	'1002');

INSERT INTO BookSellers
VALUES('11',	'1003');

INSERT INTO BookSellers
VALUES('12',	'1004');

INSERT INTO BookSellers
VALUES('12',	'1000');

INSERT INTO BookSellers
VALUES('13',	'1001');

INSERT INTO BookSellers
VALUES('14',	'1002');

INSERT INTO BookSellers
VALUES('14',	'1003');

INSERT INTO BookSellers
VALUES('15',	'1004');

INSERT INTO BookSellers
VALUES('16',	'1001');

INSERT INTO BookSellers
VALUES('16',	'1003');

SELECT * FROM BOOKAuthors;

SELECT * FROM BOOKTITLE;
select BOOKTITLE from BOOK where PUBLISHERCODE = any
(select PUBLISHERCODE from BOOKPUBLISHER where PUBLISHERNAME = 'Delacorte Press');



select BOOK.BOOKTITLE,  BOOKPUBLISHER.PUBLISHERNAME, BOOKAUTHORS.AUTHORID 
from BOOK 
INNER JOIN BOOKPUBLISHER ON BOOK.PUBLISHERCODE = BOOKPUBLISHER.PUBLISHERCODE
INNER JOIN BOOKAUTHORS ON BOOK.BOOKCODE= BOOKAUTHORS.BOOKCODE;


select BOOKTITLE from BOOK where BOOKCODE = any
(select BOOKCODE from BOOKAUTHORS where AUTHORID = any 
(select AUTHORID from AUTHORS where AUTHORNAME = 'Mary Amato') );