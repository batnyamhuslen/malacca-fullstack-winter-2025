SELECT rating, COUNT(*) AS total_films, ROUND(AVG(rental_rate), 2) AS avg_rate
FROM film
GROUP BY rating
ORDER BY total_films DESC;

SELECT rating, COUNT(*) AS total, AVG(rental_rate) AS avg_rate
FROM film
GROUP BY rating
ORDER BY total DESC;

SELECT title, length, rating
FROM film
ORDER BY length DESC
LIMIT 10;

SELECT title, rental_rate, rating
FROM film
WHERE rental_rate = 0.99
  AND rating IN ('G', 'PG')
ORDER BY title;

SELECT first_name, last_name, email
FROM customer
WHERE last_name LIKE 'S%'
ORDER BY first_name,last_name ;

SELECT 
    a.first_name || ' ' || a.last_name AS actor_name,
    COUNT(fa.film_id) AS film_count
FROM actor a
INNER JOIN film_actor fa 
    ON a.actor_id = fa.actor_id
GROUP BY a.actor_id, a.first_name, a.last_name
ORDER BY film_count DESC
LIMIT 5;

SELECT
    c.first_name || ' ' || c.last_name AS customer_name,
    count(p.amount) AS total_paid
FROM customer c
inner JOIN payment p ON c.customer_id = c.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
ORDER BY total_paid desc 
LIMIT 10;

--exer 3.1
SELECT c.customer_id, c.first_name, c.last_name
FROM customer c
LEFT JOIN rental r
  ON c.customer_id = r.customer_id
WHERE r.rental_id IS NULL;

--exer 3.2
SELECT f.film_id, f.title
FROM film f
LEFT JOIN inventory i
ON f.film_id = i.film_id
WHERE i.inventory_id IS NULL;

--exer 3.3
SELECT i.inventory_id, i.film_id
FROM inventory i
LEFT JOIN rental r
    ON i.inventory_id = r.inventory_id
WHERE r.inventory_id IS NULL;

SELECT DISTINCT f.title
FROM film f
JOIN inventory i
    ON f.film_id = i.film_id
LEFT JOIN rental r
    ON i.inventory_id = r.inventory_id
WHERE i.store_id = 2
  AND r.inventory_id IS NULL;

--exer 4.1
SELECT
    c.first_name || ' ' || c.last_name AS customer_name,
    f.title AS film_title,
    r.rental_date
FROM customer c
JOIN rental r
    ON c.customer_id = r.customer_id
JOIN inventory i
    ON r.inventory_id = i.inventory_id
JOIN film f
    ON i.film_id = f.film_id
ORDER BY c.first_name, r.rental_date;

--exer 4.2

SELECT
    f.title,
    f.rental_rate,
    f.length
FROM film f
JOIN film_category fc
    ON f.film_id = fc.film_id
JOIN category c
    ON fc.category_id = c.category_id
WHERE c.name = 'Action'
ORDER BY f.rental_rate DESC;


SELECT
    c.name AS category_name,
    COUNT(r.rental_id) AS total_rentals
FROM category c
JOIN film_category fc
    ON c.category_id = fc.category_id
JOIN film f
    ON fc.film_id = f.film_id
JOIN inventory i
    ON f.film_id = i.film_id
JOIN rental r
    ON i.inventory_id = r.inventory_id
GROUP BY c.name
ORDER BY total_rentals DESC;


SELECT
    f.title AS film_title,
    c.name AS category_name,
    r.rental_date
FROM customer cu
JOIN rental r
    ON cu.customer_id = r.customer_id
JOIN inventory i
    ON r.inventory_id = i.inventory_id
JOIN film f
    ON i.film_id = f.film_id
JOIN film_category fc
    ON f.film_id = fc.film_id
JOIN category c
    ON fc.category_id = c.category_id
WHERE cu.first_name = 'MARY'
  AND cu.last_name = 'SMITH'
ORDER BY r.rental_date;