# Write your MySQL query statement below
SELECT Manager.name
FROM Employee AS Employee
JOIN Employee AS Manager
ON Employee.managerId = Manager.id
GROUP BY Manager.id, Manager.name
HAVING COUNT(*) >= 5;