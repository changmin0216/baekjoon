-- 코드를 입력하세요
SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
FROM REST_INFO AS A JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO 
    GROUP BY FOOD_TYPE
) AS B ON A.FAVORITES = B.FAVORITES and A.FOOD_TYPE = B.FOOD_TYPE
ORDER BY 1 DESC


# SELECT FOOD_TYPE, MAX(FAVORITES) FROM REST_INFO
# GROUP BY FOOD_TYPE