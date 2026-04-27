-- Дундаж rental_rate-аас их бүх кино
SELECT title, rental_rate
FROM film
WHERE rental_rate > (SELECT AVG(rental_rate) FROM film)
ORDER BY rental_rate DESC
LIMIT 8;

-- Дундаж rental_rate хэд вэ?
SELECT ROUND(AVG(rental_rate), 2) FROM film;

-- Дундажаас их кинонуудыг ол
SELECT title, rental_rate
FROM film
WHERE rental_rate > (SELECT AVG(rental_rate) FROM film)
ORDER BY rental_rate DESC
LIMIT 5;

-- Кино бүрийн rental_rate болон дундажтай харьцуулалт
SELECT
    title,
    rental_rate,
    ROUND((SELECT AVG(rental_rate) FROM film), 2) AS avg_rate,
    ROUND(rental_rate - (SELECT AVG(rental_rate) FROM film), 2) AS diff
FROM film
ORDER BY diff DESC
LIMIT 5;

-- Дундаж rental_rate-аас их rating-үүд
SELECT rating, ROUND(AVG(rental_rate), 2) AS avg_rate
FROM film
GROUP BY rating
HAVING AVG(rental_rate) > (SELECT AVG(rental_rate) FROM film)
ORDER BY avg_rate DESC;

-- Action ангиллын кинонууд
SELECT title, rental_rate
FROM film
WHERE film_id IN (
    SELECT film_id
    FROM film_category fc
    INNER JOIN category c ON fc.category_id = c.category_id
    WHERE c.name = 'Action'
)
ORDER BY rental_rate DESC
LIMIT 5;

-- Хэзээ ч inventory-д ороогүй кинонууд
SELECT title, rating
FROM film
WHERE film_id NOT IN (
    SELECT DISTINCT film_id
    FROM inventory
    WHERE film_id IS NOT NULL   
)
ORDER BY title
LIMIT 10;

-- БУРУУ (NULL байвал ямар ч мөр буцахгүй!):
WHERE film_id NOT IN (SELECT film_id FROM inventory)

-- ЗӨВ — IS NOT NULL нэм:
WHERE film_id NOT IN (
    SELECT film_id FROM inventory WHERE film_id IS NOT NULL
)
-- Эсвэл NOT EXISTS ашигла (аюулгүй):
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE film_id = film.film_id)


-- Дундаж rental_rate-аас их кино
SELECT title, rental_rate
FROM film
WHERE rental_rate >(SELECT avg(rental_rate) FROM film);
--SELECT clause дотор дундаж:
SELECT
    title,
    rental_rate,
    (SELECT ROUND(avg(rental_rate), 2) FROM film) AS avg_rate
FROM film;
-- IN subquery — Comedy кинонууд:
SELECT title FROM film
WHERE film_id in (
    SELECT fc.film_id FROM film_category fc
    INNER JOIN category c ON fc.category_id = c.category_id
    WHERE c.name = 'Comedy'
);
--NOT IN — inventory-д байхгүй кинонууд:
SELECT title FROM film
WHERE film_id NOT IN (
    SELECT film_id FROM inventory WHERE film_id IS NOT NULL
);

--Predict the Output:
SELECT rating, COUNT(*) AS film_count
FROM film
WHERE rental_rate > (SELECT AVG(rental_rate) FROM film)
GROUP BY rating
ORDER BY film_count DESC;

-- Зорилго: Хамгийн их орлого авсан үйлчлүүлэгчийн нэрийг ол
SELECT first_name, last_name
FROM customer
WHERE customer_id = (
    SELECT customer_id
    FROM payment
    GROUP BY customer_id
    ORDER BY SUM(amount) DESC
    LIMIT 1
);