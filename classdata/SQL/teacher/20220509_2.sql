-- ���� ����
create user ORCLSTUDY identified by oracle;

alter session set "_oracle_script"=true;

-- ���ӱ��� �ο�
grant create session to orclstudy ;

-- orclstudy�������� testuser�� �ִ� emp���̺��� select ���� �ο�
grant select on testuser.emp to orclstudy;
-- ���� ȸ��
revoke select on testuser.emp from orclstudy;

