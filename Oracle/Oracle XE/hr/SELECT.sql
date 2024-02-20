-- Single line comment
/*
 * Multi line comment
 */

-- EMPLOYEES 테이블에서 모든 컬럼들의 모든 데이터를 조회
SELECT *
  FROM EMPLOYEES
;

-- EMPLOYEES 테이블에서 EMPLOYEE_ID의 모든 데이터를 조회
SELECT EMPLOYEE_ID
  FROM EMPLOYEES
;

-- EMPLOYEES 테이블에서 EMPLOYEE_ID, FIRST_NAME의 모든 데이터를 조회
SELECT EMPLOYEE_ID
     , FIRST_NAME
  FROM EMPLOYEES
;

-- DEPPARTMENTS 테이블에서 DEPARTMENT_NAME, LOCATION_ID의 모든 데이터를 조회
SELECT DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
;

-- LOCATIONS 테이블에서 모든 컬럼들의 모든 데이터를 조회
SELECT *
  FROM LOCATIONS
;

-- EMPLOYEES 테이블에서 모든 데이터를 LAST_NAME을 기준으로 오름차순 조회 (ORDER BY)
-- PRIMARY KEY로 오름차순 된 상태로 조회
SELECT *
  FROM EMPLOYEES
;

-- LAST_NAME으로 오름차순 조회
SELECT *
  FROM EMPLOYEES
  -- ORDER BY는 SELECT 조회문의 가장 아래쪽에 위치해야 함
 ORDER BY LAST_NAME -- <-- 오름차순 정렬
;

SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME ASC -- <-- 오름차순 정렬
;

/*
 * ASC 혹은 생략 : 오름차순
 * DESC : 내림차순
 */

-- EMPLOYEES 테이블에서 모든 데이터를 LAST_NAME을 기준으로 내림차순 조회 (ORDER BY)
SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME DESC 
;

-- EMPLOYEES 테이블에서 LAST_NAME으로 내림차순 정렬을 하고 FIRST_NAME으로 오름차순 정렬을 해서 모든 데이터를 조회
SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME DESC
     , FIRST_NAME ASC
;
-- ORDER BY 명령은 CPU를 매우 많이 사용하는 키워드

-- EMPLOYEES 테이블에서 SALARY(연봉)로 오름차순 정렬을 하고 FIRST_NAME으로 내림차순 한 뒤 HIRE_DATE(입사일)로 오름차순 정렬하여 모든 데이터 조회
SELECT *
  FROM  EMPLOYEES
  -- ORDER BY는 SELECT 문장의 가장 마지막에 위치 해야 함
 ORDER BY SALARY ASC
     , FIRST_NAME DESC
     , HIRE_DATE ASC
;

-- EMPLOYEES 테이블에서 EMPLOYEE_ID가 101인 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 101
;

-- EMPLOYEES 테이블에서 FIRST_NAME이 "Neena"인 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME = 'Neena'
;

-- EMPLOYEES 테이블에서 SALARY의 값이 6000 보다 큰 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE SALARY > 6000
;

-- EMPLOYEES 테이블에서 COMMISSION_PCT(인센티브)를 0.2보다 크거나 같은 정보를 SALARY로 내림차순 정렬해서 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT >= 0.2
 ORDER BY SALARY DESC 
;

-- EMPLOYEES 테이블에서 COMMISSION_PCT(인센티브)를 0.2보다 크거나 같은 정보를 SALARY로 내림차순 정렬해서
-- EMPLOYEE_ID, FIRST_NAME, EMAIL, SALARY, COMMISSION_PCT만 조회
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , EMAIL
     , SALARY
     , COMMISSION_PCT
  FROM EMPLOYEES
 WHERE COMMISSION_PCT >= 0.2
 ORDER BY SALARY DESC
;

-- DEPARTMENTS(부서정보) 테이블에서 LOCATION_ID(지역번호)가 1700인 부서의 
-- DEPARTMENT_ID(부서정보), DEPARTMENT_NAME(부서명), LOCATION_ID(지역번호)를
-- DEPARTMENT_NAME으로 내림차순 조회
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID = 1700
 ORDER BY DEPARTMENT_NAME DESC 
;

-- DEPARTMENTS 테이블에서 LOCATION_ID가 1500부터 2000 사이에 있는 모든 정보를 조회
SELECT *
  FROM DEPARTMENTS
 WHERE LOCATION_ID BETWEEN 1500 AND 2000
;

-- DEPARTMENTS 테이블에서 MANAGER_ID(부서장 사원의 번호)가 없는 것만 조회
SELECT *
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NULL 
;

-- DEPARTMENTS 테이블에서 MANAGER_ID(부서장 사원의 번호)가 있는 것만 조회
SELECT *
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NOT NULL 
;

-- EMPLOYEES 테이블에서 DEPARTMENT_ID(근무중인 부서번호)가 90이거나 30이거나 60이거나 100인 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (90, 30, 60, 100) -- IN에 넣을 수 있는 비교값은 1000개 까지만 사용
;

-- EMPLOYEES 테이블에서 JOB_ID(직무아이디)가 IT_PROG이거나 AD_VP이거나 FI_ACCOUNT인 
-- EMPLOYEE_ID, JOB_ID, SALARY 조회
SELECT EMPLOYEE_ID
     , JOB_ID
     , SALARY
  FROM EMPLOYEES
 WHERE JOB_ID IN ('IT_PROG', 'AD_VP', 'FI_ACCOUNT')
;

-- EMPLOYEES 테이블에서 JOB_ID(직무아이디)가 IT_PROG이 아니고 AD_VP도 아니고 FI_ACCOUNT도 아닌 
-- EMPLOYEE_ID, JOB_ID, SALARY 조회
SELECT EMPLOYEE_ID
     , JOB_ID
     , SALARY
  FROM EMPLOYEES
 WHERE JOB_ID NOT IN ('IT_PROG', 'AD_VP', 'FI_ACCOUNT')
;

-- LIKE (자리수 체크) - 문자열 검색(CPU 많이 사용)
-- WILD CARD
-- 	   "_" : 아무글자 하나
--     "%" : 포함되어 있음
--     "A%": A로 시작하는 것
--     "%A": A로 끝나는 것
--    "%A%": A가 포함되어 있는 것
-- EMPLOYEES 테이블에서 FIRST_NAME이 5글자인 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '_____'
;

-- EMPLOYEES 테이블에서 FIRST_NAME이 6글자인 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '______'
;

-- EMPLOYEES 테이블에서 FIRST_NAME이 5글자가 아닌 모든 정보를 조회 
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME NOT LIKE '_____'
;

-- EMPLOYEES 테이블에서 EMAIL이 S로 시작하는 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL LIKE 'S%'
;

-- EMPLOYEES 테이블에서 EMAIL이 S로 시작하지 않는 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL NOT LIKE 'S%'
;

-- EMPLOYEES 테이블에서 EMAIL이 'T'로 끝나는 모든 정보 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL LIKE '%T'
;

-- EMPLOYEES 테이블에서 EMAIL이 'T'로 끝나지 않는 모든 정보 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL NOT LIKE '%T'
;

-- EMPLOYEES 테이블에서 EMAIL이 'W'가 포함된 모든 정보 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL LIKE '%W%'
;

-- EMPLOYEES 테이블에서 EMAIL이 'W'가 포함되지 않는 모든 정보 조회
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL NOT LIKE '%W%'
;

-- EMPLOYEES 테이블에서 PHONE_NUMBER가 "2"로 끝나고 
-- SALARY가 5000 이상이며 JOB_ID가 "SA_REP"인 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE '%2'
   AND SALARY >= 5000
   AND JOB_ID = 'SA_REP'
;

-- EMPLOYEES 테이블에서 FIRST_NAME이 6자리이고 JOB_ID가 "AD_PRES"이거나, "IT_PROG"인 모든 정보를 조회
--IN을 이용한 작성
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '______'
   AND JOB_ID IN ('AD_PRES', 'IT_PROG')
;

-- AND와 OR 이용한 작성
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '______'
   AND (JOB_ID = 'AD_PRES'
    OR JOB_ID = 'IT_PROG')
;

-- EMPLOYEES 테이블에서 MANAGER_ID가 NULL이 아니고 COMMISSION_PCT는 NULL이고
-- EMPLOYEE_ID는 200 미만이면서 EMAIL이 "S" 혹은 "D"로 시작하는 모든 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID IS NOT NULL 
   AND COMMISSION_PCT IS NULL 
   AND EMPLOYEE_ID < 200
   AND (EMAIL LIKE 'S%'
    OR EMAIL LIKE 'D%')
;

SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMAIL
     , PHONE_NUMBER
     , HIRE_DATE
     , JOB_ID
     , SALARY
     , COMMISSION_PCT
     , MANAGER_ID
     , DEPARTMENT_ID 
  FROM EMPLOYEES
;

-- 사원 정보 테이블에서 이름과 성, 연봉, 이메일을 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
     , EMAIL
  FROM EMPLOYEES
;

-- 지역정보 테이블에서 도시명이 "Seattle"인 지역의 주소와 우편번호를 조회
SELECT STREET_ADDRESS
     , POSTAL_CODE
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;

-- 모든 사원들의 연봉 총 합, 최대 연봉, 최소 연봉, 평균 연봉, 사원의 수를 조회
SELECT SUM(SALARY)
     , MAX(SALARY)
     , MIN(SALARY)
     , AVG(SALARY)
     , COUNT(EMPLOYEE_ID) -- COUNT 함수의 파라미터는 PK 쓰는 것이 원칙
     , MAX(HIRE_DATE) -- 가장 최근의 입사일자
     , MIN(HIRE_DATE) -- 가장 과거의 입사일자
  FROM EMPLOYEES
;

-- 2007년에 입사한 사원의 수와 평균 연봉을 조회
-- 문자 -> 날짜 변경
SELECT '2007-01-01' -- 날짜 형태의 문자
     , TO_DATE('2007-01-01', 'YYYY-MM-DD')
  FROM DUAL -- DUAL (Dummy 테이블 : 날짜, 시퀀셜할 번호등을 조회)
;

SELECT COUNT(EMPLOYEE_ID)
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('2007-01-01', 'YYYY-MM-DD')
   AND HIRE_DATE <= TO_DATE('2007-12-31', 'YYYY-MM-DD') 
;

-- GROUP BY 이용
-- 부서별 근무중인 부서번호, 연봉의 합계, 최대 연봉, 가장 늦게 입사한 날짜, 가장 일찍 입사한 날짜, 사원의 수 조회
SELECT DEPARTMENT_ID -- GROUP BY 없을 경우 에러(ORA-00937: 단일 그룹의 그룹 함수가 아닙니다)
     , SUM(SALARY)
     , MAX(SALARY)
     , MAX(HIRE_DATE)
     , MIN(HIRE_DATE)
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID -- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다 <-- 이 에러가 나지 않는다
;

-- 사원 정보에서 "직무 아이디" 별 "사원의 수"와 "직무 아이디"를 조회
SELECT JOB_ID
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY JOB_ID
;

-- 사원 정보에서 "성"이 같은 사원들의 "수"와 "성"을 조회
SELECT LAST_NAME
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY LAST_NAME
;

-- 2004년에 입사한 사원들 중 부서번호 별 사원들의 수와 평균연봉, 연봉의 총 합, 부서번호를 조회
SELECT COUNT(EMPLOYEE_ID)
     , AVG(SALARY)
     , SUM(SALARY) 
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('2004-01-01', 'YYYY-MM-DD')
   AND HIRE_DATE <= TO_DATE('2004-12-31', 'YYYY-MM-DD')
 GROUP BY DEPARTMENT_ID
;

-- 사원 정보에서 동일한 "성"이 두명 이상이 있는 사원들만 조회한다
-- "성" 별 사원의 수, "성"
SELECT COUNT(EMPLOYEE_ID)
     , LAST_NAME
  FROM EMPLOYEES
 GROUP BY LAST_NAME
HAVING COUNT(EMPLOYEE_ID) > 1 
;

-- 사원 정보에서 직무 아이디별 사원의 수와 직무 아이디를 조회하는데 사원의 수가 3명 이상인 정보만 조회
SELECT COUNT(EMPLOYEE_ID)
     , JOB_ID
  FROM EMPLOYEES
 GROUP BY JOB_ID
HAVING COUNT(EMPLOYEE_ID) >= 3
;


-- Sub Query

-- 1. 부서명 "IT" 부서에서 근무중인 사원들의 정보를 조회(IT 부서의 부서번호를 모르는 상황)
--  1) IT부서의 부서번호를 찾는다. ==> 60
SELECT DEPARTMENT_ID
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME = 'IT'
;
--  2) 60번 부서에서 일을 하는 사원들의 정보를 조회한다
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 60
;

-- 2. 지역번호가 1700인 부서에서 근무중인 사원들의 모든 정보를 조회(지역번호가 1700인 부서의 번호를 모르는 상황)
--  1) 지역번호가 1700인 번의 부서 번호 조회
SELECT DEPARTMENT_ID -- 10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...
  FROM DEPARTMENTS
 WHERE LOCATION_ID = 1700
;

--  2) 위 부서에서 근무중인 사원들의 모든 정보를 조회
SELECT *
  FROM  EMPLOYEES
 WHERE EMPLOYEES.DEPARTMENT_ID IN (10, 30, 90, 100, 110)
;

-- SUB QUERY 이용
-- * SUB QUERY를 먼저 작성(우리가 알기 위해 필요한 코드를 먼저 작성)
-- 1. 부서명 "IT" 부서에서 근무중인 사원들의 정보를 조회(IT 부서의 부서번호를 모르는 상황)
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
					      FROM DEPARTMENTS
 						 WHERE DEPARTMENT_NAME = 'IT')
;

-- 2. 지역번호가 1700인 부서에서 근무중인 사원들의 모든 정보를 조회(지역번호가 1700인 부서의 번호를 모르는 상황)
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						   FROM DEPARTMENTS
						  WHERE LOCATION_ID = 1700)
;

-- 145번 사원이 부서장인 부서에서 근무중인 사원들의 모든 정보를 조회하는데
--	  결과에서 145번 사원은 제외시킨다
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
						  FROM DEPARTMENTS
						 WHERE MANAGER_ID = 145)
   AND EMPLOYEE_ID != 145
;

-- 직무명이 "Marketing Manager"인 사원의 모든 정보를 조회한다
-- 직무명: 직무정보(JOBS)
-- 사원의 모든 정보: 사원 정보(EMPLOYEES)
-- 알아야 할 정보
--    직무명 : "Marketing Manager"인 직무의 아이디(MK_MAN)
-- 알고싶은 정보
--    사원의 직무아이디가 'MK_MAN' 인 사원의 모든 정보
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = (SELECT JOB_ID
				   FROM JOBS
				  WHERE JOB_TITLE = 'Marketing Manager')
;

-- 도시명이 "Seattle" 인 지역에 존재하는 부서의 모든 정보를 조회한다
SELECT *
  FROM DEPARTMENTS
 WHERE LOCATION_ID = (SELECT LOCATION_ID
					    FROM LOCATIONS
					   WHERE CITY = 'Seattle')
;

-- 대륙명이 "Americas"인 국가 정보를 모두 조회한다
-- 테이블간의 연결은 항상 pk -- fk로 한다
SELECT *
  FROM COUNTRIES
 WHERE REGION_ID = (SELECT REGION_ID
					  FROM REGIONS
					 WHERE REGION_NAME = 'Americas')
;			

-- 도시명이 "Seattle"인 지역에서 근무중인 모든 사원들의 정보를 조회한다
-- 알아야 할 정보 1 : 도시명이 "Seattle"인 지역의 지역번호(1700)
SELECT LOCATION_ID
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;
-- 알아야 할 정보 2 : 지역번호가 1700번인 부서번호(10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...)
SELECT DEPARTMENT_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID =1700
;
-- 알고 싶은 정보 : 10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...이 부서에서 근무중인 사원의 정보
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...)
;

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						  FROM DEPARTMENTS
						 WHERE LOCATION_ID = (SELECT LOCATION_ID
											    FROM LOCATIONS
											   WHERE CITY = 'Seattle'))											   
;

-- 대륙명이 'Europe'인 국가에서 근무하는 모든 사원들의 정보를 조회
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
					 	   FROM DEPARTMENTS
						  WHERE LOCATION_ID IN (SELECT LOCATION_ID
											      FROM LOCATIONS
											     WHERE COUNTRY_ID IN (SELECT COUNTRY_ID
																        FROM COUNTRIES
																       WHERE REGION_ID = (SELECT REGION_ID
																	   				        FROM REGIONS
																					       WHERE REGION_NAME = 'Europe'))))
;

-- INNER JOIN
-- 문법
SELECT A.*, B.* 
  FROM TABLE A
 INNER JOIN TABLE B
    ON A.PK = B.FK
;

-- EMPLOYEES 와 DEPARTMENTS의 모든 정보를 조회
-- 부서에서 근무중인 사원들의 사원정보와 부서정보를 모두 조회
SELECT E.*
     , D.*
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
;

-- 사원들이 근무하는 부서의 이름과 지역의 도시명, 사원들의 이름을 조회한다
SELECT D.DEPARTMENT_NAME 
     , E.FIRST_NAME 
     , L.CITY 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L 
    ON L.LOCATION_ID = D.LOCATION_ID 
;

-- 103번 사원의 이름과 연봉, 사원번호, 부서의 이름, 도시명을 조회한다
SELECT E.FIRST_NAME 
     , E.SALARY 
     , E.EMPLOYEE_ID 
     , D.DEPARTMENT_NAME 
     , L.CITY 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE E.EMPLOYEE_ID = 103
;

-- JOIN을 표현하는 여러가지 단어
-- > JOIN
-- > EQUIP JOIN
-- > NATURAL JOIN
-- > INNER JOIN

-- 사원번호가 150번 이하인 사원들의 이름과 성, 연봉, 직무아이디, 직무명을 조회
SELECT E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
  -- , E.JOB_ID --FK 
     , J.JOB_ID -- PK 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
 WHERE E.EMPLOYEE_ID <= 150
;

-- 부서번호, 부서명, 부서장의 사원번호, 부서장의 이름, 부서장의 성, 부서장의 직무명을 조회
SELECT D.DEPARTMENT_ID 
     , D.DEPARTMENT_NAME 
     , E.EMPLOYEE_ID 
     , E.FIRST_NAME 
     , E.LAST_NAME 
     , J.JOB_TITLE 
  FROM DEPARTMENTS D
 INNER JOIN EMPLOYEES E
    ON E.EMPLOYEE_ID = D.MANAGER_ID 
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
;

-- 대륙명, 국가명, 지역의 도시명을 조회한다
SELECT R.REGION_NAME 
     , C.COUNTRY_NAME 
     , L.CITY 
  FROM REGIONS R
 INNER JOIN COUNTRIES C
    ON C.REGION_ID = R.REGION_ID 
 INNER JOIN LOCATIONS L
    ON L.COUNTRY_ID = C.COUNTRY_ID 
;

-- 사원의 모든 정보와 사원이 근무중인 부서의 이름, 부서가 있는 지역의 도시명, 도시가 있는 국가명, 국가가 있는 대륙명, 직무명을 조회한다
SELECT E.*
     , D.DEPARTMENT_NAME 
     , L.CITY 
     , C.COUNTRY_NAME 
     , R.REGION_NAME 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 INNER JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 INNER JOIN REGIONS R
    ON R.REGION_ID = C.REGION_ID 
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
;

-- 과거에 직무가 변경된 적이 있는 사원들의 모든 정보를 조회
-- 사원들의 모든 정보만 조회 -- JOIN X
-- 						  SUB QUERY O
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
					     FROM JOB_HISTORY)
;					    
 
-- 직무가 변경된 적이 있는 사원의 과거 직무명과 현재 직무명을 조회
SELECT PAST_J.JOB_TITLE
     , JH.START_DATE 
     , JH.END_DATE 
     , NOW_J.JOB_TITLE
     , E.EMPLOYEE_ID 
  FROM EMPLOYEES E
 INNER JOIN JOBS NOW_J -- 현재 직무의 정보
    ON NOW_J.JOB_ID = E.JOB_ID 
 INNER JOIN JOB_HISTORY JH
    ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID 
 INNER JOIN JOBS PAST_J -- 과거 직무의 정보
    ON PAST_J.JOB_ID = JH.JOB_ID 
;

-- 메뉴 출력, 계단식 정보 관리 때 많이 사용
-- 183번 사원의 이름과 상사 정보를 조회한다
SELECT E.FIRST_NAME
     , M.*
  FROM EMPLOYEES E -- 사원정보
 INNER JOIN EMPLOYEES M -- 상사정보
    ON E.MANAGER_ID = M.EMPLOYEE_ID
 WHERE E.EMPLOYEE_ID = 183
;

-- LEFT OUTER JOIN
-- 모든 사원들의 이름, 성, 부서명을 조회한다. 만약 부서에 속해있지 않는 사원이라면 NULL 로 표기한다
-- 예상되는 건 수 : 107건
SELECT *
  FROM EMPLOYEES E
  LEFT OUTER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID  
;

SELECT *
  FROM DEPARTMENTS D
  LEFT OUTER JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
;

-- 근무하는 사원이 없는 부서의 정보를 LEFT OUTER JOIN으로 조회한다
SELECT D.*
  FROM DEPARTMENTS D
  LEFT OUTER JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID IS NULL
;

-- 부서가 존재하지 않는 도시의 이름을 LEFT OUTER JOIN으로 조회한다
SELECT L.CITY 
  FROM LOCATIONS L
  LEFT OUTER JOIN DEPARTMENTS D
    ON L.LOCATION_ID = D.LOCATION_ID
 WHERE D.DEPARTMENT_ID IS NULL 
;

-- 1. 대륙에 존재하는 국가를 모두 조회한다. 국가가 없을 경우 NULL로 표기한다(대륙명과 국가명 조회)
SELECT R.REGION_NAME 
     , C.COUNTRY_NAME 
  FROM REGIONS R
  LEFT OUTER JOIN COUNTRIES C
    ON R.REGION_ID = C.REGION_ID 
;

-- 2. 대륙명별 국가의 수를 모두 조회한다. 국가가 없을 경우 0으로 표기한다
SELECT R.REGION_NAME 
     , COUNT(C.COUNTRY_ID)
  FROM REGIONS R
  LEFT OUTER JOIN COUNTRIES C
    ON R.REGION_ID = C.REGION_ID 
 GROUP BY R.REGION_NAME 
;

-- 3. 직무명별 사원의 수를 모두 조회한다. 사원의 수가 없을 경우 0으로 표기한다
SELECT J.JOB_TITLE
     , COUNT(E.EMPLOYEE_ID) 
  FROM JOBS J
  LEFT OUTER JOIN EMPLOYEES E
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY J.JOB_TITLE 
;    

-- 4. 직무명별 사원의 수를 모두 조회한다. 단, 사원의 수가 2명 이상인 경우만 조회한다
-- (null 데이터까지 보려고 LEFT 쓰는 건데 2명 이상 경우만 고려하므로 INNER 사용해도 됨)
SELECT J.JOB_TITLE
     , COUNT(E.EMPLOYEE_ID)
  FROM JOBS J
  LEFT OUTER JOIN EMPLOYEES E
    ON J.JOB_ID = E.JOB_ID
 GROUP BY J.JOB_TITLE 
HAVING COUNT(E.EMPLOYEE_ID) >= 2 
;   

-- 5. 근무하는 사원이 단 한명도 없는 도시를 조회한다. (LEFT OUTER JOIN)
SELECT L.CITY 
  FROM LOCATIONS L
  LEFT OUTER JOIN DEPARTMENTS D
    ON D.LOCATION_ID = L.LOCATION_ID 
  LEFT OUTER JOIN EMPLOYEES E
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 GROUP BY L.CITY 
HAVING COUNT(E.EMPLOYEE_ID) = 0  
;

/*
SELECT L.CITY 
  FROM LOCATIONS L
  LEFT OUTER JOIN DEPARTMENTS D
    ON D.LOCATION_ID = L.LOCATION_ID 
  LEFT OUTER JOIN EMPLOYEES E
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID IS NULL
   AND D.DEPARTMENT_ID IS NULL 
;
*/

-- INLINE VIEW 문법
-- FROM에 들어가는 () : INLINE VIEW
/*
SELECT COLUMN....
  FROM (SELECT *
  		  FROM TABLE) A
 INNER JOIN (SELECT *
  		  	   FROM TABLE) B
 WHERE ....
*/

-- 사원의 정보를 INLINE VIEW를 이용해 조회한다
SELECT EMPLOYEE_ID
     , SALARY 
  FROM (-- INLINE VIEW로 이용할 SELECT 문장을 먼저 작성
		SELECT EMPLOYEE_ID
		     , FIRST_NAME
		     , LAST_NAME
		     , SALARY
		  FROM EMPLOYEES) TEMP_E
;

-- EMPLOYEES 테이블에서 ROW 3개만 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID <= 102
;
 
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3 -- ROWNUM : 오라클 전용 기능
;


-- EMPLOYEES 테이블에서 연봉을 가장 많이 받는 사원 3명만 조회한다
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3
 ORDER BY SALARY DESC 
;
-- ORDER BY가 가장 마지막에 나오므로 3명 먼저 자른 후 정렬해 이런 방법으로 풀 수 없음

-- INLINE VIEW 이용해서 풀기
SELECT *
  FROM (-- 1. EMPLOYEES 테이블에서 연봉을 기준으로 내림차순 정렬한다
		SELECT *
		  FROM EMPLOYEES
		 ORDER BY SALARY DESC) ORDERED_EMPLOYEES
 WHERE ROWNUM <= 3
;

-- EMPLOYEES 테이블에서 연봉을 가장 적게 받는 사원 3명만 조회한다
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3
 ORDER BY SALARY ASC 
;
-- ORDER BY가 가장 마지막에 나오므로 3명 먼저 자른 후 정렬해 이런 방법으로 풀 수 없음

-- INLINE VIEW 이용해서 풀기
SELECT *
  FROM (SELECT *
          FROM EMPLOYEES
         ORDER BY SALARY ASC) ORDERED_EMPLOYEES_ASC
 WHERE ROWNUM <= 3
;

-- 가장 많은 사원이 근무중인 부서의 모든 정보를 조회한다
-- 부서별 사원의 수 (부서에 사원 존재하지 않는다면 0으로 조회)
SELECT D.*
  FROM (-- 사원의 수로 내림차순 정렬
		SELECT D.DEPARTMENT_ID 
		     , COUNT(E.EMPLOYEE_ID) E_COUNT
		  FROM DEPARTMENTS D
		  LEFT OUTER JOIN EMPLOYEES E
		    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
		 GROUP BY D.DEPARTMENT_ID 
		 ORDER BY E_COUNT DESC) ORDERED_DEPT_EMP_COUNT
 INNER JOIN DEPARTMENTS D 
    ON D.DEPARTMENT_ID = ORDERED_DEPT_EMP_COUNT.DEPARTMENT_ID 
-- 정렬된 데이터에서 1개만 조회
 WHERE ROWNUM = 1
;

SELECT NVL(10000, 0)
     , NVL(NULL, 0) -- NULL일 경우 숫자 0으로 변경(NULL 나올 가능성 있을 때 사용),Oracle 제공 함수
  FROM DUAL 
;

-- 연봉의 총 합이 가장 높은 부서의 모든 정보를 조회한다
-- 정렬된 데이터에서 1개만 조회
SELECT D.*
     , ORDERED_DEPT_SAL.SUM_SALARY
  FROM (-- 부서별 연봉의 총합
	    -- 연봉 총합으로 내림차순 정렬
	    SELECT D.DEPARTMENT_ID 
	         , NVL(SUM(E.SALARY), 0) AS SUM_SALARY
	      FROM DEPARTMENTS D
	      LEFT OUTER JOIN EMPLOYEES E
	        ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
   	  -- WHERE E.EMPLOYEE_ID IS NOT NULL
 	     GROUP BY D.DEPARTMENT_ID 
	     ORDER BY SUM_SALARY DESC) ORDERED_DEPT_SAL
-- 부서의 정보 알기위해 JOIN 해야함
 INNER JOIN DEPARTMENTS D 
    ON D.DEPARTMENT_ID  = ORDERED_DEPT_SAL.DEPARTMENT_ID 
 WHERE ROWNUM <= 10
;

-- 사원의 수가 가장 많은 직무의 모든 정보 상위 3개를 조회한다
SELECT J.*
     , ORDERED_JOB.COUNT_EMPLOYEE
  FROM (SELECT J.JOB_ID 
		     , NVL(COUNT(E.EMPLOYEE_ID), 0) AS COUNT_EMPLOYEE 
		  FROM JOBS J
		  LEFT OUTER JOIN EMPLOYEES E
		    ON J.JOB_ID = E.JOB_ID 
		 GROUP BY J.JOB_ID 
		 ORDER BY COUNT_EMPLOYEE DESC) ORDERED_JOB
 INNER JOIN JOBS J
    ON J.JOB_ID = ORDERED_JOB.JOB_ID
 WHERE ROWNUM <= 3
;
