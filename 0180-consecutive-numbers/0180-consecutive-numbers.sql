SELECT DISTINCT
    A.num AS ConsecutiveNums
FROM Logs AS A
JOIN Logs AS B
ON A.id + 1 = B.id
JOIN Logs AS C
ON B.id + 1 = C.id
WHERE
A.num = B.num
AND B.num = C.num;