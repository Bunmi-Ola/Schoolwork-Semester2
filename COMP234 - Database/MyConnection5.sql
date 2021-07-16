
--1
select LASTNAME as Surname,  HIREDATE, (CURRENT_DATE - HIREDATE )/(365.25) AS "Years" from EMPLOYEE;

--2
SELECT TO_CHAR (SYSDATE, 'DD-MON-YYYY HH24:MI:SS') "NOW",
ROUND(TO_DATE (SYSDATE, 'DD-MON-YYYY HH24:MI:SS'))"Round Date",
ROUND(TO_DATE (SYSDATE, 'DD-MON-YYYY HH24:MI:SS'), 'MONTH')"Round Month"
FROM DUAL;

--3
SELECT REGEARNINGS, round(REGEARNINGS*1.04,2) AS "Increased Regular", OTIMEEARNINGS, 
round(OTIMEEARNINGS*1.04,2) as "Increase Overtime" from EARNINGS;

--4
select count (EMPID) as EMPLOYEES, round(count (EMPID)/5, 0) as CARS, MOD(count (EMPID), 5)as TAXI       
from EMPLOYEE;


--5
select LASTNAME,
DECODE(CITY, 'Moose Jaw', 'Local Calling', 'Long Distance') decoded
from EMPLOYEE;

--6
Select POSTALCODE, substr(POSTALCODE, 1, 3) || ' & ' || substr(POSTALCODE, 5, 3)as "Break Up"
from EMPLOYEE;

--7
select  chr(66)"C",chr(97)"C", trim(chr(97) from trim(chr(66) from description ))"Trimmed" from job;

--8
select (EMPLOYEE.LASTNAME||' earns $'||JOB.PAYRATE||' an hour but wants $'||JOB.PAYRATE*3) as "Dream Pay" from employee 
INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE 
where JOB.PAYTYPE ='Hourly';

--9
select RPAD('Merry Christmas', 27, ' Ho!') as Greetings FROM dual;

--10
select LASTNAME from EMPLOYEE;

SELECT LASTNAME , LENGTH(LASTNAME) AS "LENGTH(LASTNAME)" FROM EMPLOYEE
where LENGTH(LASTNAME) >= 7;

--11
select FirstName ||' '||Lastname as "Full Name", INSTR((FirstName ||' '||Lastname),' ',  1)AS Position from EMPLOYEE;

--12
SELECT ASCII('O') AS "First", ASCII('O') AS "Last" from dual;

COMMIT WORK;



--13
SELECT FIRSTNAME, LASTNAME, LPAD(PAYRATE, 15, '$') AS "Hourly Pay Rate" from employee 
INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE 
where JOB.PAYTYPE ='Hourly';

--14
select replace ('DB2 commands permit you to manipulate database data.','DB2','SQL') AS "Replace words in sentence: " from dual;

--15
SELECT SQRT(25),  power(reghours,4) from TIMESHEET
WHERE EMPID = ANY (SELECT EMPID FROM EMPLOYEE WHERE FIRSTNAME = 'Lindsey')
AND PAYWEEKENDDATE = '30-MAY-03';

