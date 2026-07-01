SELECT
    ROUND(
        SUM(Delivery.order_date = Delivery.customer_pref_delivery_date) * 100.0
        / COUNT(*),
        2
    ) AS immediate_percentage
FROM Delivery
JOIN (
    SELECT
        customer_id,
        MIN(order_date) AS first_order
    FROM Delivery
    GROUP BY customer_id
) AS FirstOrders
ON Delivery.customer_id = FirstOrders.customer_id
AND Delivery.order_date = FirstOrders.first_order;