create database hethongqlks;
use hethongqlks;

create table login(
tentk varchar (25),
matkhau varchar (25)
);

insert into login values('admin', '1234');

insert into login values('ql', '0000');

select * from login;

create table employee(
ten varchar(40),
tuoi varchar(10),
dchi varchar(40),
gtinh varchar(15),
vitri varchar(50),
luong varchar(20),
phone varchar(20)
);
select * from employee;
