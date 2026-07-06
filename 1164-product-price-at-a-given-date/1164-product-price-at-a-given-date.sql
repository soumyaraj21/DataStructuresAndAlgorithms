SELECT
    Products.product_id,
    Products.new_price AS price
FROM Products
JOIN
(
    SELECT
        product_id,
        MAX(change_date) AS latest_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) AS LatestPrice
ON Products.product_id = LatestPrice.product_id
AND Products.change_date = LatestPrice.latest_date

UNION

SELECT
    product_id,
    10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';