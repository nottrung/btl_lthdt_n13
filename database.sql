create database hethongqlks;
use hethongqlks;

create table login(
tentk varchar (25)  primary key,
matkhau varchar (25),
quyen varchar (10)
);

insert into login values('admin', '1234', 'admin');
insert into login values('lt', '0000', 'letan');
select * from login;

create table employee(
ten varchar(40),
tuoi varchar(10),
dchi varchar(40),
socccd varchar(20) primary key,
gtinh varchar(15),
vitri varchar(50),
luong varchar(20),
phone varchar(20)
);
select * from employee;


create table rooms(
sophong varchar(10) primary key,
trangthai varchar(30)
);

insert into rooms values(101,"trống");
insert into rooms values(102,"trống");
insert into rooms values(103,"trống");
insert into rooms values(104,"trống");
insert into rooms values(105,"trống");
insert into rooms values(201,"trống");
insert into rooms values(202,"trống");
insert into rooms values(203,"trống");
insert into rooms values(204,"trống");
insert into rooms values(205,"trống");
insert into rooms values(301,"trống");
insert into rooms values(302,"trống");
insert into rooms values(303,"trống");
insert into rooms values(304,"trống");
insert into rooms values(305,"trống");
insert into rooms values(401,"trống");
insert into rooms values(402,"trống");
insert into rooms values(403,"trống");
insert into rooms values(404,"trống");
insert into rooms values(405,"trống");
select * from rooms;

create table booking(
tenkh varchar(50), 
cccd varchar(20),
sophong varchar(10) primary key,
tgthue varchar(10),
foreign key (sophong) references rooms(sophong)
);
select * from booking;
