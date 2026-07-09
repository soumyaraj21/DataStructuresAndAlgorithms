# Write your MySQL query statement below
WITH RankedEmployees AS
(
    SELECT
        Employee.name,
        Employee.salary,
        Employee.departmentId,

        DENSE_RANK()
        OVER(
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS salary_rank

    FROM Employee
)

SELECT
    Department.name AS Department,
    RankedEmployees.name AS Employee,
    RankedEmployees.salary AS Salary
FROM RankedEmployees
JOIN Department
ON RankedEmployees.departmentId = Department.id
WHERE salary_rank <= 3;