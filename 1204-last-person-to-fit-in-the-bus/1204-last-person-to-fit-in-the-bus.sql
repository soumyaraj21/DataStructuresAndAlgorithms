# Write your MySQL query statement below
SELECT person_name
FROM Queue as Q1
WHERE
(
    SELECT SUM(weight)
    FROM Queue AS Q2
    WHERE Q2.turn<=Q1.turn
) <= 1000
ORDER BY Q1.turn DESC
LIMIT 1;