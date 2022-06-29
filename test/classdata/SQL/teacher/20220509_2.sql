-- 계정 생성
create user ORCLSTUDY identified by oracle;

alter session set "_oracle_script"=true;

-- 접속권한 부여
grant create session to orclstudy ;

-- orclstudy계정에게 testuser에 있는 emp테이블의 select 권한 부여
grant select on testuser.emp to orclstudy;
-- 권한 회수
revoke select on testuser.emp from orclstudy;

