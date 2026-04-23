--1.1
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    birth_date DATE,
    enrollment_date TIMESTAMP DEFAULT NOW()
);
--1.2
create table course(
    id serial primary key,
    code varchar(20) unique not null,
    name varchar(50) not null,
    credits int check (credits between 1 and 6),
    instructor varchar(100)
);
--1.3
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE grades (
    id SERIAL PRIMARY KEY,
    student_id INTEGER NOT NULL,
    course_id INTEGER NOT NULL,
    grade NUMERIC(3, 2) CHECK (grade >= 0 AND grade <= 4),
    semester VARCHAR(20),
    grade_date DATE DEFAULT CURRENT_DATE,
    
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(id)
);
--1.4
CREATE TABLE instructors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(100),
    hire_date DATE
);

