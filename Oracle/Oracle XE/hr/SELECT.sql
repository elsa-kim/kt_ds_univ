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
