


SELECT
    ROUND(
        COUNT(*) * 1.0 /
        (SELECT COUNT(DISTINCT player_id) FROM Activity),
        2
    ) AS fraction
FROM Activity
JOIN (
    SELECT
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) AS FirstLogin
ON Activity.player_id = FirstLogin.player_id
AND Activity.event_date = DATE_ADD(FirstLogin.first_login, INTERVAL 1 DAY);