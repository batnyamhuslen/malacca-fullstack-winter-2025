-- Create new database

create database db_intro;

-- create table and data types

create table employee(
    id INTEGER,
    name VARCHAR(150),
    department VARCHAR(10),
    salary INTEGER
);

create table student(
    id INT,
    name VARCHAR(100),
    surname VARCHAR(100),
    major VARCHAR(255)
);

--employee table data oruulah
--insert into
insert into employee (id,name,department,salary)
values
(1,'1','IT',75000),
(2,'bob','HR',55000),
(3,'charlie','IT',80000);

insert into student(id,name,surname,major)
values
(1,'huslen','b','it'),
(2,'ochiro','o','it');

select * from employee;--all data
select * from employee limit 1; --only first one row
select id,name from employee;--id,name column
select id as employee_nr, name as emloyee_name from employee; --select with column alias name
select * from employee where department = 'HR';--hr harah
select id,name,salary from employee where salary > 70000;--70000 ih harahs
--exercise
select distinct department from employee;
select count(distinct department) from employee;
select name,salary,salary*12 as annual_salary from employee;
select name, salary,salary*0.10 as tax,salary - (salary*0.10) as after_tax
from employee;