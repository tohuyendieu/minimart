create database L0002
GO
use L0002
--drop database L0002

CREATE TABLE [User](
   username varchar(50),
   pass varchar(50),
   id int primary key identity(1,1),
   name varchar(50),
   phone varchar(10),
   mail varchar(30),
   type varchar(20)
)

CREATE TABLE Category(
   name varchar(225) primary key,
   note varchar(225)
)

CREATE TABLE Product(
	id int primary key identity(1,1),
	category varchar(225) references Category(name),
	name varchar(225),
	unitPrice money check(unitPrice>=0),
	discount float check(discount>=0),
	origin varchar(225),
	sellPrice money check(sellPrice>=0)
)

CREATE TABLE Bill(
	id int primary key identity(1,1),
	[date]  varchar(30),
	seller int references [User](id),
	total money
)

CREATE TABLE BillDetail(
	bid int references Bill(id),
	pid int references Product(id),
	primary key(bid, pid),
	quantity int check(quantity>=0),
	sellPrice money check(sellPrice>=0)
)
--SELECT*FROM BillDetail
--INSERT INTO BillDetail (bid, pid, quantity, sellPrice)
--VALUES(3,1,5,13)

CREATE TABLE StockInOutDetail(
	[date] varchar(30),
	pid int references Product(id),
	primary key([date], pid),
	amountIn int check(amountIn>=0),
	amountOut int check(amountOut>=0),
	StockQuantity int check(StockQuantity>=0)
)

CREATE TABLE [Language](
	lang varchar(10) primary key
)
----------------------------------------------------------------

INSERT INTO [user] (username, pass, [name], phone, mail, [type])
VALUES
('Admin','admin','admin','0123456789','admin@market.com.vn','admin'),
('TrangNTSeller','123456','Nguyen Thu Trang','0987654321','trang@gmail.com.vn','seller'),
('HoangTTSeller','1q2w3e4r','Tran The Hoang','0979554334','hoang123@gmail.com','seller'),
('staff','staff','staff','0989786756','staff@gmail.com','Inventory staff'),
('Seller34','1234567','Hoang Minh Trang','0911223344','hoangtrang@12gmail.com','seller')

SELECT*FROM [User] WHERE username = 'admin' and pass = 'admin'

UPDATE [User]
SET username = '',
    pass = '',
	[name] = '',
	phone = '',
	mail = '',
	[type] = ''
WHERE id = 10


Insert into [Language]
values('VN')

SELECT*FROM [Language]

UPDATE [Language]
set lang = 'VN'
WHere lang = 'EN'

insert into Category
values
	('fat food','')	,
	('rice',''),
	('fruit',''),
	('toy','')

insert into Product (category, [name], unitPrice, discount, origin, sellPrice)
values
	('fruit','banana',12,0,'vietnam',13),
	('rice','brown rice',45,0,'korea',60),
	('toy','baby doll',60,0.5,'america',65)
    
SELECT*FROM Category
WHERE [name]='fat food'
select*from Product where id = 1

select*from [User]

select*from bill

delete StockInOutDetail
where [date] = '2020-10-14'
select*from StockInOutDetail
--DISTINCT 
select*from bill
select*from BillDetail

select top 5 pid, totalOut = sum(amountOut) 
from StockInOutDetail 
group by StockInOutDetail.pid
order by totalOut desc

SELECT TOP 5 id, date, seller, total
FROM Bill
ORDER BY total desc

Select * from [User] where id = 1

SELECT*FROM Product
SELECT*FROM StockInOutDetail