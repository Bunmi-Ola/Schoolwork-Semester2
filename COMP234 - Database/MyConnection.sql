SELECT "LASTNAME", "FIRSTNAME" from EMPLOYEE 
 WHERE
   EMPID = '33371';
      
 SELECT "LASTNAME", "FIRSTNAME" from EMPLOYEE 
 WHERE
   EMPID = '52421';
   
 SELECT "EMPID" from EARNINGS
 WHERE
   REGEARNINGS > '25' and 
   PAYWEEKENDDATE = '30-MAY-03';
   
 SELECT  "LASTNAME", "FIRSTNAME" FROM EMPLOYEE
WHERE STREET LIKE '__8_6%';

SELECT AVG(INCOMETAX )
FROM Deductions
WHERE PAYWEEKENDDATE = '23-MAY-03';

SELECT COUNT(EMPID)
FROM EMPLOYEE;