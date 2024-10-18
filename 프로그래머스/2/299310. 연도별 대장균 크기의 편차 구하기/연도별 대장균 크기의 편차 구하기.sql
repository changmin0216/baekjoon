-- 코드를 작성해주세요
SELECT 
    YEAR(A.DIFFERENTIATION_DATE) AS 'YEAR', 
    (B.MAX_SIZE - A.SIZE_OF_COLONY) AS 'YEAR_DEV', 
    A.ID
FROM ECOLI_DATA AS A JOIN (
    SELECT YEAR(DIFFERENTIATION_DATE) AS 'YEAR', MAX(SIZE_OF_COLONY) AS 'MAX_SIZE' 
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
) AS B
ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY 1 ASC, 2 ASC