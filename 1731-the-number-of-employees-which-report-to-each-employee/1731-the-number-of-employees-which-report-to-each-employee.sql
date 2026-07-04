# Write your MySQL query statement below
SELECT
    Manager.employee_id,
    Manager.name,
    COUNT(*) AS reports_count,
    ROUND(AVG(Worker.age)) AS average_age
FROM Employees AS Worker
JOIN Employees AS Manager
ON Worker.reports_to = Manager.employee_id
GROUP BY
    Manager.employee_id,
    Manager.name
ORDER BY Manager.employee_id;