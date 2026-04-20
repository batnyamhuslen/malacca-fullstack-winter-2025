-- departments table
CREATE TABLE departments (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    location VARCHAR(100)
);

INSERT INTO departments VALUES
(1, 'IT', 'Building A'),
(2, 'HR', 'Building B'),
(3, 'Finance', 'Building A'),
(4, 'Marketing', 'Building C'),
(5, 'Research', 'Building D');

-- employees table
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department_id INT,
    salary DECIMAL(10,2),
    hire_date DATE
);

INSERT INTO employees VALUES
(1, 'Alice Smith', 1, 75000, '2020-01-15'),
(2, 'Bob Johnson', 2, 55000, '2019-03-20'),
(3, 'Charlie Brown', 1, 80000, '2018-07-10'),
(4, 'Diana Wilson', 3, 65000, '2021-02-01'),
(5, 'Eve Davis', 1, 70000, '2020-06-15'),
(6, 'Frank Miller', 2, 50000, '2022-01-10'),
(7, 'Grace Lee', 3, 72000, '2019-11-20'),
(8, 'Henry Taylor', NULL, 85000, '2017-04-05'); -- department_id null

select * from departments;
select * from departments where location ='Building A'  ;
select * from employees;
select * from employees where department_id = 1 or department_id = 3;
select * from employees where department_id is null ;

create table messy_sales (
   order_id SERIAL primary key,
   customer_name text,
   customer_email text,
   product_name text,
   product_price decimal,
   order_date date
);

insert into messy_sales (customer_name, customer_email, product_name, product_price, order_date)
values
('khuslen', 'khuslen@gmail.com', 'laptop', 1200.00, '2026-04-20'),
('khuslen', 'khuslen@gmail.com', 'mouse', 25.00, '2026-04-20'),
('khuslen', 'khuslen@gmail.com', 'keyboard', 75.00, '2026-04-20');

select * from messy_sales;

create table customers (
    customer_id serial primary key,
    customer_name text not null,
    customer_email text unique not null
);

create table products (
    product_id serial primary key,
    product_name text not null,
    price decimal not null
);

CREATE TABLE orders (
    order_id serial PRIMARY KEY,
    customer_id int,
    product_id int,
    order_date date DEFAULT current_date,

    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id) REFERENCES customers(customer_id),

    CONSTRAINT fk_products
        FOREIGN KEY (product_id) REFERENCES products(product_id)
);

select *from  products p;
select *from  orders;

insert into customers (customer_name,customer_email)
values ('khuslen','khuslen@gmail.com');

insert into products (product_name,price)
values 
('laptop', 1200.00),
('mouse', 25.00),
('keyboard', 75.00);


INSERT INTO orders (customer_id, product_id, order_date)
VALUES
(1, 1, '2026-04-20'),
(1, 2, '2026-04-20'),
(1, 3, '2026-04-20');

select * from country;
select * from city;
select * from country c where country = 'Afghanistan';
select * from city where country_id = 1;

--join
select * from city 
join country 
on city.country_id = country.country_id ;


select city.city_id , city.city, country.country 
from city 
join country 
on city.country_id = country.country_id ;

select city.city_id , city.city, country.country 
from city 
join country 
on city.country_id = country.country_id where country.country = 'United States';

--exer1 
select * from film f ;
select * from "language" l ;

SELECT f.title, l.name
FROM film f
JOIN language l
  ON f.language_id = l.language_id;

--exer2
select f.title,a.first_name || ' ' || a.last_name as "full name"
from film f
join film_actor fa
on f.film_id = fa.film_id 
join actor a
on fa.actor_id = a.actor_id 
where f.title = 'Academy Dinosaur';

--exer3
select
	cu.last_name || ' ' || cu.first_name as customer_name,
	a.address,
	c.city
from
	customer cu
join address a
    on
	cu.address_id = a.address_id
join city c
    on
	c.city_id = a.city_id;

--left join
select 
    e.name as employee,
    d.name as department
from employees e 
left join departments d on e.department_id = d.id;

--righ join
select 
    e.name as employee,
    d.name as department
from employees e
right join employees d on e.department_id = d.id;

--inner join
select 
    e.name as employee_name,
    d.name as department_name
from employees e
inner join employees d on e.department_id = d.id;

--group by clause
select d."name", count (e.id) as "number of employee"  from  departments d 
left join employees e 
on e.department_id = d.id
group by d."name" 
order by count (e.id);

--exercise 1-5
SELECT e.name, d.name AS department
FROM employees e
inner join departments d on e.department_id = d.id;

SELECT e.name, d.name AS department
FROM employees e
left join departments d ON e.department_id = d.id;

SELECT e.name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.id
WHERE d.id is null;

SELECT d.name
FROM employees e
right JOIN departments d ON e.department_id = d.id
WHERE e.id IS NULL;

SELECT e.name AS employee,e.name AS department
FROM employees e
INNER JOIN departments d ON e.department_id = d.id;
