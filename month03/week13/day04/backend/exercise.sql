CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DECIMAL(10,2),
    hire_date DATE,
    email VARCHAR(100)
);

INSERT INTO employees VALUES
(1, 'Alice Smith', 'IT', 75000, '2020-01-15', 'alice@company.com'),
(2, 'Bob Johnson', 'HR', 55000, '2019-03-20', 'bob@company.com'),
(3, 'Charlie Brown', 'IT', 80000, '2018-07-10', 'charlie@company.com'),
(4, 'Diana Wilson', 'Finance', 65000, '2021-02-01', 'diana@company.com'),
(5, 'Eve Davis', 'IT', 70000, '2020-06-15', 'eve@company.com'),
(6, 'Frank Miller', 'HR', 50000, '2022-01-10', 'frank@company.com'),
(7, 'Grace Lee', 'Finance', 72000, '2019-11-20', 'grace@company.com'),
(8, 'Henry Taylor', 'IT', 85000, '2017-04-05', 'henry@company.com');

CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2),
    stock INT
);

INSERT INTO products VALUES
(1, 'Laptop', 'Electronics', 1299.99, 50),
(2, 'Mouse', 'Electronics', 29.99, 200),
(3, 'Keyboard', 'Electronics', 79.99, 150),
(4, 'Desk Chair', 'Furniture', 299.99, 30),
(5, 'Monitor', 'Electronics', 399.99, 75),
(6, 'Desk', 'Furniture', 499.99, 20),
(7, 'Headphones', 'Electronics', 149.99, 100),
(8, 'Webcam', 'Electronics', 89.99, 80);
--exer1
select * from employees;
select * from products;
select name,department from employees;
select name,price,stock from products;
--exer2
select name,salary,email from employees;
select name,category,price from products;
select name,department,hire_date from employees;
--exer3
select name,salary,salary*12 as from employees;
select name,price,price*0.9 as discounted_price from products;
select name,stock, price*stock as total_value from products;
select name,salary-(salary*0.15) as after_tax from employees;
--exer4
select distinct department
from employees;
select distinct category
from products;
select count(distinct department) as department_count
from employees;
select count(distinct category) as category_count
from products;
--exer5
select distinct department from employees;
select count(distinct category) from products;
select name as "Full Name" from employees;
