-- 수학 관련 함수

-- ROUND : 반올림
-- ROUND( 숫자, [반올림위치])
SELECT 
    ROUND(1234.5678) AS ROUND,
    ROUND(1234.5678, 0) AS ROUND_0,
    ROUND(1234.5678, 1) AS ROUND_1,
    ROUND(1234.5678, 2) AS ROUND_2,
    ROUND(1234.5678, -1) AS ROUND_MINUS1,
    ROUND(1234.5678, -2) AS ROUND_MINUS2
FROM dual;


-- TRUNC : 버림
-- CEIL : 올림
-- FLOOR : 내림
-- MOD : 나머지 값을 반환

-- 자리수 지정없이 소수점 두자리로 반올림?
-- 숫자*100 -> 반올림 -> 100으로 나누기
-- ROUND(숫자 * 100) / 100
SELECT 
    1234.5678, 
    ROUND(1234.5678 * 100) ,
    ROUND(1234.5678 * 100) / 100
FROM dual;


-- 날짜 관련 함수
-- 날짜 +/- 숫자 : 연산 가능
-- 날짜 + 날짜 : 연산 불가능 (★)
-- 날짜 - 날짜 : 연산 가능

-- SYSDATE : 오라클 서버가 놓인 OS의 현재 날짜 및 시간
SELECT SYSDATE FROM dual;

SELECT 
    SYSDATE AS NOW, 
    SYSDATE-1 AS YESTERDAY,
    SYSDATE+1 AS TOMORROW
FROM dual;

-- to_date('문자') : 문자열 데이터를 날짜형식으로 변환해주는 함수
SELECT 
    SYSDATE - to_date('2022-05-02') "개강날부터 지난날",
    FLOOR(SYSDATE - to_date('2022-05-02')) "개강날부터 지난날 (내림)",
    TRUNC(SYSDATE - to_date('2022-05-02')) "개강날부터 지난날 (버림)"
FROM dual; 


-- ADD_MONTHS : 몇 개월 이후의 날짜를 구해주는 함수
SELECT 
    SYSDATE,
    ADD_MONTHS(SYSDATE, 3)
FROM dual;

SELECT
    empno, INITCAP(ename), hiredate,
    ADD_MONTHS(hiredate, 120) AS WORK10YEAR
FROM emp;

-- 입사한지 35년 4개월이 안된 사원을 출력하기 
-- (현재 날짜와의 비교라서 출력날짜마다 달라짐)
SELECT 
    empno, ename, hiredate, SYSDATE
FROM emp
WHERE ADD_MONTHS(hiredate, 424) > SYSDATE;

-- MONTHS_BETWEEN : 두 날짜간의 개월 수 차이를 구하는 함수
SELECT
    empno, ename, hiredate, SYSDATE,
    MONTHS_BETWEEN(hiredate, SYSDATE) AS MONTHS1,
    MONTHS_BETWEEN(SYSDATE, hiredate) AS MONTHS2,
    TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)) AS MONTH3,
    TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)/12) AS YEAR     -- 몇년 지났는지
FROM emp;


-- NEXT_DAY : 돌아오는 요일을 구해주는 함수
-- LAST_DAY : 달의 마지막 날짜를 구하는 함수
SELECT 
    SYSDATE,
    NEXT_DAY(SYSDATE, '월요일'),
    NEXT_DAY(SYSDATE, '화요일'),
    NEXT_DAY(SYSDATE, '화'),
    LAST_DAY(SYSDATE)
FROM dual;


-- 형변환

-- 숫자형태 문자열 데이터는 자동 형변환이 되서 연산됨 ('500' + 500 => 1000 가능)
-- 텍스트 문자열 데이터는 숫자 연산시 자동 형변환이 안됨 ('abc' + 500 => 불가능)

-- TO_CHAR : 날짜/숫자 => 문자로 형변환
-- TO_NUMBER : 문자를 숫자로 형변환
-- TO_DATE

SELECT 
    TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS 현재날짜시간_24h, 
    TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS pm') AS 현재날짜시간_12h,
    TO_CHAR(SYSDATE, 'YYYY/MM/DD HH12:MI:SS pm') AS 현재날짜시간_12h,
    TO_CHAR(SYSDATE, 'YYYY/MM/DD HH12:MI:SS am') AS 현재날짜시간_12h  
FROM dual;

-- DB마다 포맷팅 형태는 달라질 수 있음

SELECT 
    SYSDATE,
    TO_CHAR(SYSDATE, 'MM') AS MM,           -- 05       (월)
    TO_CHAR(SYSDATE, 'MON') AS MON,         -- 5월      (월)
    TO_CHAR(SYSDATE, 'MONTH') AS MONTH,     -- 5월      (월)
    TO_CHAR(SYSDATE, 'DD') AS DD,           -- 04       (일)
    TO_CHAR(SYSDATE, 'D') AS D,             -- 4        (요일 -> 수요일은 4)
    TO_CHAR(SYSDATE, 'DY') AS DY,           -- 수       (요일)
    TO_CHAR(SYSDATE, 'DAY') AS DAY,         -- 수요일   (요일)
    TO_CHAR(SYSDATE, 'YYYY') AS YEAR,       -- 2022     (년)
    TO_CHAR(SYSDATE, 'HH') AS HH            -- 11       (시)
FROM dual;

-- 날짜 데이터를 가공하여 사용이 가능 ( 요일별, 월별, 시간대별 데이터 등등 )

-- 'D' -> 요일 정보를 숫자형태로 출력
SELECT 
    TO_CHAR(TO_DATE('2022-05-08', 'YYYY-MM-DD'), 'D') AS 일, 
    TO_CHAR(TO_DATE('2022-05-09', 'YYYY-MM-DD'), 'D') AS 월,
    TO_CHAR(TO_DATE('2022-05-10', 'YYYY-MM-DD'), 'D') AS 화,
    TO_CHAR(TO_DATE('2022-05-11', 'YYYY-MM-DD'), 'D') AS 수,
    TO_CHAR(TO_DATE('2022-05-12', 'YYYY-MM-DD'), 'D') AS 목,
    TO_CHAR(TO_DATE('2022-05-13', 'YYYY-MM-DD'), 'D') AS 금,
    TO_CHAR(TO_DATE('2022-05-14', 'YYYY-MM-DD'), 'D') AS 토
from dual;


 -- 한글 사용은 큰 따옴표(""), DB마다 다름
SELECT 
    TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일"' )
FROM dual;



-- TO_NUMBER

-- 자동 형변환 됨
SELECT
    1300 - '1500',
    '1300' + 1500
FROM dual;

SELECT
    TO_NUMBER('1,500', '999,999'),
    TO_NUMBER('1,500.123', '999,999.999'),
    TO_NUMBER(
        REPLACE(
            '1,500', 
            ',', 
            ''
        )
    )    
FROM dual;    

-- TO_DATE : 날짜형식으로 변환

SELECT 
    TO_DATE('2018-07-14', 'YYYY-MM-DD') as todate1,
    TO_DATE('20180714', 'YYYY-MM-DD') as totdate2
FROM dual;
-- 출력되는 형태는 tool의 포맷형태대로 출력되는 것이고
-- TO_DATE 함수는 인식할 데이터와, 인식될 형태를 지정해주는 것임

SELECT *
FROM emp
WHERE hiredate > TO_DATE('1981/06/01', 'YYYY/MM/DD');
-- WHERE hiredate > '1981-06-01';   -- 실무에서는 이러한 형태를 더 많이 씀


-- NULL 처리 함수 
-- NVL, NVL2
SELECT
    comm,
    NVL(comm, 0),
    NVL2(comm, 'O', 'X'),   -- NULL 이 아니면 'O', NULL이면 'X' 출력
    NVL2(comm, comm, 0)
FROM emp;

-- 어느쪽이 null 반환값인지 헷갈리면 확인해보자
SELECT NVL2(null, 1, 2) FROM dual; 


-- DECODE, CASE : 상황에 따른 데이터 처리 함수

-- DECODE : 간단한 경우 사용, 다른 DB에 없는 경우 있음
SELECT 
    empno, ename, job, sal,
    DECODE(job,
        'MANAGER', sal * 1.1,
        'SALESMAN', sal * 1.05,
        'ANALYST', sal,             -- job가 'ANALYST'면 sal
        sal * 1.03) AS UPSAL        -- 맨 마지막은 조건에 해당하지 않을 경우 값
FROM emp;

-- CASE : 복잡한 경우 사용 ( DECODE가 표현할 수 없는 방식도 지원)
-- CASE 함수가 DECODE 함수에 비해 범용적으로 사용이 가능함

-- CASE문-1 : 기준 데이터(조건)이 있는 경우
SELECT 
    empno, ename, job, sal,
    CASE job                  
        WHEN 'MANAGER' THEN sal * 1.1
        WHEN 'SALESMAN' THEN sal * 1.05
        WHEN 'ANALYST' THEN sal
        ELSE sal * 1.03         -- 해당하지 않는 경우 값
    END AS UPSAL                -- END : CASE문 종료를 알려줌
FROM emp;
    

-- CASE문-2 : 기준 데이터(조건)이 없는 경우
SELECT 
    empno, ename, comm,
    CASE
        WHEN comm IS NULL THEN '해당사항 없음'    -- return값이 문자형이면 모두 동일하게 문자형으로!
        WHEN comm = 0 THEN '수당없음'             -- columns의 값은 항상 동일한 자료형이어야함
        WHEN comm > 0 THEN '수당 : ' || comm
    END AS COMM_TEXT
FROM emp;

-- 반환값은 같은 자료형으로 출력이 되어야함
-- else 를 사용 안했을 때 else 조건에 만족하는 값은 NULL로 처리됨


-- p174 Q1
SELECT
    empno, 
    CONCAT(SUBSTR(empno, 1, 2),'**') AS MASKING_EMPNO,
    ename,
    REPLACE(ename, SUBSTR(ename, 2, 4), '****') AS MASKING_ENAME
FROM emp
    WHERE LENGTH(ename) = 5;
    
-- p174 Q2
SELECT
    empno, ename, sal, 
    TRUNC(sal/21.5, 2) AS DAY_PAY,
    ROUND(sal/(21.5 * 8), 1) AS TIME_PAY
FROM emp;


-- p175 Q3
SELECT
    empno, ename, hiredate,
    NEXT_DAY(ADD_MONTHS(hiredate, 3), '월') AS R_JOB,
    NVL2(comm, TO_CHAR(comm), 'N/A') AS COMM
FROM emp;


-- p175 Q4
SELECT
    empno, ename, 
    NVL2(mgr,TO_CHAR(mgr), ' ') AS MGR,
    CASE 
        WHEN MGR IS NULL THEN '0000'
        WHEN SUBSTR(MGR, 1, 2) = '75' THEN '5555'
        WHEN SUBSTR(MGR, 1, 2) = '76' THEN '6666'
        WHEN SUBSTR(MGR, 1, 2) = '77' THEN '7777'
        WHEN SUBSTR(MGR, 1, 2) = '78' THEN '8888'
        ELSE TO_CHAR(MGR)
    END AS CHG_MGR
FROM emp;


/*
랭킹 함수 (★★★★★)
- ROW_NUMBER() : 중복없이 전체 순서 지정       (공동 등수 X)
- RANK() : 중복되면 하위랭킹 제외 후 순서 지정 (공동 1등이면, 다음 순위 3등)
- DENSE_RANK() : 중복되면 하나의 랭킹으로 지정 (공동 1등이면, 다음 순위 2등)

over : (공통 정렬 기준)
*/

SELECT 
    sal, 
    ROW_NUMBER() OVER (ORDER BY sal DESC) AS rank1, 
    RANK() OVER (ORDER BY sal DESC) AS rank2, 
    DENSE_RANK() OVER (ORDER BY sal DESC) AS rank3
FROM emp;


-- 7장 다중행함수와 데이터 그룹화

-- 7-1 다중행 함수 : 하나의 열에 출력결과를 담음 (연산은 다중열을 연산함)
SELECT SUM(sal) FROM emp;
SELECT SUM(sal) FROM emp WHERE job = 'MANAGER';

-- 아래 함수 출력 오류 ("단일 그룹함수가 아닙니다") 
SELECT 
    ename,      -- SUM() 함수와 매칭되지 않음
    SUM(sal)
FROM emp;

-- 그룹화를 통해 출력이 가능함 (부서별 합계 출력)
SELECT 
    deptno, 
    SUM(sal)
FROM emp 
GROUP BY deptno;


-- COUNT
SELECT COUNT(*), COUNT(empno), COUNT(comm) FROM emp;

-- ★★★
-- 그룹함수는 항상 NULL을 제외하고 리턴함
-- '*' 사용이유 : NULL값을 포함한 전체 행의 개수를 알고싶을 때는 COUNT(*)을 사용함
-- 또는 Primary_Key 컬럼을 COUNT 하는 방법도 있음

-- AVG : 평균을 구하는 함수 (NULL 값을 제외하고 평균을 구함)
SELECT SUM(comm/14), AVG(comm), AVG(NVL(comm, 0)) FROM emp;
-- NULL 값을 포함해서 평균을 구할때는 NVL 함수를 함께 사용한다.

-- MIN, MAX : 최초, 최대
-- VARIANCE, STDDEV : 분산, 표준편차
SELECT 
    MIN(sal),
    MAX(sal),
    VARIANCE(sal),      -- 분산
    STDDEV(sal)         -- 표준편차
FROM emp;


/*
group by : 값이 같은 행끼리 묶어서 그룹핑
~별(월별, 부서별, 연도별 등등) -> group by 사용
*/

SELECT DISTINCT deptno FROM emp;
SELECT deptno FROM emp GROUP BY deptno;

-- 그룹핑된 컬럼, 그룹함수 외에는 출력 불가
SELECT deptno, job, count(*) FROM emp GROUP BY deptno, job;  -- deptno > job : 하위 그룹핑

/*
년별, 월별
2022/ 1
    / 2
    / 3
    / 4
    / 5
    ...
*/

-- 부서별 급여, 연봉 합계
SELECT 
    deptno, 
    SUM(sal) AS s, 
    SUM(sal*12+ NVL(comm, 0)) AS 부서별총연봉
FROM emp
GROUP BY deptno
ORDER BY s;         -- alias 사용 가능

/*
HAVING - group by 결과의 조건 지정

*/

-- 평균급여가 1000 이상인 부서, 평균 급여 출력
SELECT deptno, AVG(sal) FROM emp 
    WHERE sal >=2000 
GROUP BY deptno; -- => 잘못된 방법, 개인 급여가 2000 이상인 부서의 평균

--올바른 방법
SELECT 
    deptno, avg(sal) 
FROM emp
GROUP BY deptno
    HAVING AVG(sal) >= 2000; -- 그룹핑 하고 나서 평균급여가 2000 이상인 부터


/*
SQL문 실행순서!

        어디에서 (FROM)
        어떻게
         - 조건에 해당하는 데이터만 (WHERE)
         - 그룹핑 (GROUP BY)
         - 그룹핑된 조건 (HAVING)
         출력 컬럼 (SELECT)
         정렬 (ORDER BY)
         
         AS (Alias)도 위 순서에 영향을 받음
*/