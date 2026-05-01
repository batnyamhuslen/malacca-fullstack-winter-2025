DROP TABLE IF EXISTS order_items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS departments CASCADE;

CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    budget DECIMAL(12,2)
);
INSERT INTO departments (name, budget) VALUES
('Sales', 500000), ('Marketing', 300000), ('IT', 400000),
('Customer Support', 200000), ('HR', 150000);

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    department_id INTEGER REFERENCES departments(id),
    manager_id INTEGER REFERENCES employees(id),
    hire_date DATE,
    salary DECIMAL(10,2)
);
INSERT INTO employees (first_name, last_name, email, department_id, manager_id, hire_date, salary) VALUES
('John',    'CEO',     'john@company.com',    1, NULL, '2018-01-01', 150000),
('Alice',   'Manager', 'alice@company.com',   1, 1,    '2019-03-15', 85000),
('Bob',     'Senior',  'bob@company.com',     1, 2,    '2020-06-01', 65000),
('Charlie', 'Junior',  'charlie@company.com', 1, 2,    '2022-01-10', 45000),
('Diana',   'Manager', 'diana@company.com',   2, 1,    '2019-05-20', 80000),
('Eve',     'Senior',  'eve@company.com',     2, 5,    '2020-08-15', 60000),
('Frank',   'Manager', 'frank@company.com',   3, 1,    '2019-02-01', 90000),
('Grace',   'Senior',  'grace@company.com',   3, 7,    '2020-11-01', 75000),
('Henry',   'Junior',  'henry@company.com',   3, 7,    '2023-03-01', 55000),
('Ivy',     'Manager', 'ivy@company.com',     4, 1,    '2020-01-15', 70000);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    parent_id INTEGER REFERENCES categories(id)
);
INSERT INTO categories (name, parent_id) VALUES
('Electronics', NULL), ('Computers', 1), ('Phones', 1),
('Clothing', NULL), ('Men', 4), ('Women', 4),
('Books', NULL), ('Home & Garden', NULL);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category_id INTEGER REFERENCES categories(id),
    price DECIMAL(10,2) NOT NULL,
    cost  DECIMAL(10,2) NOT NULL,
    stock_quantity INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO products (name, category_id, price, cost, stock_quantity) VALUES
('MacBook Pro', 2, 2499.99, 1800.00, 50), ('Dell XPS', 2, 1799.99, 1200.00, 75),
('iPhone 15', 3, 999.99, 700.00, 200),    ('Samsung Galaxy', 3, 899.99, 600.00, 150),
('Men T-Shirt', 5, 29.99, 10.00, 500),    ('Women Dress', 6, 79.99, 30.00, 200),
('Java Programming', 7, 49.99, 15.00, 100),('Python Basics', 7, 39.99, 12.00, 120),
('Garden Tools', 8, 89.99, 40.00, 80),    ('Desk Lamp', 8, 34.99, 15.00, 150);

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50),
    country VARCHAR(50) DEFAULT 'Mongolia',
    vip BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO customers (name, email, city, vip, created_at) VALUES
('Bat', 'bat@email.com', 'Ulaanbaatar', TRUE, '2023-01-15'),
('Bold', 'bold@email.com', 'Ulaanbaatar', FALSE, '2023-02-20'),
('Sarnai', 'sarnai@email.com', 'Darkhan', TRUE, '2023-03-10'),
('Tuya', 'tuya@email.com', 'Erdenet', FALSE, '2023-04-05'),
('Dorj', 'dorj@email.com', 'Ulaanbaatar', FALSE, '2023-05-12'),
('Oyun', 'oyun@email.com', 'Choibalsan', TRUE, '2023-06-20'),
('Gantulga', 'gantulga@email.com', 'Ulaanbaatar', FALSE, '2023-07-01'),
('Narantuya', 'narantuya@email.com', 'Darkhan', FALSE, '2023-08-15');

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customers(id),
    employee_id INTEGER REFERENCES employees(id),
    order_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'pending',
    shipping_city VARCHAR(50)
);
INSERT INTO orders (customer_id, employee_id, order_date, status, shipping_city) VALUES
(1, 3, '2024-01-15', 'completed', 'Ulaanbaatar'),
(1, 3, '2024-02-20', 'completed', 'Ulaanbaatar'),
(2, 4, '2024-02-25', 'completed', 'Ulaanbaatar'),
(3, 3, '2024-03-01', 'shipped',   'Darkhan'),
(4, 4, '2024-03-05', 'pending',   'Erdenet'),
(1, 3, '2024-03-10', 'completed', 'Ulaanbaatar'),
(5, 4, '2024-03-15', 'completed', 'Ulaanbaatar'),
(6, 3, '2024-03-20', 'shipped',   'Choibalsan'),
(2, 4, '2024-03-25', 'pending',   'Ulaanbaatar'),
(7, 3, '2024-04-01', 'completed', 'Ulaanbaatar');

CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id   INTEGER REFERENCES orders(id),
    product_id INTEGER REFERENCES products(id),
    quantity   INTEGER NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL
);
INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
(1,1,1,2499.99),(1,3,1,999.99),(2,5,3,29.99),(2,7,1,49.99),
(3,4,1,899.99),(4,2,1,1799.99),(4,8,2,39.99),(5,6,2,79.99),
(5,9,1,89.99),(6,3,2,999.99),(7,5,5,29.99),(7,10,2,34.99),
(8,1,1,2499.99),(9,7,2,49.99),(10,4,1,899.99);

--бүтээгдэхүүн бүрийн нийт зарагдсан тоо
SELECT
    p.name          AS product_name,
    SUM(oi.quantity) AS total_sold
FROM products p
LEFT JOIN order_items oi ON p.id = oi.product_id
GROUP BY p.name
ORDER BY total_sold DESC;

--хамгийн их зарагдсан
WITH sales_data AS (
    SELECT
        p.id,
        p.name                                           AS product_name,
        c.name                                           AS category_name,
        p.cost,
        COALESCE(SUM(oi.quantity), 0)                    AS total_sold,
        COALESCE(SUM(oi.quantity * oi.unit_price), 0)    AS total_revenue,
        COALESCE(SUM(oi.quantity * p.cost), 0)            AS total_cost  
    FROM products p
    LEFT JOIN categories  c  ON p.category_id = c.id
    LEFT JOIN order_items oi ON p.id = oi.product_id
    GROUP BY p.id, p.name, c.name, p.cost
)
SELECT
    product_name,
    category_name,
    total_sold,
    total_revenue,
    total_revenue - total_cost                                        AS profit,
    CASE
        WHEN total_revenue = 0 THEN 0
        ELSE ROUND((total_revenue - total_cost) / total_revenue * 100, 2)   -- ашиг хувь
    END                                                               AS profit_margin_pct
FROM sales_data
WHERE total_sold > 0   -- зарагдаагүй бүтээгдэхүүнийг хасах
ORDER BY profit ASC;     -- ашгаар буурах эрэмбэ

--йлчлүүлэгч бүрийн захиалгын тоо, нийт зарцуулалт
SELECT
    c.name                                          AS customer_name,
    c.email,
    c.city,
    c.vip                                           AS is_vip,
    COUNT(DISTINCT o.id)                           AS order_count,    -- захиалгын тоо
    COALESCE(SUM(oi.quantity * oi.unit_price), 0)   AS total_spent,
    CASE
        WHEN COUNT(DISTINCT o.id) = 0 THEN 0
        ELSE ROUND(SUM(oi.quantity * oi.unit_price) / COUNT(DISTINCT o.id), 2)
    END                                             AS avg_order_value
FROM customers c
left JOIN orders      o  ON c.id = o.customer_id    -- захиалгагүй ч орох JOIN
left JOIN order_items oi ON o.id = oi.order_id
GROUP BY c.id, c.name, c.email, c.city, c.vip
ORDER BY total_spent desc;

--Sales хэлтсийн ажилтан бүрийн борлуулалт 
SELECT
    e.first_name || ' ' || e.last_name                          AS employee_name,
    d.name                                                       AS department,
    COALESCE(m.first_name || ' ' || m.last_name, 'No Manager')  AS manager_name,
    COUNT(o.id)                                                  AS orders_processed,
    COALESCE(SUM(oi.quantity * oi.unit_price), 0)                AS total_sales
FROM employees e
INNER JOIN departments d  ON e.department_id = d.id
LEFT  JOIN employees   m  ON e.manager_id = m.id
LEFT  JOIN orders      o  ON e.id = o.employee_id
LEFT  JOIN order_items oi ON o.id = oi.order_id
WHERE d.name = 'Sales'
GROUP BY e.id, e.first_name, e.last_name, d.name, m.first_name, m.last_name
ORDER BY total_sales DESC;
--sub-category
SELECT
    COALESCE(parent.name, c.name)  AS parent_category,
    CASE
        WHEN parent.name IS NULL THEN '-'
        ELSE c.name
    END                            AS sub_category,
    COUNT(DISTINCT p.id)           AS product_count,
    COALESCE(SUM(oi.quantity * oi.unit_price), 0) AS total_sales
FROM categories c
LEFT JOIN categories  parent ON c.parent_id = parent.id
LEFT JOIN products    p      ON p.category_id = c.id
LEFT JOIN order_items oi     ON p.id = oi.product_id
GROUP BY parent.name, c.name
ORDER BY parent_category, sub_category;
--бүтээгдэхүүн бүрийн борлуулалтыг тооцоол
WITH product_sales AS (
    SELECT
        p.id     AS product_id,
        p.name   AS product_name,
        c.id     AS category_id,
        c.name   AS category_name,
        COALESCE(SUM(oi.quantity), 0) AS total_sold
    FROM products p
    INNER JOIN categories  c  ON p.category_id = c.id
    LEFT  JOIN order_items oi ON p.id = oi.product_id
    GROUP BY p.id, p.name, c.id, c.name
)
SELECT * FROM product_sales ORDER BY category_name, total_sold DESC;
-- Correlated subquery ашиглан категори бүрийн MAX-ийг ол
WITH product_sales AS (
    SELECT
        p.id     AS product_id,
        p.name   AS product_name,
        c.id     AS category_id,
        c.name   AS category_name,
        COALESCE(SUM(oi.quantity), 0) AS total_sold
    FROM products p
    INNER JOIN categories  c  ON p.category_id = c.id
    LEFT  JOIN order_items oi ON p.id = oi.product_id
    GROUP BY p.id, p.name, c.id, c.name
)
SELECT
    ps.category_name,
    ps.product_name,
    ps.total_sold
FROM product_sales ps
WHERE ps.total_sold = (
    -- Correlated subquery: гадаад query-ийн ps-ийг ашиглана
    SELECT MAX(ps2.total_sold)
    FROM product_sales ps2
    WHERE ps2.category_id = ps.___   -- гадаад ps-ийн category_id
)
ORDER BY ps.category_name;

--2+ захиалга өгсөн үйлчлүүлэгчид, тэдний эхний/сүүлийн захиалгын огноо.
SELECT
    c.name                                         AS customer_name,
    c.email,
    COUNT(DISTINCT o.id)                           AS order_count,
    MIN(o.order_date)                              AS first_order_date,  -- хамгийн эрт
    MAX(o.order_date)                              AS last_order_date,   -- хамгийн сүүл
    SUM(oi.quantity * oi.unit_price)               AS total_spent,
    MAX(o.order_date) - MIN(o.order_date)          AS days_between_orders
FROM customers c
INNER JOIN orders      o  ON c.id = o.customer_id
INNER JOIN order_items oi ON o.id = oi.order_id
GROUP BY c.id, c.name, c.email
HAVING COUNT(DISTINCT o.id) >= 2   -- 2 ба түүнээс дээш захиалга
ORDER BY total_spent DESC;
-- Эхлээд сар бүрийн нийт орлогыг тооцоол:
SELECT
    TO_CHAR(o.order_date, 'YYYY-MM')         AS month,
    COUNT(DISTINCT o.id)                      AS order_count,
    SUM(oi.quantity * oi.unit_price)          AS total_revenue
FROM orders o
INNER JOIN order_items oi ON o.id = oi.order_id
GROUP BY TO_CHAR(o.order_date, 'YYYY-MM')
ORDER BY month;
--AG() ашиглан өмнөх сарын орлогыг авах:
with_growth AS (
    SELECT
        month,
        order_count,
        total_revenue,
        avg_order_value,
        LAG(total_revenue) OVER (ORDER BY month) AS prev_month_revenue
    FROM monthly_sales
)
SELECT
    month,
    order_count,
    total_revenue,
    avg_order_value,
    COALESCE(prev_month_revenue, 0) AS prev_month_revenue,
    CASE
        WHEN prev_month_revenue IS NULL OR prev_month_revenue = 0 THEN NULL
        ELSE ROUND((total_revenue - prev_month_revenue) / prev_month_revenue * 100, 2)
    END AS growth_pct
FROM with_growth
ORDER BY month;
