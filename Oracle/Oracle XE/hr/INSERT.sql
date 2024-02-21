-- HR 회사에 신규 인력이 입사하였다
-- 이름은 민창
-- 성은 장
-- 이메일은 MCJANG
-- 연락처는 010-1111-2222
-- 입사일은 현재날짜(오늘)
-- 직무아이디 IT_PROG
-- 연봉 100000
-- 인센티브: NULL
-- 상사의 사원 번호: 100
-- 부서번호: 60
-- 위 인력을 EMPLOYEES 테이블에 넣어야 한다
INSERT INTO EMPLOYEES (
  EMPLOYEE_ID
, FIRST_NAME
, LAST_NAME
, EMAIL
, PHONE_NUMBER
, HIRE_DATE
, JOB_ID
, SALARY
, COMMISSION_PCT
, MANAGER_ID
, DEPARTMENT_ID)
VALUES (
-- 컬럼 타입과 값 일치하지 않을 경우 ORA-01722: 수치가 부적합합니다
-- Oracle Query Optimizer가 값을 타입에 맞추어서 보정 해준다(정확한 포멧일때: 숫자타입에 '숫자', 문자타입에 숫자)
  208--   EMPLOYEE_ID
-- ORA-12899: "HR"."EMPLOYEES"."FIRST_NAME" 열에 대한 값이 너무 큼(실제: 21, 최대값: 20)
-- oracle은 타입의 크기를 바이트로 계산
-- 영어, 숫자, 공백을 포함한 특수기호: 1byte
-- 위의 케이스가 아닌 모든 문자들: 3byte
-- ==> 인코딩때문(UTF-8)
, '민창'-- , FIRST_NAME
, '장'-- , LAST_NAME
, 'MCJANG2'-- , EMAIL
, '010-1111-2222'-- , PHONE_NUMBER
, SYSDATE-- , HIRE_DATE
, 'IT_PROG'-- , JOB_ID
, 100000-- , SALARY
, NULL-- , COMMISSION_PCT
, 100-- , MANAGER_ID
, 60)-- , DEPARTMENT_ID
;

-- hr 회사에 신규 사업 부서가 생겼다
-- 부서번호: 300
-- 부서명: R&D
-- 부서장 사원 번호: null
-- 지역번호: 1700
INSERT INTO DEPARTMENTS (
  DEPARTMENT_ID
, DEPARTMENT_NAME
, MANAGER_ID
, LOCATION_ID) 
VALUES (
  301--  DEPARTMENT_ID
, 'R&D'--, DEPARTMENT_NAME
, NULL--, MANAGER_ID
, 1700)--, LOCATION_ID
;

COMMIT;

ROLLBACK;

SELECT *
  FROM DEPARTMENTS
;
-- INSERT, UPDATE, DELETE
-- : 테이블 데이터에 영향을 주는 QUERY
-- 실수로 적용한 쿼리의 실행결과를 테이블로 바로 적용되지 않도록 방어해주는 최소한의 방어기재
-- MANUAL TRANSACTION
-- TRANSACTION - COMMIT, ROLLBACK
--		COMMIT: INSERT, UPDATE, DELETE 쿼리의 결과를 테이블에 적용(영구적)
--		ROLLBACK: INSERT, UPDATE, DELETE 쿼리의 결과를 취소
-- MANUAL TRANSACTION이 적용된 상태에서 INSERT, UPDATE, DELETE를 수행하면
-- COMMIT 하기 전까지는 테이블에 적용되지 않는다.
-- AUTO TRANSACTION : INSERT, UPDATE, DELETE를 수행하면 즉시 테이블에 적용.
