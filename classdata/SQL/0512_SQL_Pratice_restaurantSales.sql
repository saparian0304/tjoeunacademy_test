SELECT 
    order_no 주문번호,
    r.reserv_no 예약번호,
    i.item_id 상품번호,
    product_name 상품명,
    quantity 주문수량,
    sales 주문금액
FROM order_info o, reservation r, item i
WHERE r.reserv_no = o.reserv_no 
AND i.item_id = o.item_id;

/*
02 매출분석
전체 상품의 주문건, 총 매출, 평균 매출, 최고 매출, 최저 매출
(count, sum, avg, max, min)       */

SELECT 
    COUNT(order_no) 총주문건, 
    SUM(sales) 총매출합계, 
    ROUND(AVG(sales)) 평균매출, 
    MAX(sales) 최고매출, 
    MIN(sales) 최저매출
FROM order_info;

/*
03 매출 비교분석
예약완료건의 전체 상품의 총 판매량과 
총 매출액, 전용 상품의 판매량, 
전용 상품의 매출액 출력
*/
-- 예약완료 건 : reservation -> cancel 이 no인것
-- 03 매출 비교분석
SELECT 
    COUNT(*) 총판매량,
    SUM(sales) 총매출액,
    COUNT(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) 온라인전용상품주문건,
    sum(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) 온라인전용상품매출합계
FROM reservation r, order_info o, item i
WHERE r.reserv_no = o.reserv_no (+)
AND o.item_id = i.item_id(+)
AND r.cancel = 'N';

-- 03 두번째 표
SELECT 
    COUNT(*) 총판매량,
    SUM(sales) 총매출액,
    COUNT(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) 온라인전용상품주문건,
    sum(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) 온라인전용상품매출합계,
    ROUND(COUNT(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) / count(*) * 100,2) 주문건수비율,
    ROUND(sum(case 
        when i.product_desc = '온라인_전용상품' then sales
        END) / SUM(sales)*100,2) 매출합계비율
        
FROM reservation r, order_info o, item i
WHERE r.reserv_no = o.reserv_no (+)
AND o.item_id = i.item_id(+)
AND r.cancel = 'N';


-- 04 상품별 매출분석
-- 전체 상품별 매출 합계를 높은 매출액 순으로 확인해보자.
SELECT
    i.item_id, i.product_name, sum(sales) 매출합계
FROM order_info o, item i
WHERE o.item_id = i.item_id
GROUP BY i.item_id, i.product_name
ORDER BY 매출합계 DESC;

-- 05 월별 상품 매출 분석 (시계열 분석)
-- 모든 상품의 월별 매출액 출력
SELECT
    년월,
    nvl(sum (case when i.product_name = 'SPECIAL_SET' then sales END),0) SPECIAL_SET, 
    nvl(sum (case when i.product_name = 'PASTA' then sales END),0) PASTA, 
    nvl(sum (case when i.product_name = 'PIZZA' then sales END),0) PIZZA, 
    nvl(sum (case when i.product_name = 'SEA_FOOD' then sales END),0) SEA_FOOD, 
    nvl(sum (case when i.product_name = 'STEAK' then sales END),0) STEAK, 
    nvl(sum (case when i.product_name = 'SALAD_BAR' then sales END),0) SALAD_BAR, 
    nvl(sum (case when i.product_name = 'SALAD' then sales END),0) SALAD,
    nvl(sum (case when i.product_name = 'SANDWICH' then sales END),0) SANDWICH,
    nvl(sum (case when i.product_name = 'WINE' then sales END),0) WINE,
    nvl(sum (case when i.product_name = 'JUICE' then sales END),0) JUICE
FROM item i , (
                SELECT
                    SUBSTR(reserv_date,1,6) 년월,
                    r.reserv_no, o.item_id,
                    o.sales
                FROM reservation r , order_info o
                WHERE r.reserv_no = o.reserv_no (+) ) v
WHERE i.item_id(+) = v.item_id
GROUP BY 년월
ORDER BY 년월;

--06 월별 총매출, 전용상품매출 비교 분석
--월별 총 매출액과 전용 상품 매출액 출력
SELECT
    년월, 
    sum(sales) 매출합계,
    sum(CASE 
        WHEN product_desc = '온라인_전용상품' 
        THEN sales 
        END) SPECIAL_SET
FROM order_info oi, (
    SELECT 
        SUBSTR(reserv_date, 1, 6) 년월, 
        reserv_no
    FROM reservation ) r, item i
WHERE oi.reserv_no = r.reserv_no
AND oi.item_id = i.item_id (+)
GROUP BY 년월
ORDER BY 년월;

-- 07 매출 기여율
--전체 매출 중 전용상품의 매출 기여도가 얼마인지 알아보자.
--기존 월별 추이 분석에 기여율을 추가해 보자.

SELECT
    년월, 
    sum(sales) - sum(CASE 
                    WHEN product_desc = '온라인_전용상품' 
                    THEN sales 
                    END
        ) ETC,
    sum(CASE 
        WHEN product_desc = '온라인_전용상품' 
        THEN sales 
        END) SPECIAL_SET,
     ROUND(sum(CASE 
        WHEN product_desc = '온라인_전용상품' 
        THEN sales 
        END)/ sum(sales) *100, 1) 매출기여율
        
FROM order_info oi, (
    SELECT 
        SUBSTR(reserv_date, 1, 6) 년월, 
        reserv_no
    FROM reservation ) r, item i
WHERE oi.reserv_no = r.reserv_no
AND oi.item_id = i.item_id (+)
GROUP BY 년월
ORDER BY 년월;

--08. 예약 완료/취소건 분석
SELECT
    년월, 
    sum(sales) - sum(CASE 
                    WHEN product_desc = '온라인_전용상품' 
                    THEN sales 
                    END ) ETC,
    sum(CASE 
        WHEN product_desc = '온라인_전용상품' 
        THEN sales 
        END) SPECIAL_SET,
     ROUND(sum(CASE 
        WHEN product_desc = '온라인_전용상품' 
        THEN sales 
        END)/ sum(sales) *100, 1) 매출기여율,
    count(*) 총주문건 ,count(order_no) 예약완료건,
    count(CASE
        WHEN r.cancel = 'Y' THEN r.reserv_NO END) 예약취소건
FROM order_info oi, (
    SELECT 
        SUBSTR(reserv_date, 1, 6) 년월, 
        reserv_no, cancel
    FROM reservation ) r, item i
WHERE oi.reserv_no(+) = r.reserv_no
AND oi.item_id = i.item_id (+)
GROUP BY 년월  ORDER BY 년월;

-- 09 월별 취소율
SELECT
    년월, 
    count(*) 총주문건 ,count(order_no) 예약완료건,
    count(CASE
        WHEN r.cancel = 'Y' THEN r.reserv_NO END) 예약취소건,
    ROUND(count(CASE
        WHEN r.cancel = 'Y' THEN r.reserv_NO END) / count(*) * 100, 1) || '%' 예약취소율
        
FROM order_info oi, (
    SELECT 
        SUBSTR(reserv_date, 1, 6) 년월, 
        reserv_no, cancel
    FROM reservation ) r, item i
WHERE oi.reserv_no(+) = r.reserv_no
AND oi.item_id = i.item_id (+)
GROUP BY 년월  ORDER BY 년월;

-- 10 요일별 매출분석
-- 월별 전용 상품 매출액을 요일별로 구분해 출력
SELECT
    년월, product_name 상품명,
    NVL(sum( case 요일
        when '일' then sales END),0) 일요일,
    NVL(sum( case 요일
        when '월' then sales END),0) 월요일,
    NVL(sum( case 요일
        when '화' then sales END),0) 화요일,
    NVL(sum( case 요일
        when '수' then sales END),0) 수요일,
    NVL(sum( case 요일
        when '목' then sales END),0) 목요일,
    NVL(sum( case 요일
        when '금' then sales END),0) 금요일,
    NVL(sum( case 요일
        when '토' then sales END),0) 토요일
FROM           (SELECT
                SUBSTR(reserv_date,1,6) 년월,
                reserv_date, product_name, sales,
                TO_CHAR(TO_date(reserv_date, 'yyyy-mm-dd'),'dy') 요일
                FROM reservation r, order_info oi, item i
                WHERE r.reserv_no = oi.reserv_no
                AND oi.item_id = i.item_id)
WHERE product_name = 'SPECIAL_SET'
GROUP BY 년월, product_name
ORDER BY 년월;

-- 22.05.13 금


-- 11.월별 전용 상품 실적 순위 분석
-- 월별 전용 상품 매출 1위~3위까지의 지점을 출력
-- rank() over로 순위 지정 (월로 기준, 매출순서로 순위 지정)
-- 11번_3위 이하인 매장
SELECT
    년월, 지점, 매출액, 순위
FROM
    (SELECT 
        SUBSTR(reserv_date,1,6) 년월,
        branch 지점, SUM(sales) 매출액,
        rank() over(PARTITION BY SUBSTR(reserv_date,1,6) ORDER BY sum(sales) desc) 순위
    FROM reservation r, order_info oi
    WHERE r.reserv_no = oi.reserv_no 
    AND oi.item_id = 'M0001'
    
    GROUP BY SUBSTR(reserv_date,1,6), branch
    ORDER BY 년월, 매출액 desc)
WHERE 순위 <= 3;

-- 11번_1위인 지점만매장
SELECT
    년월,지점, 매출액, 순위
FROM
    (SELECT 
        SUBSTR(reserv_date,1,6) 년월,
        branch 지점, 
        SUM(sales) 매출액,
        row_number() over(PARTITION BY SUBSTR(reserv_date,1,6) ORDER BY sum(sales) desc) 순위
    FROM reservation r, order_info oi
    WHERE r.reserv_no = oi.reserv_no 
    AND oi.item_id = 'M0001'
    
    GROUP BY SUBSTR(reserv_date,1,6), branch
    ORDER BY 년월, 매출액 desc) v
WHERE 순위 = 1;

--12. 종합 리포트
-- 분석9와 분석10의 결과를 월별로 합쳐서 리포트를 작성해보자. (union, max)
/*
- union을 하기 위해 빈값을 추가 (컬럼이 반드시 같아야함)
- 빈값을 제거하기 위해 max함수 사용
- 매출월을 기준으로 그룹핑

-- 09 월별 취소율
총 매출 대비 전용 상품의 판매율, 총 예약 건 대비 예약 취소율 추가 (소수점 두번째 반올림)
-- 10 요일별 매출분석
*/
SELECT
    매출월,
    MAX(총매출) 총매출, MAX(전용상품외매출) 전용상품외매출, 
    MAX(전용상품매출) 전용상품매출, MAX(전용상품판매율) 전용상품판매율,
    MAX(총예약건) 총예약건, MAX(예약완료건) 예약완료건, MAX(예약취소건) 예약취소건, 
    MAX(예약취소율) 예약취소율,
    MAX(최대매출지점) 최대매출지점, MAX(지점매출액) 지점매출액
FROM
    ((SELECT
        TO_CHAR(SUBSTR(reserv_no,1,6)) 매출월,
        SUM(sales) 총매출,
        SUM(CASE WHEN item_id != 'M0001' THEN sales END) 전용상품외매출, 
        SUM(CASE item_id WHEN 'M0001' THEN sales END) 전용상품매출,
        ROUND(SUM(CASE WHEN item_id = 'M0001' THEN sales END) / SUM(sales) * 100,1)||'%' 전용상품판매율,
         0 총예약건, 0 예약완료건, 0 예약취소건,'' 예약취소율,  ''최대매출지점, 0 지점매출액
    FROM order_info
    GROUP BY TO_CHAR(SUBSTR(reserv_no,1,6))
    
    UNION
    
    SELECT
        SUBSTR(r.reserv_date,1,6) 년월,0,0,0,'',      
        count(cancel) 총예약건,
        count(CASE cancel WHEN 'N' THEN cancel END),
        count(CASE cancel WHEN 'Y' THEN cancel END),
        ROUND(count(CASE cancel WHEN 'Y' THEN cancel END)/count(cancel) * 100,1)||'%' 예약취소율,
        '', 0
    FROM reservation r, order_info oi
    WHERE oi.reserv_no(+) = r.reserv_no
    GROUP BY SUBSTR(r.reserv_date,1,6)
    )
    UNION 
    
    SELECT
        년월, 0,0,0, '', 0, 0, 0,'' , 지점, 매출액
    FROM
        (SELECT 
            SUBSTR(reserv_date,1,6) 년월,
            branch 지점, 
            SUM(sales) 매출액,
            row_number() over(PARTITION BY SUBSTR(reserv_date,1,6) ORDER BY sum(sales) desc) 순위
        FROM reservation r, order_info oi
        WHERE r.reserv_no = oi.reserv_no 
        AND oi.item_id = 'M0001'
        
        GROUP BY SUBSTR(reserv_date,1,6), branch
        ORDER BY 년월, 매출액 desc) v
    WHERE 순위 = 1)
GROUP BY 매출월
ORDER BY 매출월;




    
