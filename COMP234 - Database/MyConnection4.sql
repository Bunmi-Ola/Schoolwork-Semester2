 --1a
CREATE INDEX EmployeeLastName
ON EMPLOYEE (LASTNAME);

--1b
CREATE INDEX EmployeeJob
ON EMPLOYEE (EMPID);

--Which one of these scenarios is a better fit for an index
--EMPID: MySQL requires indexes on foreign keys and referenced keys so that foreign key checks can be fast and not require a table scan
--- so  in the referencing table, an index list the foreign key columns in the first columns in the same order.

--2
SELECT * from all_indexes;

--3
DROP INDEX EmployeeLastName;

--4
CREATE SEQUENCE JobSEQ
START WITH 8001
INCREMENT BY 3
MAXVALUE 9000
CACHE 10
NOCYCLE;


insert into JOB (JOBCODE) values(JobSEQ.nextVal);

INSERT INTO JOB (JOBCODE,DESCRIPTION,PAYRATE, PAYTYPE)
VALUES (JobSEQ.nextval,'Baker','20', 'Hourly');

--5
commit work;

--6
SELECT JOBCODE from JOB
where DESCRIPTION = 'Baker' AND PAYRATE = '20';

SELECT current_value   
FROM sys.sequences  
WHERE name = 'JobSEQ' ;  

--7
INSERT INTO JOB (JOBCODE,DESCRIPTION,PAYRATE, PAYTYPE)
VALUES (JobSEQ.nextval, 'security officer', '10.38', 'Hourly');

CREATE SEQUENCE EmployeeSEQ
START WITH 98000
INCREMENT BY 25
MAXVALUE 99999;

--select JobSEQ.NEXTVAL from dual;

INSERT INTO EMPLOYEE
VALUES(EmployeeSEQ.nextval, '716342711', 'Terry ', 'LeBlanc', '4285 Coteau St.', 'Moose Jaw', 'SK', 'S6H 9E5', 
(SELECT JOBCODE from JOB where DESCRIPTION = 'security officer'), 'Y', '18-Jan-69', '20-Oct-05', '20-Oct-05');

--8
commit work;

--9
ALTER SEQUENCE JobSEQ INCREMENT BY 5;

--10
SELECT * FROM USER_Tables, USER_Views, USER_Indexes, USER_Sequences ;

--11
DROP SEQUENCE JobSEQ;

DROP SEQUENCE EmployeeSEQ;

DELETE FROM JOB 
WHERE JOBCODE = 8001;

DELETE FROM JOB 
WHERE JOBCODE = 8004;

DELETE FROM JOB 
WHERE JOBCODE = 8007;

DELETE FROM EMPLOYEE 
WHERE EMPID = 98050;

DELETE FROM JOB 
WHERE JOBCODE = 8007;


--12
COMMIT WORK;
----
