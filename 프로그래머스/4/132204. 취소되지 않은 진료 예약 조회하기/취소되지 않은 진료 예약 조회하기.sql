-- 코드를 입력하세요
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
# DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d %H:%i:%s.%f') AS 'APNT_YMD'
FROM APPOINTMENT AS A JOIN PATIENT AS P ON A.PT_NO = P.PT_NO JOIN DOCTOR AS D ON A.MDDR_ID = D.DR_ID
WHERE YEAR(A.APNT_YMD) = 2022 AND MONTH(A.APNT_YMD) = 4 AND DAY(A.APNT_YMD) = 13
AND A.MCDP_CD = 'CS' AND A.APNT_CNCL_YN = 'N'
ORDER BY 6 ASC