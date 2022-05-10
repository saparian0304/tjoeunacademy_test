-- oracle, mysql 차이점

-- 날짜
-- 오늘날짜 : now()
SELECT now(), current_date, curdate(), current_date();
SELECT sysdate();

-- 날짜 사이의 일자수 : datediff('yyyy-mm-dd', 'yyyy-mm-dd')
SELECT datediff('2022-05-10', '2022-05-02');
SELECT datediff('2022-12-25', now());
-- 년, 월, 일, 요일
SELECT YEAR(now()), MONTH(now()), DAY(now()), DAYOFWEEK(now());
-- 이전일, 이후일
SELECT DATE_ADD(now(), interval 100 day);  -- day, hour, minute,...
SELECT DATE_SUB(now(), interval 100 day);  -- day, hour, minute,...
SELECT DATE_ADD(now(), interval -100 day);
-- 날짜 포맷팅
SELECT DATE_FORMAT(now(), '%Y년 %m월 %d일 %h:%i:%s');
SELECT DATE_FORMAT(now(), '%Y/%m/%d %h시%i분%s초');
-- null처리
SELECT salary, bonus, salary+IFNULL(bonus, 0) FROM emp;
-- 조건
-- 1학년이면 신입생, 그렇지 않으면 재학생
SELECT grade, IF(grade=1, '신입생', '재학생') FROM student;

-- 페이징 처리
SELECT COUNT(*) FROM student;
-- 한 페이지당 5명씩 출력, 총 4페이지
-- LIMIT 시작인덱스, 갯수
-- LIMIT 갯수
SELECT * FROM student ORDER BY grade LIMIT 0, 5;
SELECT * FROM student ORDER BY grade LIMIT 5, 5;
SELECT * FROM student ORDER BY grade LIMIT 10, 5;

-- squence 없음 -> auto increment (자동증가)
-- 컬럼에 제약조건으로 설정해야함
-- test table 생성함
-- 열 속성 : number(PK, AI), name
INSERT INTO test (name) VALUES ('홍길동');
SELECT * FROM test;

-- concat() -> 인수의 개수에 제한이 없음 (오라클과 다름)
SELECT CONCAT(ename, ':', job, ':', empno) FROM emp; 

-- INLINE VIEW에서 as (Alias)를 사용하면 에러가 남 (Oracle)
-- MySQL은 사용 가능
SELECT * FROM (
		SELECT ename FROM emp
        ) a;        
SELECT * FROM (
		SELECT ename FROM emp
        ) as a;