# Write your MySQL query statement below
SELECT 
Sales.product_id,
FirstYear.first_year,
Sales.quantity,
Sales.price
FROM Sales
JOIN (SELECT product_id, MIN(year) AS first_year
FROM Sales
GROUP BY product_id) AS FirstYear
ON Sales.product_id = FirstYear.product_id
AND Sales.year = FirstYear.first_year;