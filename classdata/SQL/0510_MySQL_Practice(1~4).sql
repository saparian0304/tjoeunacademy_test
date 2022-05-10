-- 1. 전체 직원의 직원명, 부서번호, 부서명 출력
SELECT 
	ename, d.deptno, dname 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 2. 학생명, 전공학과명, 지도교수명
-- (+)를 이용한 outer 조인방식은 불가(Oracle방식)
SELECT
	s.name, s.major1, p.name
FROM student s LEFT JOIN professor p
ON s.profno = p.no;

-- 3. 전체 학생의 학생명, 지도교수명
-- (단, 지도교수가 없는 학생은 지도교수 없음 출력)
SELECT
	s.name, IFNULL(p.name, '지도교수 없음')  -- nvl함수 없음
FROM student s LEFT JOIN professor p
ON s.profno = p.no;

SELECT 
	s.name, COALESCE(p.name, '지도교수 없음') 지도교수명 -- NVL 대체함수 : COALESCE
FROM student s LEFT JOIN professor p
ON s.profno = p.no;

SELECT
	name,
    IFNULL((SELECT 
				-- 서브쿼리 안에는 IFNULL(name, '지도교수X') 적용 안됨. 
                -- -> student.profno값이 null이라 where절이 아예 연산을 못함
				name 				
			FROM professor 
            WHERE student.profno = no
            ), '지도교수 없음'
	) 지도교수명
FROM student;

-- 4. 전체교수의 교수명, 지도학생 수 출력
SELECT 
	p.name, IFNULL(CNT, 0) 지도학생수
FROM professor p LEFT JOIN (
	SELECT
		profno, COUNT(*) CNT
	FROM student
	GROUP BY profno 
    ) v
ON p.no = v.profno;

-- 다른 방식
SELECT 
	p.name, count(profno) 지도학생수
FROM professor p LEFT JOIN student s
ON p.no = s.profno
GROUP BY s.profno, p.name;

-- 다른방식 2 : 스칼라 서브쿼리로 풀어보기, JOIN 사용 X
SELECT 
	name, 
    (SELECT 
		count(*) 
    FROM student 
    WHERE profno = p.no) 지도학생수
FROM professor p;




