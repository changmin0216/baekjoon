-- 코드를 작성해주세요

WITH combine  AS (SELECT CATEGORY AS 'tmp', SUM(CODE) AS CODE 
FROM SKILLCODES WHERE CATEGORY = 'Front End'
GROUP BY CATEGORY
UNION
SELECT NAME AS 'tmp', CODE
FROM SKILLCODES WHERE (NAME = 'C#' OR NAME = 'Python'))

# SELECT CASE WHEN ((SKILL_CODE & (
#     SELECT CODE FROM combine WHERE tmp = 'Front End'
# ) != 0) AND (SKILL_CODE & (
#     SELECT CODE FROM combine WHERE tmp = 'Python'
# ) != 0)) THEN 'A' 
# WHEN (SKILL_CODE & (
#     SELECT CODE FROM combine WHERE tmp = 'C#'
# ) != 0) THEN 'B'
# WHEN (SKILL_CODE & (
#     SELECT CODE FROM combine WHERE tmp = 'Front End'
# ) != 0) THEN 'C' END AS 'GRADE', ID, EMAIL  
# FROM DEVELOPERS
# WHERE SKILL_CODE & (SELECT SUM(CODE) FROM combine) != 0 AND GRADE IS NOT NULL
# ORDER BY 1, 2
SELECT * 
FROM (
    SELECT 
        CASE 
            WHEN ((SKILL_CODE & (SELECT CODE FROM combine WHERE tmp = 'Front End') != 0) 
                  AND (SKILL_CODE & (SELECT CODE FROM combine WHERE tmp = 'Python') != 0)) 
                 THEN 'A'
            WHEN (SKILL_CODE & (SELECT CODE FROM combine WHERE tmp = 'C#') != 0) 
                 THEN 'B'
            WHEN (SKILL_CODE & (SELECT CODE FROM combine WHERE tmp = 'Front End') != 0) 
                 THEN 'C'
            ELSE NULL
        END AS GRADE, 
        ID, EMAIL  
    FROM DEVELOPERS
    WHERE SKILL_CODE & (SELECT SUM(CODE) FROM combine) != 0
) AS subquery
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID;