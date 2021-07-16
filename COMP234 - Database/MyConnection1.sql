Drop Table TIMESHEET;
Drop Table EMPLOYEE;
Drop Table JOB;

--2. Timesheet, Employee and Job
--yes, order is important. Timesheet table was dropped first as it was not a parent table to another i.e no other table depends on it.
-- The employee table was next; dependencies (empID column in TIMESHEET) on this table had been dropped earlier, so it could be deleted
-- Finally, the job table was dropped as dependencies (JobCode in employee table)had been droppe earlier.

CREATE TABLE Job
(JobCode	number(4) primary key,
Description	varchar2(25),
PayRate	number(10,2),
PAYTYPE	varchar2(10))
TABLESPACE users;

CREATE TABLE Employee
(EmpID	number(5) primary key,
SIN	number(9) NOT NULL,
LastName	varchar2(25) NOT NULL,
FirstName	varchar2(25),
Street	varchar2(30),
City	varchar2(25),
Province	char(2),
PostalCode	varchar2(7),
JobCode	number(4) NOT NULL, 
IncomeTax	char(1),
BirthDate	Date,
HireDate	Date,
JobCodeDate	Date,
FOREIGN KEY (JobCode) REFERENCES Job(JobCode))
TABLESPACE users;

CREATE TABLE Timesheet
(EmpID	number(5),
PayWeekEndDate Date,
RegHours number(5,2),
OTimeHours number(5,2),
PRIMARY KEY(EmpID,PayWeekEndDate),
FOREIGN KEY (EmpID) REFERENCES Employee(EmpID))
TABLESPACE users;

INSERT INTO JOB
VALUES('1000',	'Manager',	'5440',	'Salary');
INSERT INTO JOB 
VALUES('2000',	'Cashier',	'11.63',	'Hourly');
INSERT INTO JOB 
VALUES('3000',	'Stockperson',	'8.89',	'Hourly');
INSERT INTO JOB 
VALUES('4000',	'Baker',	'18.91',	'Hourly');
INSERT INTO JOB 
VALUES('5000',	'Butcher',	'19.26',	'Hourly');
INSERT INTO JOB 
VALUES('6000',	'Cleaner',	'6.75',	'Hourly');
INSERT INTO JOB 
VALUES('7000',	'Pharmacist',	'28.17',	'Hourly');
INSERT INTO JOB 
VALUES('8000',	'Assistant Baker',	'12.58',	'Hourly');

INSERT INTO TIMESHEET 
VALUES('72690','23-May-03','36.00','0.00');
INSERT INTO TIMESHEET 
VALUES('52421','23-May-03','22.00','0.00');
INSERT INTO TIMESHEET 
VALUES('85833','23-May-03','37.50','0.50');
INSERT INTO TIMESHEET 
VALUES('81216','23-May-03','40.00','0.00');
INSERT INTO TIMESHEET 
VALUES('33982','23-May-03','40.00','0.00');
INSERT INTO TIMESHEET 
VALUES('32177','23-May-03','40.00','3.75');
INSERT INTO TIMESHEET 
VALUES('51537','23-May-03','27.00','0.00');
INSERT INTO TIMESHEET 
VALUES('41822','23-May-03','40.00','0.00');
INSERT INTO TIMESHEET 
VALUES('33371','23-May-03','40.00','0.00');
INSERT INTO TIMESHEET 
VALUES('72201','30-May-03','18.00','0.00');
INSERT INTO TIMESHEET 
VALUES('52421','30-May-03','40.00','4.50');
INSERT INTO TIMESHEET 
VALUES('85833','30-May-03','22.00','0.00');
INSERT INTO TIMESHEET 
VALUES('33982','30-May-03','38.25','0.00');
INSERT INTO TIMESHEET 
VALUES('32177','30-May-03','40.00','2.25');
INSERT INTO TIMESHEET 
VALUES('41822','30-May-03','38.00','1.25');
INSERT INTO TIMESHEET 
VALUES('33371','30-May-03','40.00','0.00');

INSERT INTO EMPLOYEE
VALUES('97319', '516303417', 'Novak', 'Gerry', '6803 Park Ave.', 'Moose Jaw', 'SK', 'S6H 1X7', '3000', 'N', '24-Aug-86', '07-Jul-03', '07-Jul-03');
INSERT INTO EMPLOYEE
VALUES('33982', '867481381', 'Boychuk', 'Robin', '117 East Broadway', 'Moose Jaw', 'SK', 'S6H 3P5', '5000', 'Y', '04-Mar-71', '11-Oct-98', '11-Oct-98');
INSERT INTO EMPLOYEE
VALUES('51537', '112893584', 'Smith', 'Kim', '9745 University Dr.', 'Regina', 'SK', 'S4P 7A3', '2000', 'Y', '29-Nov-82', '02-Dec-01', '02-Dec-01');
INSERT INTO EMPLOYEE
VALUES('41822', '717505366', 'Miller', 'Chris', '72 Railway Ave.', 'Pense', 'SK', 'S0T 1K4', '2000', 'Y', '15-Nov-68', '19-Feb-85', '19-Feb-85');
INSERT INTO EMPLOYEE
VALUES('3571', '374853129', 'Hashimoto', 'Jo', '386 High Street', 'Tuxford', 'SK', 'S0L 8V6', '1000', 'Y', '23-Jun-56', '20-Mar-80', '30-Aug-99');
INSERT INTO EMPLOYEE
VALUES('85833', '466128562', 'Singh', 'Lindsey', '1216 Willow Cres.', 'Pasqua', 'SK', 'S0H 5T8', '7000', 'Y', '15-Mar-75', '27-Jul-02', '27-Jul-02');
INSERT INTO EMPLOYEE
VALUES('81216', '615917448', 'Hansen', 'Jaimie', '95 Lakeshore Blvd.', 'Caronport', 'SK', 'S0T 3S7', '8000', 'Y', '04-Mar-83', '21-May-02', '21-May-02');
INSERT INTO EMPLOYEE
VALUES('32177', '306114858', 'DaSilva', 'Robbie', '4319 Main St.', 'Moose Jaw', 'SK', 'S6H 2M2', '4000', 'Y', '18-Feb-51', '07-Jul-83', '15-Sep-92');
INSERT INTO EMPLOYEE
VALUES('52421', '936654021', 'O''Day', 'Ashley', '27 High St.', 'Tuxford', 'SK', 'S0L 8V6', '6000', 'Y', '31-Jul-63', '08-Nov-97', '08-Nov-97');
INSERT INTO EMPLOYEE
VALUES('72690', '655971502', 'Wong', 'Jodie', '259 Oslo Square', 'Moose Jaw', 'SK', 'S6H 2H9', '6000', 'N', '01-Jan-87', '26-Aug-03', '26-Aug-03');
INSERT INTO EMPLOYEE
VALUES('33371', '622914429', 'Allen', 'Dennis', '1294 Saskatchewan Dr.', 'Saskatoon', 'SK', 'S4K 9N3', '5000', 'Y', '03-Jun-74', '01-Sep-06', '15-Feb-09');
INSERT INTO EMPLOYEE
VALUES('72201', '635111876', 'Ramirez', 'Kelly', '1015 Brunswick Lane', 'Moose Jaw', 'SK', 'S6H 4T5', '3000', 'N', '29-Sep-86', '26-Aug-03', '26-Aug-03');

CREATE TABLE Earnings
(EmpID	number(5),
PayWeekEndDate	Date,
RegEarnings	number(6,2),
--Earnings at regular pay
OTimeEarnings	number(6,2),
--Earnings at overtime pay (double the regular pay rate)
PRIMARY KEY(EmpID,PayWeekEndDate),
FOREIGN KEY (EmpID, PayWeekEndDate) REFERENCES Timesheet(EmpID, PayWeekEndDate))
TABLESPACE users;

CREATE TABLE Deductions
(EmpID	number(5),
PayWeekEndDate	Date,
EI	number(5,2),
--Employment Insurance 1.5% total pre tax earnings
CPP	number(5,2),
--Canada Pension Plan 2.5% total pre tax earnings
UnionDues	number(5,2),
--5% total pre tax earnings
PensionPlan	number(5,2),
--1% total pre tax earnings
IncomeTax	number(6,2),
--17% total pre tax earnings of employees who pay tax; NULL for employees who don’t pay tax
PRIMARY KEY(EmpID,PayWeekEndDate),
FOREIGN KEY (EmpID, PayWeekEndDate) REFERENCES Earnings(EmpID, PayWeekEndDate))
TABLESPACE users;

--5. Earnings first and the deductions
--Yes, as earnings table is a referenced table to deductions table

-- 6. No.
-- Earnings table references timesheet table, so it is necessary to create Job, Employee, and Timesheet tables first.

INSERT INTO earnings VALUES (33982,'23-May-03',770.4,0);

INSERT INTO earnings VALUES (33982,'30-May-03',736.7,0);

INSERT INTO earnings VALUES (51537,'23-May-03',314.01,0);

INSERT INTO earnings VALUES (41822,'23-May-03',465.2,0);

INSERT INTO earnings VALUES (41822,'30-May-03',441.94,29.08);

INSERT INTO earnings VALUES (33371,'23-May-03',1296,0);

INSERT INTO earnings VALUES (33371,'30-May-03',1296,0);

INSERT INTO earnings VALUES (85833,'23-May-03',1056.38,28.17);

INSERT INTO earnings VALUES (85833,'30-May-03',619.74,0);

INSERT INTO earnings VALUES (81216,'23-May-03',503.2,0);

INSERT INTO earnings VALUES (32177,'23-May-03',756.4,141.83);

INSERT INTO earnings VALUES (32177,'30-May-03',756.4,85.1);

INSERT INTO earnings VALUES (52421,'23-May-03',148.5,0);

INSERT INTO earnings VALUES (52421,'30-May-03',270,60.75);

INSERT INTO earnings VALUES (72690,'23-May-03',243,0);

INSERT INTO earnings VALUES (72201,'30-May-03',160.02,0);

-- Insert records into Deductions table
INSERT INTO Deductions VALUES (33982,'23-May-03',11.56,19.26,38.52,7.7,130.97);

INSERT INTO Deductions VALUES (33982,'30-May-03',11.05,18.42,36.84,7.37,125.24);

INSERT INTO Deductions VALUES (51537,'23-May-03',4.71,7.85,15.7,3.14,53.38);

INSERT INTO Deductions VALUES (41822,'23-May-03',6.98,11.63,23.26,4.65,79.08);

INSERT INTO Deductions VALUES (41822,'30-May-03',7.07,11.78,23.55,4.71,80.07);

INSERT INTO Deductions VALUES (33371,'23-May-03',19.44,32.4,64.8,12.96,220.32);

INSERT INTO Deductions VALUES (33371,'30-May-03',19.44,32.4,64.8,12.96,220.32);

INSERT INTO Deductions VALUES (85833,'23-May-03',16.27,27.11,54.23,10.85,184.37);

INSERT INTO Deductions VALUES (85833,'30-May-03',9.3,15.49,30.99,6.2,105.36);

INSERT INTO Deductions VALUES (81216,'23-May-03',7.55,12.58,25.16,5.03,85.54);

INSERT INTO Deductions VALUES (32177,'23-May-03',13.47,22.46,44.91,8.98,152.7);

INSERT INTO Deductions VALUES (32177,'30-May-03',12.62,21.04,42.08,8.42,143.06);

INSERT INTO Deductions VALUES (52421,'23-May-03',2.23,3.71,7.43,1.49,25.25);

INSERT INTO Deductions VALUES (52421,'30-May-03',4.96,8.27,16.54,3.31,56.23);

INSERT INTO Deductions VALUES (72690,'23-May-03',3.65,6.08,12.15,2.43,null);

INSERT INTO Deductions VALUES (72201,'30-May-03',2.4,4,8,1.6,null);

Select * from Earnings;
Select * from Earnings, Deductions;
Select * from Dual;
Describe Deductions;
Describe Dual;
--A DUAL utility table in Oracle with only 1 row and 1 column. It is used to perform a number of arithmetic operations and can be used generally where one needs to generate a known output.

SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;
     
UPDATE Employee 
SET 
    Province = 'NL'
WHERE
   Province = 'NF';
    

DELETE FROM Employee  
    where INCOMETAX = 'N';
    
