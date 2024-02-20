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





