SELECT
    c.name AS category,
    COUNT(DISTINCT f.film_id) AS film_count,
    ROUND(AVG(f.rental_rate), 2) AS avg_rate,
    MIN(f.rental_rate) AS min_rate,
    MAX(f.rental_rate) AS max_rate
FROM category c
INNER JOIN film_category fc ON c.category_id = fc.category_id
INNER JOIN film f ON fc.film_id = f.film_id
GROUP BY c.name
ORDER BY avg_rate DESC
LIMIT 4;

select 
    f.title,
    f.rating,
    f.rental_rate,
    count(r.rental_id) as rental_count
from film f
join inventory i 
    on f.film_id = i.film_id 
join rental r 
    on i.inventory_id = r.inventory_id 
group by
    f.film_id, f.title , f.rating, f.rental_rate
order by 
    rental_count desc
limit 5;

-- Зорилго: Store бүрийн нийт орлого харуул
SELECT
    s.store_id,
    SUM(p.amount) AS total_revenue
FROM store s
LEFT JOIN staff st 
    ON s.store_id = st.store_id
LEFT JOIN payment p 
    ON p.staff_id = st.staff_id   -- зөв холбоос
GROUP BY s.store_id
ORDER BY total_revenue DESC;


--2.1
select 
    f.rating,
    count(*) as film_count,
    round(avg(f.rental_rate),2) as avg_rate,
    round(
        avg(f.rental_rate)- (
        select avg (rental_rate)
        from film
        ),
        2
    )as diff_from_overall
from film f
group by f.rating
order by f.rating;

--2.2

SELECT
    f.title,
    f.rating,
    f.rental_duration,
    f.replacement_cost
FROM film f
WHERE f.rental_duration > (
    SELECT AVG(rental_duration)
    FROM film
    WHERE rating = 'G'
)
ORDER BY f.rental_duration DESC;

--2.3

SELECT 
    a.first_name,
    a.last_name,
    ROUND(AVG(f.rental_rate), 2) AS avg_rental_rate
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id, a.first_name, a.last_name
HAVING AVG(f.rental_rate) > (
    SELECT AVG(rental_rate)
    FROM film
)
ORDER BY avg_rental_rate DESC
LIMIT 5;

--3.1

SELECT f.title, f.rating, f.rental_rate
FROM film f
WHERE f.film_id IN (
    SELECT fc.film_id
    FROM film_category fc
    JOIN category c ON fc.category_id = c.category_id
    WHERE c.name IN ('Horror', 'Sci-Fi')
)
ORDER BY f.rating, f.rental_rate;    

--3.2
SELECT title, rating, rental_rate
FROM film
WHERE film_id NOT IN (
    SELECT film_id
    FROM inventory
    WHERE film_id IS NOT NULL
)
ORDER BY title;

--3.3

SELECT title, rating
FROM film
WHERE film_id NOT IN (
    SELECT i.film_id
    FROM rental r
    JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE r.rental_date >= '2005-07-01'
      AND r.rental_date <  '2005-08-01'
      AND i.film_id IS NOT NULL
)
ORDER BY title
LIMIT 10;

--4.1
SELECT f.title, f.rental_rate
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
  AND f.rental_rate > (
      SELECT AVG(f2.rental_rate)
      FROM film f2
      JOIN film_category fc2 ON f2.film_id = fc2.film_id
      JOIN category c2 ON fc2.category_id = c2.category_id
      WHERE c2.name = 'Action'
  )
ORDER BY f.rental_rate DESC;

--4.2
SELECT title, rating
FROM film
WHERE film_id IN (
    SELECT film_id
    FROM inventory
    WHERE store_id = 1
)
AND film_id IN (
    SELECT film_id
    FROM inventory
    WHERE store_id = 2
)
ORDER BY title
LIMIT 10;
