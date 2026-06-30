# Write your MySQL query statement below
SELECT
Signups.user_id,
ROUND (IFNULL(SUM(Confirmations.action = 'confirmed') / COUNT(Confirmations.action), 0),2 ) AS confirmation_rate
FROM Signups
LEFT JOIN Confirmations
ON Signups.user_id = Confirmations.user_id
GROUP BY Signups.user_id;