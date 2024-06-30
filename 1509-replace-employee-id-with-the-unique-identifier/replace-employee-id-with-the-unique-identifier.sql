# Write your MySQL query statement below

/*
select e.unique_id , emp.name
from Employees emp left join EmployeeUNI e
on emp.id = e.id
*/
SELECT
EmployeeUNI.unique_id, Employees.name
FROM Employees
LEFT JOIN EmployeeUNI on Employees.id = EmployeeUNI.id