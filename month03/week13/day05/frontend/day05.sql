create table animal(
   id int,
   animal_name varchar(255),
   race varchar(255)
  );

insert into animal (id,animal_name,race)
values (1,'horse','mammalia'),
(1,'whale', 'mammalia');

select * from animal;

create table students (
    id int primary key,
    first_name varchar(255)
);

insert into students (id,first_name)
values(1,'khangaikhu'),
(2,'ochiroo');

select * from students;
select * from students where id=2;

create table teachers (
    id SERIAL primary key,
    first_name varchar(255)
);

insert into teachers (first_name)
values('khangaikhuu'),
('khuslen');

select * from  teachers;

select * from actor;
select * from actor where last_name ='Temple';
select * from actor where actor_id =190;
select * from actor order by actor.first_name desc;--usuhuur
select * from actor order by actor.first_name asc;--buurahaar
select distinct last_name from actor where last_name ='Temple';--temple gesen gantsiig n haruulah

select count(*) from actor;--actor too
select count(*) from city;--hotiin too
select count(*) from country;--ulsii too
select * from payment;

select max(amount) from payment;--hamgiin ig payment
select min(amount) from payment;--baga
select avg(amount) from payment;--dundaj

select sum(amount) from payment;--niit dundaj

SELECT * FROM employees WHERE department = 'IT';
SELECT * FROM employees WHERE department != 'HR';
SELECT * FROM employees WHERE salary > 60000;
SELECT * FROM employees WHERE salary <= 55000;
--exercises
SELECT * FROM employees WHERE department = 'IT';
SELECT * FROM employees WHERE salary > 70000;
SELECT * FROM employees WHERE department != 'HR';

SELECT * FROM employees
where department = 'IT' and salary > 70000;
SELECT * FROM employees
WHERE department = 'IT' or department = 'HR';
SELECT * FROM employees
WHERE (department = 'IT' OR department = 'HR')
  AND salary > 60000;

SELECT * FROM employees WHERE name like'B%';
SELECT * FROM employees
WHERE department  ('IT', 'HR', 'Finance');
SELECT * FROM employees
WHERE salary between 60000 and 75000;

SELECT * FROM employees ORDER BY salary asc;
SELECT * FROM employees ORDER BY salary desc limit 5;
SELECT * FROM employees LIMIT 5 offset 5;

SELECT count(*) FROM employees;
SELECT count(salary) FROM employees;
SELECT round(AVG(salary), 2) AS avg_salary FROM employees;
SELECT
    count(*) AS it_count,
    count(salary) AS it_total,
    ROUND(avg(salary), 2) AS it_avg
FROM employees
WHERE department = 'IT';
