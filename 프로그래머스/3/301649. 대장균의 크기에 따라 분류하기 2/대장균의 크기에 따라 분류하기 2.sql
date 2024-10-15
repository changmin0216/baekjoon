# SELECT ID, (CASE 
#            WHEN CLASS = 1 THEN 'CRITICAL'
#            WHEN CLASS = 2 THEN 'HIGH'
#            WHEN CLASS = 3 THEN 'MEDIUM'
#            WHEN CLASS = 4 THEN 'LOW' END) AS COLONY_NAME
# FROM (
#     SELECT *, NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS CLASS
#     FROM ECOLI_DATA) AS TEMP
# ORDER BY ID ASC


      
SELECT id,
       CASE
           WHEN a.s_rank * 100 / total_count <= 25 THEN 'CRITICAL'
           WHEN a.s_rank * 100 / total_count <= 50 THEN 'HIGH'
           WHEN a.s_rank * 100 / total_count <= 75 THEN 'MEDIUM'
           ELSE 'LOW'
           END AS colony_name
FROM (SELECT *, RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS s_rank, COUNT(*) OVER() AS total_count FROM ecoli_data) a
ORDER BY 1