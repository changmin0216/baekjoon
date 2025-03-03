SELECT A.ID, IFNULL(B.CHILD_COUNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA AS A LEFT OUTER JOIN (SELECT PARENT_ID, COUNT(*) AS CHILD_COUNT FROM ECOLI_DATA GROUP BY PARENT_ID) AS B
ON A.ID = B.PARENT_ID
ORDER BY 1 ASC