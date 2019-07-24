# ssm_springmvc
数据表：
-- Create table
create table ONE_USER
(
  id       NUMBER(3) not null,
  username VARCHAR2(30),
  password VARCHAR2(30),
  sex      VARCHAR2(5),
  role     VARCHAR2(30)
)

-- Create table
create table ONE_ROLE
(
  roleid   NUMBER(3) not null,
  rolename VARCHAR2(30)
)

-- Create table
create table ONE_USERROLE
(
  userid NUMBER(3),
  roleid NUMBER(3)
)