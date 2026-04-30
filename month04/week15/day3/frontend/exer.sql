-- Inventory-д байгаа кинонууд (EXISTS)
SELECT f.title
FROM film f
WHERE EXISTS (
    SELECT 1
    FROM inventory i
    WHERE i.film_id = f.film_id   -- ← f.film_id = гадна query-ийн утга
)
ORDER BY f.title
LIMIT 8;

-- Хэзээ ч inventory-д ороогүй кинонууд (NOT EXISTS)
SELECT f.title, f.rating
FROM film f
WHERE NOT EXISTS (
    SELECT 1
    FROM inventory i
    WHERE i.film_id = f.film_id
)
ORDER BY f.title
LIMIT 10;

--exer1
SELECT f.title
FROM film f
WHERE NOT EXISTS (
    SELECT 1
    FROM rental r
    INNER JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE i.film_id = f.film_id
)
ORDER BY f.title
LIMIT 5;

--exer2
SELECT COUNT(*) AS never_rented
FROM film f
WHERE NOT EXISTS (
    SELECT 1
    FROM inventory i
    INNER JOIN rental r ON i.inventory_id = r.inventory_id
    WHERE i.film_id = f.film_id
);
--exer3
SELECT f.rating, COUNT(*) AS above_avg_count
FROM film f
WHERE f.rental_duration > (
    SELECT AVG(f2.rental_duration)
    FROM film f2
    WHERE f2.rating = f.rating
)
GROUP BY f.rating
ORDER BY f.rating;

-- Ангилал тус бүрийн дундаж rental_rate, тэрнийхээ дундажаас дээшхийг авах
SELECT dept.*
FROM (
    SELECT
        c.name                             AS category,
        COUNT(DISTINCT f.film_id)          AS film_count,
        ROUND(AVG(f.rental_rate)::numeric, 2) AS avg_rate
    FROM category c
    INNER JOIN film_category fc ON c.category_id = fc.category_id
    INNER JOIN film f ON fc.film_id = f.film_id
    GROUP BY c.category_id, c.name
) AS dept                                  -- ← alias заавал!
WHERE dept.avg_rate > 2.98
ORDER BY dept.avg_rate DESC;

-- Ижил зорилго, уншихад хялбар хэлбэр
WITH category_stats AS (
    SELECT
        c.name                                AS category,
        COUNT(DISTINCT f.film_id)             AS film_count,
        ROUND(AVG(f.rental_rate)::numeric, 2) AS avg_rate
    FROM category c
    INNER JOIN film_category fc ON c.category_id = fc.category_id
    INNER JOIN film f ON fc.film_id = f.film_id
    GROUP BY c.category_id, c.name
)
SELECT *
FROM category_stats
WHERE avg_rate > 2.98
ORDER BY avg_rate DESC;


____ customer_rentals AS (
    SELECT
        c.customer_id,
        c.first_name || ' ' || c.last_name AS full_name,
        COUNT(r.rental_id) AS rental_count
    FROM customer c
    LEFT JOIN rental r ON c.customer_id = r.customer_id
    GROUP BY c.customer_id, c.first_name, c.last_name
)
SELECT ____
FROM ____
WHERE rental_count > 30
ORDER BY rental_count DESC;

