# Write your MySQL query statement below
WITH DailySales AS
(
SELECT
visited_on,
SUM(amount) AS daily_amount
FROM Customer
GROUP BY visited_on
),
MovingTotal AS
(
SELECT visited_on,
        SUM(daily_amount)
        OVER(
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROW_NUMBER()
        OVER(
            ORDER BY visited_on
        ) AS row_num
    FROM DailySales
)
SELECT
    visited_on,
    amount,
    ROUND(amount / 7, 2) AS average_amount
FROM MovingTotal
WHERE row_num >= 7
ORDER BY visited_on;